package org.openfact.ubl.pe.send.header;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class CreatePackTest {
	public static Document loadDocument(String document) throws Exception {
        DocumentBuilderFactory fctr = DocumentBuilderFactory.newInstance();
        DocumentBuilder bldr = fctr.newDocumentBuilder();
        InputSource insrc = new InputSource(new StringReader(document));
        return bldr.parse(insrc);
    }
 
    public static void main(String [] args)
    {
        Document doc ;
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?><a><b></b><c></c></a>";
        try {
            doc = loadDocument(str);
            //System.out.println("str = " + str);
 
            StringWriter output = new StringWriter();
             
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(output));
 
             
            String gbStr = output.toString();
            System.out.println("gbStr = " + gbStr);
             
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
             
             
            byte buf[] = gbStr.getBytes(); 
             
            ByteArrayInputStream in = new ByteArrayInputStream(buf); 
             
            BufferedInputStream bis = new BufferedInputStream(in); 
             
            ZipOutputStream zipOS = new ZipOutputStream(baos);
             
            byte bytes[] = new byte[4096];
             
            zipOS.putNextEntry(new ZipEntry("rama.txt"));
             
            int bytesRead;
             
            while ((bytesRead = bis.read(bytes)) != -1) {
             
                zipOS.write(bytes, 0, bytesRead);
            }
            zipOS.closeEntry();
             
                         
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
