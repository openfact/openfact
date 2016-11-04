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
package org.openfact.services.util;

import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLInputFactory;
import de.odysseus.staxon.json.JsonXMLOutputFactory;
import de.odysseus.staxon.xml.util.PrettyXMLEventWriter;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Converter for performing bi-directional conversion between XML and json.
 */
public class JsonXmlConverter {

    /**
     * Converts xml to json.
     *
     * @param xml
     *            xml as byte array.
     * @return json as byte array.
     */
    public static byte[] convertXmlToJson(byte[] xml) {
        JsonXMLConfig config = new JsonXMLConfigBuilder().prettyPrint(true).autoArray(true).autoPrimitive(true).build();
        XMLInputFactory reader = XMLInputFactory.newInstance();
        JsonXMLOutputFactory writer = new JsonXMLOutputFactory(config);
        return convert(reader, writer, xml);
    }

    /**
     * Converts json to xml.
     *
     * @param json
     *            json as byte array.
     * @return xml as byte array.
     */
    public static byte[] convertJsonToXml(byte[] json) {
        JsonXMLConfig config = new JsonXMLConfigBuilder().prettyPrint(true).multiplePI(false).build();
        XMLInputFactory reader = new JsonXMLInputFactory(config);
        XMLOutputFactory writer = XMLOutputFactory.newInstance();
        return convert(reader, writer, json);
    }

    /**
     * Template for conversion.
     *
     * @param inputFactory
     *            input factory.
     * @param outputFactory
     *            output factory.
     * @param source
     *            source to convert.
     * @return conversion result as byte array.
     */
    private static byte[] convert(XMLInputFactory inputFactory, XMLOutputFactory outputFactory, byte[] source) {
        InputStream input = new ByteArrayInputStream(source);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            XMLEventReader reader = inputFactory.createXMLEventReader(input);
            XMLEventWriter writer = outputFactory.createXMLEventWriter(output, "utf-8");
            writer = new PrettyXMLEventWriter(writer);
            writer.add(reader);
            closeQuietly(reader, writer);
            return output.toByteArray();
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(output);
            IOUtils.closeQuietly(input);
        }
    }

    /**
     * Closes quietly reader and writer.
     *
     * @param reader
     *            xml event reader
     * @param writer
     *            xml event writer
     */
    private static void closeQuietly(XMLEventReader reader, XMLEventWriter writer) {
        try {
            reader.close();
        } catch (XMLStreamException e) {
            //throw new ErrorResponse("XML Event Reader", "Unable to close XMLEventReader", Response.Status.BAD_REQUEST);
        }
        try {
            writer.close();
        } catch (XMLStreamException e) {
            //throw new ErrorResponse("XML Event Writer", "Unable to close XMLEventWriter", Response.Status.BAD_REQUEST);
        }
    }

    public static Document getDocument(byte[] documentoXml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new ByteArrayInputStream(documentoXml));
    }
}
