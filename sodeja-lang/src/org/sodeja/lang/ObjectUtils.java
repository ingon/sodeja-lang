package org.sodeja.lang;

public final class ObjectUtils {
	private ObjectUtils() {
	}
	
    public static boolean equalsIfNull(Object obj1, Object obj2) {
        if(obj1 == obj2) {
            return true;
        }
        if((obj1 == null || obj2 == null)) {
            return false;
        }
        return obj1.equals(obj2);
    }
    
    public static boolean equalIfNotNull(Object obj1, Object obj2) {
        if(obj1 != null) {
            return obj1.equals(obj2);
        }
        if(obj2 != null) {
            return obj2.equals(obj1);
        }
        return false;
    }
    
    public static boolean equalIfFirstNotNull(Object obj1, Object obj2) {
        if(obj1 == null) {
            return false;
        }
        return equalsIfNull(obj1, obj2);
    }
}
