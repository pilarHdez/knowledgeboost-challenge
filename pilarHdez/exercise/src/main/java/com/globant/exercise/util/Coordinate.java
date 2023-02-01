package com.globant.exercise.util;

public class Coordinate {
    private static float MIN_LATITUDE = Float.valueOf("-90.0000");
    private static float MAX_LATITUDE = Float.valueOf("90.0000");
    private static float MIN_LONGITUDE = Float.valueOf("-180.0000");
    private static float MAX_LONGITUDE = Float.valueOf("180.0000");

    public static boolean isValidLatitude(float latitude) {
        return latitude >= MIN_LATITUDE && latitude <= MAX_LATITUDE;
    }

    public static boolean isValidLongitude(float longitude) {
        return longitude >= MIN_LONGITUDE && longitude <= MAX_LONGITUDE;
    }
}
