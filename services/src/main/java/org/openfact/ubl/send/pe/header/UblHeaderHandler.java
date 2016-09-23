package org.openfact.ubl.send.pe.header;

import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class UblHeaderHandler implements SOAPHandler<SOAPMessageContext> {

	private final static String login = "10428482072MODDATOS";
	private final static String pwd = "MODDATOS";

	@Override
	public Set<QName> getHeaders() {
		System.out.println("Organization : getHeaders()......");
		return null;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("Organization : handleMessage()......");
		Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (outboundProperty) {

			try {
				SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
				SOAPFactory factory = SOAPFactory.newInstance();
				String prefix = "wsse";
				String uri = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
				SOAPElement securityElem = factory.createElement("Security", prefix, uri);
				SOAPElement tokenElem = factory.createElement("UsernameToken", prefix, uri);

				// tokenElem.addAttribute(QName.valueOf("wsu:Id"),
				// "UsernameToken-2");
				// tokenElem.addAttribute(QName.valueOf("xmlns:wsu"),
				// "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

				SOAPElement userElem = factory.createElement("Username", prefix, uri);
				userElem.addTextNode(login);
				SOAPElement pwdElem = factory.createElement("Password", prefix, uri);
				pwdElem.addTextNode(pwd);
				
				// pwdElem.addAttribute(QName.valueOf("Type"),
				// "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
				
				tokenElem.addChildElement(userElem);
				tokenElem.addChildElement(pwdElem);
				securityElem.addChildElement(tokenElem);
				SOAPHeader header = envelope.addHeader();
				header.addChildElement(securityElem);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// inbound
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("Organization : handleFault()......");
		return true;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("Organization : close()......");
	}

}
