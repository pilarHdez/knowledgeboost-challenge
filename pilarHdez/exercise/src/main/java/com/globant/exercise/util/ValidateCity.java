package com.globant.exercise.util;

public class ValidateCity {
    public static boolean city(String text) {
        return text.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }
}
