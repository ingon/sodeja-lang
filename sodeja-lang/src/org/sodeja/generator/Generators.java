package org.sodeja.generator;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.sodeja.functional.Function0;
import org.sodeja.functional.Maybe;

public class Generators {
	public static Generator<Character> readerGenerator(final Reader reader) throws IOException {
		int val = reader.read();
		if(val == -1) {
			return null;
		}
		Character value = Character.valueOf((char) val);
		return new Generator<Character>(value, new Function0<Maybe<Character>>() {
			@Override
			public Maybe<Character> execute() {
				try {
					int val = reader.read();
					if(val == -1) {
						return Maybe.nothing();
					}
					return Maybe.just((char) val);
				} catch(IOException exc) {
					throw new RuntimeException(exc);
				}
			}});
	}
	
	public static <T> List<T> readFully(Generator<T> generator) {
		List<T> vals = new ArrayList<T>();
		Generator<T> temp = generator;
		while(temp != null) {
			vals.add(temp.value());
			temp = temp.next();
		}
		return vals;
	}
}