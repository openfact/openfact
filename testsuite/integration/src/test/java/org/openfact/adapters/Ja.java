package org.openfact.adapters;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.helger.commons.error.IResourceErrorGroup;
import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Validator;
import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class Ja {

    public static void main(String[] args) throws IOException {

        File file = new File("/home/admin/Downloads/Signature/20494637074-01-F001-1_sign.xml");
        InvoiceType invoice = UBL21Reader.invoice().read(file);               
        
        IResourceErrorGroup result= UBL21Validator.invoice().validate(invoice);
        
        System.out.println(result.containsAtLeastOneError());
        
        UBL21Writer.invoice().write(invoice, new File("/home/admin/Downloads/Signature/20494637074-01-F001-1_sign_hhhhh.xml"));

    }
}
