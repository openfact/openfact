package org.openfact.models.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.openfact.models.ModelException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DocumentUtils {

	public static Document getByteToDocument(byte[] document) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document docParse = builder.parse(new ByteArrayInputStream(document));
		docParse.setXmlStandalone(false);
		return docParse;
	}

	public static void getElementToByte(Element element, OutputStream out) {
		try {
			DOMSource source = new DOMSource(element);
			StreamResult result = new StreamResult(out);
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			transformer.transform(source, result);
		} catch (Exception ex) {
			throw new ModelException("Error in convert element to byte");
		}
	}

	public static ByteArrayOutputStream getStringToStream(String document) throws IOException {
		byte[] stringByte = document.getBytes("ISO-8859-1");
		ByteArrayOutputStream bos = new ByteArrayOutputStream(document.length());
		bos.write(stringByte);
		return bos;
	}

	public static byte[] getStreamToBytes(InputStream stream) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int bytesRead = 0;
		while ((bytesRead = stream.read(buffer)) != -1) {
			baos.write(buffer, 0, bytesRead);
		}
		return baos.toByteArray();
	}

	/**
	 * Convert a document to an Inputstream
	 * 
	 * @param document
	 *            the document to convert
	 * @param prettyPrint
	 *            prettyPrinted if true
	 * @return An input stream of the document
	 * @throws IOException
	 */
	public static InputStream getDocumentToInputStream(Document document, boolean prettyPrint) throws IOException {
		document.setXmlStandalone(false);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		OutputFormat outputFormat = new OutputFormat(document);
		if (prettyPrint) {
			outputFormat.setIndenting(true);
			outputFormat.setIndent(2);
			outputFormat.setLineWidth(65);
			outputFormat.setPreserveSpace(false);
		}
		XMLSerializer serializer = new XMLSerializer(outputStream, outputFormat);
		serializer.serialize(document);
		return new ByteArrayInputStream(outputStream.toByteArray());
	}

	/**
	 * 
	 * Convert a string to a Document Object
	 * 
	 * @param xml
	 *            The xml to convert
	 * @return A document Object
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static Document getStringToDocument(String xml)
			throws IOException, SAXException, ParserConfigurationException {

		if (xml == null)
			return null;
		return getInputStreamToDocument(new ByteArrayInputStream(xml.getBytes("ISO-8859-1")));

	}

	/**
	 * Convert an inputStream to a Document Object
	 * 
	 * @param inputStream
	 *            The inputstream to convert
	 * @return a Document Object
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static Document getInputStreamToDocument(InputStream inputStream)
			throws IOException, SAXException, ParserConfigurationException {
		DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
		newInstance.setNamespaceAware(true);
		Document parse = newInstance.newDocumentBuilder().parse(inputStream);
		parse.setXmlStandalone(false);
		return parse;

	}

	/**
	 * Convert a Document object to a string
	 * 
	 * @param document
	 *            The document to Convert
	 * @param prettyPrint
	 *            prettyPrinted if true
	 * @return A string rapresentation of the document
	 * @throws IOException
	 */
	public static String getDocumentToString(Document document, boolean prettyPrint) throws IOException {
		document.setXmlStandalone(false);
		Writer writer = new StringWriter();
		char[] buffer = new char[1024];
		InputStream is = null;
		try {
			is = getDocumentToInputStream(document, prettyPrint);
			Reader reader = new BufferedReader(new InputStreamReader(is));
			int n;
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			}
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return writer.toString();
	}
}
