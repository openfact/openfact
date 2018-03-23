package org.openfact.models.files;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.openfact.models.FileProvider;
import org.openfact.models.FileProviderVendor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@FileProviderVendor(type = FileProviderVendor.Type.FTP)
public class FtpFileProvider implements FileProvider {

    /**
     * Camel URI, format is ftp://user@host/fileName?password=secret&passiveMode=true
     */
    //private static final String CAMEL_FTP_PATTERN = "{0}://{1}@{2}/{3}?password={4}&passiveMode={5}";

    //ProducerTemplate producerTemplate;

    @Override
    public String addFile(String filename, byte[] bytes) {
        DefaultCamelContext context = new DefaultCamelContext();
        ProducerTemplate producerTemplate = context.createProducerTemplate();
        producerTemplate.sendBodyAndHeader("file:openfact-files", bytes, Exchange.FILE_NAME, filename);
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
