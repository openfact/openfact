package org.openfact.models.jpa.ubl.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.persistence.EntityManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jboss.logging.Logger;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ExtensionContentEntity;
import org.openfact.models.ubl.common.ExtensionContentModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExtensionContentAdapter implements ExtensionContentModel, JpaModel<ExtensionContentEntity> {

	protected static final Logger logger = Logger.getLogger(ExtensionContentAdapter.class);
	protected ExtensionContentEntity extensionContent;
	protected EntityManager em;
	protected OpenfactSession session;

	public ExtensionContentAdapter(OpenfactSession session, EntityManager em, ExtensionContentEntity extensionContent) {
		this.session = session;
		this.em = em;
		this.extensionContent = extensionContent;
	}

	@Override
	public Element getAny() {
		Transformer transformer;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(getByteToDocument(this.extensionContent.getAny()));
			Element elem = ((Document) source.getNode()).getDocumentElement();
			return elem;
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
			throw new ModelException("Error in convert byte to element");
		} catch (Exception e) {
			throw new ModelException("Error in convert byte to element");
		}
	}

	@Override
	public void setAny(Element value) {
		Document document = value.getOwnerDocument();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ElementToByte(document.getDocumentElement(), baos);
		this.extensionContent.setAny(baos.toByteArray());
	}

	@Override
	public String getId() {
		return this.extensionContent.getId();
	}

	@Override
	public void setId(String value) {
		this.extensionContent.setId(value);
	}

	@Override
	public String getAnyItem() {
		return this.extensionContent.getAny().toString();
	}

	@Override
	public void setAnyItem(String target) {
		// TODO
	}

	public static ExtensionContentEntity toEntity(ExtensionContentModel model, EntityManager em) {
		if (model instanceof ExtensionContentModel) {
			return ((ExtensionContentAdapter) model).getEntity();
		}
		return em.getReference(ExtensionContentEntity.class, model.getId());
	}

	@Override
	public ExtensionContentEntity getEntity() {
		return extensionContent;
	}

	private Document getByteToDocument(byte[] documentoXml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(new ByteArrayInputStream(documentoXml));
	}

	public void ElementToByte(Element element, OutputStream out) {
		try {
			DOMSource source = new DOMSource(element);
			StreamResult result = new StreamResult(out);
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			transformer.transform(source, result);
		} catch (Exception ex) {
			throw new ModelException("Error in convert element to byte");
		}
	}
}
