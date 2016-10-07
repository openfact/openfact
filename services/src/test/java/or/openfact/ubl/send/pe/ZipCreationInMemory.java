package or.openfact.ubl.send.pe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import net.lingala.zip4j.io.ZipOutputStream;
//import net.lingala.zip4j.model.ZipParameters;
//import net.lingala.zip4j.util.Zip4jConstants;

public class ZipCreationInMemory {

	public ZipCreationInMemory() {
		testZipCreationInMemory();
	}

	private void testZipCreationInMemory() {
		try {
			byte[] bytesToWrite = getBytesFromFile();

			InMemoryOutputStream inMemoryOutputStream = new InMemoryOutputStream();

//			ZipOutputStream zos = new ZipOutputStream(inMemoryOutputStream);
//
//			ZipParameters parameters = new ZipParameters();
//			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
//			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
//			parameters.setFileNameInZip("invoice.xml");
//			parameters.setRootFolderInZip("dummy/");
//			parameters.setSourceExternalStream(true);
//
//			zos.putNextEntry(null, parameters);
//			zos.write(bytesToWrite);
//			zos.closeEntry();
//			zos.finish();
//			zos.close();

			// Write contents in our InMemoryOutputStream to a zip file to test
			// if this worked
			writeContentsToZipFile(inMemoryOutputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeContentsToZipFile(InMemoryOutputStream inMemoryOutputStream) throws IOException {
		byte[] zipContent = inMemoryOutputStream.getZipContent();

		FileOutputStream os = new FileOutputStream(new File("/home/lxpary/test4j.zip"));
		os.write(zipContent);
		os.close();
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
		new ZipCreationInMemory();
	}

}