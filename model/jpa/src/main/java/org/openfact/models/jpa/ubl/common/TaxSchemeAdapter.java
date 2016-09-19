package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AddressEntity;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.PaymentMeansEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxSchemeEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.TaxSchemeModel;

public class TaxSchemeAdapter implements TaxSchemeModel, JpaModel<TaxSchemeEntity> {

	protected static final Logger logger = Logger.getLogger(TaxSchemeAdapter.class);
	protected TaxSchemeEntity taxScheme;
	protected EntityManager em;
	protected OpenfactSession session;

	public TaxSchemeAdapter(OpenfactSession session, EntityManager em, TaxSchemeEntity taxScheme) {
		this.session = session;
		this.em = em;
		this.taxScheme = taxScheme;
	}

	@Override
	public String getID() {
		return this.taxScheme.getID();
	}

	@Override
	public void setID(String value) {
		this.taxScheme.setID(value);
	}

	@Override
	public String getName() {
		return this.taxScheme.getName();
	}

	@Override
	public void setName(String value) {
		this.taxScheme.setName(value);
	}

	@Override
	public String getTaxCode() {
		return this.taxScheme.getTaxTypeCode();
	}

	@Override
	public void setTaxCode(String value) {
		this.taxScheme.setTaxTypeCode(value);
	}

	@Override
	public String getCurrencyCode() {
		return this.taxScheme.getCurrencyCode();
	}

	@Override
	public void setCurrencyCode(String value) {
		this.taxScheme.setCurrencyCode(value);
	}

	@Override
	public List<AddressModel> getJurisdictionRegionAddress() {
		return taxScheme.getJurisdictionRegionAddress().stream().map(f -> new AddressAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setJurisdictionRegionAddress(List<AddressModel> jurisdictionRegionAddress) {
		List<AddressEntity> entities = jurisdictionRegionAddress.stream().map(f -> AddressAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		this.taxScheme.setJurisdictionRegionAddress(entities);
	}

	@Override
	public String getId() {
		return this.taxScheme.getId();
	}

	@Override
	public void setId(String value) {
		this.taxScheme.setId(value);
	}

	public static TaxSchemeEntity toEntity(TaxSchemeModel model, EntityManager em) {
		if (model instanceof TaxSchemeModel) {
			return ((TaxSchemeAdapter) model).getEntity();
		}
		return em.getReference(TaxSchemeEntity.class, model.getId());
	}

	@Override
	public TaxSchemeEntity getEntity() {
		// TODO Auto-generated method stub
		return taxScheme;
	}

}
