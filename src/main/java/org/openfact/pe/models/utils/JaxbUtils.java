package org.openfact.pe.models.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

public class JaxbUtils {

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
