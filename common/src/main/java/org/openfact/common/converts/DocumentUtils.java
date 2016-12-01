/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.common.converts;

import org.apache.commons.lang.ArrayUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class DocumentUtils {

	public static Document byteToDocument(byte[] document) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document docParse = builder.parse(new ByteArrayInputStream(document));
		return docParse;
	}

	public static Document byteToDocument(Byte[] document) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document docParse = builder.parse(new ByteArrayInputStream(ArrayUtils.toPrimitive(document)));
		return docParse;
	}

	public static void elementToByte(Element element, OutputStream out) throws TransformerException {
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		transformer.setOutputProperty("omit-xml-declaration", "no");
		transformer.setOutputProperty("encoding", "ISO-8859-1");
		transformer.transform(new DOMSource(element), new StreamResult(out));
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
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setNamespaceAware(true);
		// dbf.setAttribute("http://xml.org/sax/features/namespaces",
		// Boolean.TRUE);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Reader reader = new InputStreamReader(inputStream, "ISO8859_1");
		InputSource is = new InputSource(reader);
		is.setEncoding("ISO-8859-1");		
		Document doc = db.parse(is);
		return doc;
	}

	public static byte[] getBytesFromDocument(Document document) throws TransformerException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.setOutputProperty("omit-xml-declaration", "no");
		transformer.setOutputProperty("encoding", "ISO-8859-1");
		transformer.transform(new DOMSource(document), new StreamResult(out));
		byte[] butesXml = out.toByteArray();
		return butesXml;
	}

	public static void getDocumentToOutputStream(Document doc, ByteArrayOutputStream signatureFile)
			throws TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.setOutputProperty("omit-xml-declaration", "no");
		transformer.setOutputProperty("encoding", "ISO-8859-1");
		transformer.transform(new DOMSource(doc), new StreamResult(signatureFile));
	}

	public static Document getEmptyDocument() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.newDocument();
	}

	public static String getDocumentToString(Document document) throws TransformerException {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		StringWriter sw = new StringWriter();
		t.transform(new DOMSource(document), new StreamResult(sw));
		return sw.toString();
	}

	public Element byteToElement(byte[] document) throws TransformerFactoryConfigurationError, Exception {
		DOMSource source = new DOMSource(DocumentUtils.byteToDocument(document));
		Element elem = ((Document) source.getNode()).getDocumentElement();
		return elem;
	}

	/*
	 * public static InputStream getDocumentToInputStream(Document document,
	 * boolean prettyPrint) throws IOException {
	 * document.setXmlStandalone(false); ByteArrayOutputStream outputStream =
	 * new ByteArrayOutputStream(); OutputFormat outputFormat = new
	 * OutputFormat(document); if (prettyPrint) {
	 * outputFormat.setIndenting(true); outputFormat.setIndent(2);
	 * outputFormat.setLineWidth(65); outputFormat.setPreserveSpace(false); }
	 * XMLSerializer serializer = new XMLSerializer(outputStream, outputFormat);
	 * serializer.serialize(document); return new
	 * ByteArrayInputStream(outputStream.toByteArray()); }
	 */

	/*
	 * public static String getDocumentToString(Document document, boolean
	 * pretty) throws IOException { document.setXmlStandalone(false); Writer
	 * writer = new StringWriter(); char[] buffer = new char[1024]; InputStream
	 * is = null; try { is = getDocumentToInputStream(document, pretty); Reader
	 * reader = new BufferedReader(new InputStreamReader(is)); int n; while ((n
	 * = reader.read(buffer)) != -1) { writer.write(buffer, 0, n); } } finally {
	 * if (is != null) { is.close(); } } return writer.toString(); }
	 */
}
