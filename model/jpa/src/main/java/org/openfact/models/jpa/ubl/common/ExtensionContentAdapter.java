package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ExtensionContentEntity;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.ExtensionContentModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
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
		return this.extensionContent.getAny();
	}

	@Override
	public void setAny(Element value) {
		this.extensionContent.setAny(value);
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
		return this.extensionContent.getAnyItem();
	}

	@Override
	public void setAnyItem(String target) {
		this.extensionContent.setAnyItem(target);
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

}
