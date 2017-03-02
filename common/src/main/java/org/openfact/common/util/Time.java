package org.openfact.common.util;

import java.util.Date;

public class Time {

    private static int offset;

    /**
     * Returns current time in seconds adjusted by adding {@link #offset) seconds.
     * @return see description
     */
    public static int currentTime() {
        return ((int) (System.currentTimeMillis() / 1000)) + offset;
    }

    /**
     * Returns current time in milliseconds adjusted by adding {@link #offset) seconds.
     * @return see description
     */
    public static long currentTimeMillis() {
        return System.currentTimeMillis() + (offset * 1000);
    }

    /**
     * Returns {@link Date} object, its value set to time
     * @param time Time in milliseconds since the epoch
     * @return see description
     */
    public static Date toDate(int time) {
        return new Date(((long) time ) * 1000);
    }

    /**
     * Returns time in milliseconds for a time in seconds. No adjustment is made to the parameter.
     * @param time Time in seconds since the epoch
     * @return Time in milliseconds
     */
    public static long toMillis(int time) {
        return ((long) time) * 1000;
    }

    /**
     * @return Time offset in seconds that will be added to {@link #currentTime()} and {@link #currentTimeMillis()}.
     */
    public static int getOffset() {
        return offset;
    }

    /**
     * Sets time offset in seconds that will be added to {@link #currentTime()} and {@link #currentTimeMillis()}.
     * @param offset Offset (in seconds)
     */
    public static void setOffset(int offset) {
        Time.offset = offset;
    }

}