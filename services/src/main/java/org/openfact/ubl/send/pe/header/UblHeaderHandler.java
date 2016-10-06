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

import org.jboss.logging.Logger;
import org.openfact.models.OrganizationModel;

public class UblHeaderHandler implements SOAPHandler<SOAPMessageContext> {
	protected static final Logger logger = Logger.getLogger(UblHeaderHandler.class);
	private final OrganizationModel organization;

	public UblHeaderHandler(OrganizationModel organization) {
		this.organization = organization;
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (outboundProperty.booleanValue()) {
			try {
				SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();

				if (header == null) {
					header = envelope.addHeader();
				}

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
				//userElem.addTextNode(organization.getAssignedIdentificationId() + organization.getAuthorizedUser());
				SOAPElement pwdElem = factory.createElement("Password", prefix, uri);
				//pwdElem.addTextNode(organization.getAuthorizedPassword());

				// pwdElem.addAttribute(QName.valueOf("Type"),
				// "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");

				tokenElem.addChildElement(userElem);
				tokenElem.addChildElement(pwdElem);
				securityElem.addChildElement(tokenElem);
				header.addChildElement(securityElem);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return outboundProperty;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
	}

}
