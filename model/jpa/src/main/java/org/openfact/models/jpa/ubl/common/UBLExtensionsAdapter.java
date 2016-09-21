package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AddressEntity;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionEntity;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionsEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;

public class UBLExtensionsAdapter implements UBLExtensionsModel, JpaModel<UBLExtensionsEntity> {

	protected static final Logger logger = Logger.getLogger(UBLExtensionsAdapter.class);
	protected UBLExtensionsEntity uBLExtensions;
	protected EntityManager em;
	protected OpenfactSession session;

	public UBLExtensionsAdapter(OpenfactSession session, EntityManager em, UBLExtensionsEntity uBLExtensions) {
		this.session = session;
		this.em = em;
		this.uBLExtensions = uBLExtensions;
	}

	@Override
	public List<UBLExtensionModel> getUBLExtension() {
		return this.uBLExtensions.getUblExtension().stream().map(f -> new UBLExtensionAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setUBLExtension(List<UBLExtensionModel> ublExtension) {
		List<UBLExtensionEntity> entities = ublExtension.stream().map(f -> UBLExtensionAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		this.uBLExtensions.setUblExtension(entities);
	}

	@Override
	public String getId() {
		return this.uBLExtensions.getId();
	}

	@Override
	public void setId(String value) {
		this.uBLExtensions.setId(value);
	}

	@Override
	public UBLExtensionsEntity getEntity() {
		return this.uBLExtensions;
	}

	public static UBLExtensionsEntity toEntity(UBLExtensionsModel model, EntityManager em) {
		if (model instanceof UBLExtensionsModel) {
			return ((UBLExtensionsAdapter) model).getEntity();
		}
		return em.getReference(UBLExtensionsEntity.class, model.getId());
	}

}
