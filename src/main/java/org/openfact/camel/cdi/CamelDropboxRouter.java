package org.openfact.camel.cdi;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.component.dropbox.util.DropboxConstants;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ContextName("cdi-context")
public class CamelDropboxRouter extends RouteBuilder {

    public static final String OPENFACT_DIRECT_DROPBOX = "direct:dropbox";

    /**
     * Camel URI, format is ftp://user@host/fileName?password=secret&passiveMode=true
     */
    private static final String CAMEL_DROPBOX_PATTERN = "dropbox://put?" +
            "accessToken=RAW(7T3gmysPYqQAAAAAAAAb9BCuu-a_Nmh25I1HQFQIlC5yJ6WANX5t_xiw3cZmJuMA)&" +
            "clientIdentifier=RAW(camelinaction)&" +
            "uploadMode=add" +
            "&remotePath=/test";
//            "&localPath=/home/admin/cameltest";

    @Override
    public void configure() throws Exception {
        from(OPENFACT_DIRECT_DROPBOX)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Writing " + exchange + " to ");
                    }
                })
                .setHeader(DropboxConstants.HEADER_PUT_FILE_NAME, constant("myfile.txt"))
                .toD(CAMEL_DROPBOX_PATTERN);
    }

//    private String createFtpUri(Map<String, String> config) {
//        return MessageFormat.format(CAMEL_DROPBOX_PATTERN,
//                config.get("accessToken"),
//                config.get("clientIdentifier"),
//                ftpProperties.getHost(),
//                ftpProperties.getRemoteDirectory(),
//                ftpProperties.getPassword(),
//                ftpProperties.getPassiveMode());
//    }

}
