package org.openfact.models.pack;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.openfact.models.enums.FileExtensionType;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 27/07/2016.
 */
public class LocalStorage {
	private static final int BUFFER_SIZE = 4096;

	// Crea un zip desde un archivo.
	public void createZip(String origen, String destino, FileExtensionType extension) {
		try {
			ZipFile zipFile = new ZipFile(destino + extension.getValue());
			File source = new File(origen);
			ArrayList filesToAdd = new ArrayList();
			filesToAdd.add(source);

			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set
																			// compression
																			// method
																			// to
																			// deflate
																			// compression

			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			zipFile.addFiles(filesToAdd, parameters);
			source.delete();
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}

	// Crea un zip desde un directorio.
	public void createZipDirectory(String dir, String destino, FileExtensionType extension) {
		try {
			File base = new File(dir);
			ArrayList<File> filesToZip = new ArrayList<File>();
			// get all files/folders under sourceFolder
			if (base.isDirectory()) {
				filesToZip.addAll(Arrays.asList(base.listFiles()));
			}
			// init zip file
			ZipFile zipFile = new ZipFile(destino + extension.getValue());

			// init zip parameters
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			parameters.setEncryptFiles(false);

			// add files/folders into zipFile
			for (File f : filesToZip) {
				if (f.isDirectory()) {
					zipFile.addFolder(f.getAbsolutePath(), parameters);
				} else {
					zipFile.addFile(f, parameters);
				}
			}
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}

	public void UnZip(String pZipFile, String pFile){

		try {
			System.out.println(pZipFile + "-" + pFile);
			ZipFile zipFile = new ZipFile(pZipFile);
			zipFile.extractAll(pFile);
		} catch (ZipException e) {
			e.printStackTrace();
		}

	} // end UnZip

	/* metodo que adjunta una cantidad x de archivos en un zip */
	public void createZipFiles(String[] sourceFiles, String destino, FileExtensionType extension) {
		try {
			ZipFile zipFile = new ZipFile(destino + extension.getValue());

			ArrayList filesToAdd = new ArrayList();
			for (String source : sourceFiles) {
				File fileSource = new File(source);
				filesToAdd.add(fileSource);
				fileSource.delete();
			}

			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set
																			// compression
																			// method
																			// to
																			// deflate
																			// compression

			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			zipFile.addFiles(filesToAdd, parameters);

		} catch (ZipException e) {
			e.printStackTrace();
		}
	}
}
