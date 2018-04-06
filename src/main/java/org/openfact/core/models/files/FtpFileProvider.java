package org.openfact.core.models.files;

import org.openfact.core.models.FileInfoModel;
import org.openfact.core.models.FileProvider;
import org.openfact.core.models.FileProviderVendor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@FileProviderVendor(type = FileProviderVendor.Type.FTP)
public class FtpFileProvider implements FileProvider {

    @Override
    public FileInfoModel addFile(String filename, byte[] bytes) throws FileException {
        return null;
    }

}
