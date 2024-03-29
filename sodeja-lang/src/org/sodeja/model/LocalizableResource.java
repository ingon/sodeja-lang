package org.sodeja.model;

import java.util.Collection;
import java.util.Locale;

public interface LocalizableResource {
	public String getId();
	public void setId(String id);
	
	public String getLocalizedValue(Locale locale);
	public void setLocalizedValue(Locale locale, String str);
	public Collection<Locale> getAvailableLocales();
}
