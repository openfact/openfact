package org.openfact.core.utils.files;

import org.openfact.core.models.FileModel;
import org.openfact.core.utils.files.exceptions.NotReadableCompressFileException;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public interface UncompressFileProvider {

    String getSupportedExtension();

    Map<String, byte[]> uncompress(byte[] bytes) throws NotReadableCompressFileException;

}
