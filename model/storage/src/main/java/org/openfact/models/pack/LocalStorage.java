package org.openfact.models.pack;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.openfact.models.enums.FileExtensionType;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 27/07/2016.
 */
public class LocalStorage {
    private static final int BUFFER_SIZE = 4096;

    // Crea un zip desde un archivo.
    public void createZip(String origen, String destino, FileExtensionType extension) throws IOException {
        try {
            ZipFile zipFile = new ZipFile(String.valueOf(destino) + extension.getValue());
            ArrayList filesToAdd = new ArrayList();
            filesToAdd.add(new File(origen));
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(8);
            parameters.setCompressionLevel(5);
            zipFile.addFiles(filesToAdd, parameters);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    // Crea un zip desde un directorio.
    public void createZipDirectory(String dir, String destino, FileExtensionType extension)
            throws IOException, IllegalArgumentException {
        // Revisa que el directorio sea direcorio y lee sus archivos.
        File d = new File(dir);
        if (!d.isDirectory())
            throw new IllegalArgumentException(dir + " no es un directorio.");
        String[] entries = d.list();
        byte[] buffer = new byte[BUFFER_SIZE]; // Crea un buffer para copiar
        int bytesRead;
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(destino + extension.getValue()));
        for (int i = 0; i < entries.length; i++) {
            File f = new File(d, entries[i]);
            if (f.isDirectory())
                continue; // Ignora el directorio
            FileInputStream in = new FileInputStream(f);

            ZipEntry entry = new ZipEntry(f.getPath()); // Crea una entrada zip
            // para cada archivo,
            out.putNextEntry(entry);

            while ((bytesRead = in.read(buffer)) != -1)
                out.write(buffer, 0, bytesRead);
            in.close();
        }
        out.close();
    }

    public void UnZip(String pZipFile, String pFile) throws Exception {
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        ZipInputStream zipis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(pZipFile);
            zipis = new ZipInputStream(new BufferedInputStream(fis));
            if (zipis.getNextEntry() != null) {
                int len = 0;
                byte[] buffer = new byte[BUFFER_SIZE];
                fos = new FileOutputStream(pFile);
                bos = new BufferedOutputStream(fos, BUFFER_SIZE);

                while ((len = zipis.read(buffer, 0, BUFFER_SIZE)) != -1)
                    bos.write(buffer, 0, len);
                bos.flush();
            } else {
                throw new Exception("El zip no contenia fichero alguno");
            } // end if
        } catch (Exception e) {
            throw e;
        } finally {
            bos.close();
            zipis.close();
            fos.close();
            fis.close();
        } // end try
    } // end UnZip

    /* metodo que adjunta una cantidad x de archivos en un zip */
    public void createZipFiles(String[] sourceFiles, String destino, FileExtensionType extension) {

        try {
            ZipFile zipFile = new ZipFile(destino + extension.getValue());
            ArrayList filesToAdd = new ArrayList();
            for (String source : sourceFiles) {
                filesToAdd.add(new File(source));
            }
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set compression method to deflate compression

            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

            zipFile.addFiles(filesToAdd, parameters);

        } catch (ZipException e) {
            e.printStackTrace();
        }
    }
}
