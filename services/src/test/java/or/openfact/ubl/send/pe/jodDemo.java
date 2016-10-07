package or.openfact.ubl.send.pe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jodd.io.ZipBuilder;

public class jodDemo {

	public jodDemo() {
		zipEntry();
	}

	private void send(byte[] zip) {

		try {
			FileOutputStream os = new FileOutputStream(new File("/home/lxpary/testJod.zip"));
			os.write(zip);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void zipEntry() {

		try {
			byte[] bytes = getBytesFromFile();
			byte[] zip = ZipBuilder.createZipInMemory().addFolder("dummy/").add(bytes).path("invoice.xml").save()
					.toBytes();

			send(zip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private byte[] getBytesFromFile() throws IOException {
		List byteList = new ArrayList();

		FileInputStream is = new FileInputStream(new File("/home/lxpary/invoice.xml"));
		int readLen = -1;
		byte[] buff = new byte[4096];

		while ((readLen = is.read(buff)) != -1) {
			copyBytesToList(buff, readLen, byteList);
		}

		is.close();
		return getByteArrayFromList(byteList);
	}

	private void copyBytesToList(byte[] buff, int len, List byteList) {
		for (int i = 0; i < len; i++) {
			byteList.add(Byte.toString(buff[i]));
		}
	}

	private byte[] getByteArrayFromList(List byteList) {
		byte[] buff = new byte[byteList.size()];

		for (int i = 0; i < byteList.size(); i++) {
			buff[i] = Byte.parseByte((String) byteList.get(i));
		}
		return buff;
	}

	public static void main(String[] args) {

		new jodDemo();

	}
}
