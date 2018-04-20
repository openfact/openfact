package org.openfact.pe.camel.cfx.routes;

//import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
//import org.apache.cxf.binding.soap.SoapHeader;
//import org.apache.cxf.headers.Header;
//import org.apache.cxf.helpers.CastUtils;
//import org.apache.cxf.helpers.DOMUtils;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
//import javax.xml.namespace.QName;
//import java.io.StringReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;

@ApplicationScoped
@ContextName("cdi-context")
public class CfxRouter extends RouteBuilder {

    private static final Logger logger = Logger.getLogger(CfxRouter.class);

    public static final String SEND_BILL_URI = "direct:sunatSendBill";

    public static final String END_POINT_HEADER = "OpenfactWsEndpoint";
    public static final String USERNAME = "OpenfactWsUsername";
    public static final String PASSWORD = "OpenfactWsPassword";

    @Override
    public void configure() {
        from(SEND_BILL_URI)
                .process(exchange -> {
                    Message message = exchange.getIn();
//                    addWSSESecurityHeader(exchange);
                    logger.debugf("Sending file to $s", message.getHeader(END_POINT_HEADER));
                })
                .toD(String.format("cxf:${header.%s}?serviceClass=%s&serviceName=urn:sendBill", END_POINT_HEADER, pe.gob.sunat.service.BillService.class.getName()));
//                .toD("cxf:https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService?serviceClass=pe.gob.sunat.service.BillService&serviceName=urn:sendBill");
    }

//    private void addWSSESecurityHeader(Exchange exchange) {
//        Message message = exchange.getIn();
//
//        String username = (String) message.getHeader(USERNAME);
//        String password = (String) message.getHeader(PASSWORD);
//
//        String soapHeader = String.format("" +
//                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"\n" +
//                "               xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
//                "    <wsse:UsernameToken wsu:Id=\"UsernameToken-%s\">\n" +
//                "        <wsse:Username>%s</wsse:Username>\n" +
//                "        <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">%s</wsse:Password>\n" +
//                "    </wsse:UsernameToken>\n" +
//                "</wsse:Security>", UUID.randomUUID().toString(), username, password);
//
//        List<SoapHeader> soapHeaders = CastUtils.cast((List<?>) message.getHeader(Header.HEADER_LIST));
//        SoapHeader newHeader;
//
//        if (soapHeaders == null) {
//            soapHeaders = new ArrayList<>();
//        }
//
//        try {
//            newHeader = new SoapHeader(new QName("soapHeader"), DOMUtils.readXml(new StringReader(soapHeader)).getDocumentElement());
//            newHeader.setDirection(Header.Direction.DIRECTION_OUT);
//
//            soapHeaders.add(newHeader);
//
//            message.setHeader(Header.HEADER_LIST, soapHeaders);
//
//        } catch (Exception e) {
//            logger.error(e);
//        }
//    }


}
