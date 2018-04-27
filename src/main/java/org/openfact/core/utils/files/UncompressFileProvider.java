package org.openfact.core.utils.files;

import org.openfact.core.utils.files.exceptions.NotReadableCompressFileException;

import java.util.Map;

public interface UncompressFileProvider {

    String getSupportedExtension();

    Map<String, byte[]> uncompress(byte[] bytes) throws NotReadableCompressFileException;

}
