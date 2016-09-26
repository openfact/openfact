package org.openfact.services.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class PackHelper {
	private static final int BUFFER_SIZE = 4096;

	// Crea un zip desde un archivo.
	public void createZip(String origen, String destino, String extension) {
		try {
			ZipFile zipFile = new ZipFile(destino + extension);
			File source = new File(origen);
			ArrayList filesToAdd = new ArrayList();
			filesToAdd.add(source);
			ZipParameters parameters = new ZipParameters();
			/*
			 * set compression method to deflate compression
			 */
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			zipFile.addFiles(filesToAdd, parameters);
			source.delete();
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}

	// Crea un zip desde un directorio.
	public void createZipDirectory(String dir, String destino, String extension) {
		try {
			File base = new File(dir);
			ArrayList<File> filesToZip = new ArrayList<File>();
			// get all files/folders under sourceFolder
			if (base.isDirectory()) {
				filesToZip.addAll(Arrays.asList(base.listFiles()));
			}
			// init zip file
			ZipFile zipFile = new ZipFile(destino + extension);
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

	public void UnZip(String pZipFile, String pFile) {
		try {
			System.out.println(pZipFile + "-" + pFile);
			ZipFile zipFile = new ZipFile(pZipFile);
			zipFile.extractAll(pFile);
		} catch (ZipException e) {
			e.printStackTrace();
		}
	} // end UnZip

	/* metodo que adjunta una cantidad x de archivos en un zip */
	public void createZipFiles(String[] sourceFiles, String destino, String extension) {
		try {
			ZipFile zipFile = new ZipFile(destino + extension);
			ArrayList filesToAdd = new ArrayList();
			for (String source : sourceFiles) {
				File fileSource = new File(source);
				filesToAdd.add(fileSource);
				fileSource.delete();
			}
			ZipParameters parameters = new ZipParameters();
			/*
			 * set compression method to deflate compression
			 */
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			zipFile.addFiles(filesToAdd, parameters);
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}
}
