package com.arash.tictactoe.utils;

public abstract class ArrayUtils {

    public static <T> boolean allMatch(T[] array, T target) {
        if (array == null || array.length == 0 || target == null) {
            return false;
        }
        for (T elem : array) {
            if (!elem.equals(target)) {
                return false;
            }
        }
        return true;
    }
}
