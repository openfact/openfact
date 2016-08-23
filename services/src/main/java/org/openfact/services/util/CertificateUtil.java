package org.openfact.services.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.ws.rs.core.MultivaluedMap;

public class CertificateUtil {
	public static boolean writeFile(byte[] content, String filename) throws IOException {
		System.out.println(">>> writing #{} bytes to: {} " + content.length + " , " + filename);
		File file = new File(filename);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fop = new FileOutputStream(file);
		fop.write(content);
		fop.flush();
		fop.close();
		System.out.println(">>> writing complete: {} ::" + filename);
		return true;
	}

	public static String getFileName(MultivaluedMap<String, String> headers) {
		String[] contentDisposition = headers.getFirst("Content-Disposition").split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {
				String[] name = filename.split("=");
				String finalFileName = sanitizeFilename(name[1]);
				return finalFileName;
			}
		}
		return "unknown";
	}

	public static String sanitizeFilename(String s) {
		return s.trim().replaceAll("\"", "");
	}

}
