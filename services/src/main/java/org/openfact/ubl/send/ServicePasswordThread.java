package org.openfact.ubl.send;

import java.util.Map;

public  class ServicePasswordThread {
	public static ThreadLocal<Map<String, String>> configThread;

	public ServicePasswordThread(Map<String, String> config) {
		configThread = new ThreadLocal();
		configThread.set(config);
	}
}
