package org.openfact.pe.models.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class JaxbUtils {

    public static Document toDocument(byte[] bytes) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new ByteArrayInputStream(bytes));
    }

    public static <T> Object unMarshall(byte[] bytes, Class<T> tClass) throws JAXBException {
        InputStream is = new ByteArrayInputStream(bytes);

        JAXBContext context = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(is);
    }

    public static <T> T unMarshall(Document document, Class<T> tClass) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        JAXBElement<T> jaxbElement = unmarshaller.unmarshal(document, tClass);
        return jaxbElement.getValue();
    }

    public static <T> byte[] marshalToBytes(Class classToBeBound, JAXBElement<T> jaxbElement) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classToBeBound);
        Marshaller marshaller = jaxbContext.createMarshaller();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        marshaller.marshal(jaxbElement, os);

        return os.toByteArray();
    }

    public static <T> Element marshalToElement(Class classToBeBound, JAXBElement<T> jaxbElement) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(classToBeBound);
        Marshaller marshaller = context.createMarshaller();

        DOMResult res = new DOMResult();
        marshaller.marshal(jaxbElement, res);
        return ((Document) res.getNode()).getDocumentElement();
    }

    public static <T> Document marshalToDocument(Class classToBeBound, JAXBElement<T> jaxbElement) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(classToBeBound);
        Marshaller marshaller = context.createMarshaller();

        DOMResult res = new DOMResult();
        marshaller.marshal(jaxbElement, res);
        return ((Document) res.getNode());
    }

    public static byte[] toBytes(Document document) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(document);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(bos);
        transformer.transform(source, result);
        return bos.toByteArray();
    }

}
