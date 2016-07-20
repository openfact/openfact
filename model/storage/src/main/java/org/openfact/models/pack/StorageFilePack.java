package org.openfact.models.pack;

import org.openfact.models.enums.FileExtensionType;

import java.io.*;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 14/07/2016.
 */
public class StorageFilePack {

    private static final int BUFFER_SIZE = 4096;

    // Crea un zip desde un archivo.
    public void createZip(String origen, String destino, FileExtensionType extension) throws IOException {
        FileInputStream in = new FileInputStream(origen);
        GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(destino + extension.getValue()));
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1)
            out.write(buffer, 0, bytesRead);
        in.close();
        out.close();
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
    public void createZipFiles(String[] sourceFiles) {
        FileOutputStream fileOutputStream = null;
        try {
            // create byte buffer
            byte[] buffer = new byte[BUFFER_SIZE];

            FileOutputStream fout = fileOutputStream;
            ZipOutputStream zout = new ZipOutputStream(fout);

            for (int i = 0; i < sourceFiles.length; i++) {

                System.out.println("agregando : " + sourceFiles[i]);
                FileInputStream fin = new FileInputStream(sourceFiles[i]);
                zout.putNextEntry(new ZipEntry(sourceFiles[i]));
                int length;

                while ((length = fin.read(buffer)) > 0) {
                    zout.write(buffer, 0, length);
                }
                zout.closeEntry();
                fin.close();
            }
            zout.close();
            System.out.println("El archivo comprimido ha sido creado!");
        } catch (IOException ioe) {
            System.out.println("IOException :" + ioe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

