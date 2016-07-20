package org.openfact.common.util;

import java.util.Date;

public class Time {

	private static int offset;

	public static int currentTime() {
		return ((int) (System.currentTimeMillis() / 1000)) + offset;
	}

	public static long currentTimeMillis() {
		return System.currentTimeMillis() + (offset * 1000);
	}

	public static Date toDate(int time) {
		return new Date(((long) time) * 1000);
	}

	public static long toMillis(int time) {
		return ((long) time) * 1000;
	}

	public static int getOffset() {
		return offset;
	}

	public static void setOffset(int offset) {
		Time.offset = offset;
	}

}
