package org.openfact.models.files;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.impl.DefaultCamelContext;
import org.openfact.models.FileProvider;
import org.openfact.models.FileProviderVendor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@FileProviderVendor(type = FileProviderVendor.Type.FILESYSTEM)
public class FilesystemFileProvider implements FileProvider {

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelctx;

    @Override
    public String addFile(String filename, byte[] bytes) {
        ProducerTemplate producerTemplate = camelctx.createProducerTemplate();
        producerTemplate.sendBodyAndHeader("direct:start", "Hello", Exchange.FILE_NAME, filename);
        return "Hello";
    }

    /**
     * Creates a Camel FTP URI based on the provided FTP properties
     * @param ftpProperties The properties to be used
     */
//    private String createFtpUri(FtpProperties ftpProperties) {
//        return MessageFormat.format(CAMEL_FTP_PATTERN,
//                ftpProperties.getProtocol(),
//                ftpProperties.getUserName(),
//                ftpProperties.getHost(),
//                ftpProperties.getRemoteDirectory(),
//                ftpProperties.getPassword(),
//                ftpProperties.getPassiveMode());
//    }

}
