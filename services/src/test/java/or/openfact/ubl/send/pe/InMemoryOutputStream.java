package or.openfact.ubl.send.pe;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Writes the content to memory.
 *
 */
public class InMemoryOutputStream extends OutputStream {
	
	// As we cannot know the size of the zip file that is being created, 
	// we cannot maintain a byte array. We will copy all the bytes that 
	// gets passed in the write() method to a List. Once all writing is done,
	// we can create a byte array from this List and this will be the content
	// of the zip file
	private List byteList;
	
	// flag to keep track if the outputstream is closed
	// no further write operations should be performed once this stream is closed
	private boolean closed;
	
	public InMemoryOutputStream() {
		byteList = new ArrayList();
		closed = false;
	}
	
	public void write(int b) throws IOException {
		if (closed) {
			throw new IOException("trying to write on a closed output stream");
		}
		
		byteList.add(Integer.toString(b));
	}
	
	public void write(byte[] b) throws IOException {
		if (b == null) return;
		write(b, 0, b.length);
	}
	
	public void write(byte[] b, int off, int len) throws IOException {
		if (closed) {
			throw new IOException("trying to write on a closed output stream");
		}
		
		if (b != null && len > 0) {
			for (int i = 0; i < len; i++) {
				byteList.add(Byte.toString(b[i]));
			}
		}
	}
	
	public byte[] getZipContent() {
		if (byteList.size() <= 0) {
			return null;
		}
		
		byte[] zipContent = new byte[byteList.size()];
		
		for (int i = 0; i < byteList.size(); i++) {
			zipContent[i] = Byte.parseByte((String)byteList.get(i));
		}
		
		return zipContent;
	}
	
	public void close() throws IOException {
		closed = true;
	}
}