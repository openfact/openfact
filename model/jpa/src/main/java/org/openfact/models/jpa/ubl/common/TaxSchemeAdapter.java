package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.AddressModel;
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
    public String getTaxModelCode() {
        return this.taxScheme.getTaxModelCode();
    }

    @Override
    public void setTaxCodeAdapter(String value) {
        this.taxScheme.setTaxCodeAdapter(value);
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
        return this.taxScheme.getJurisdictionRegionAddress();
    }

    @Override
    public void setJurisdictionRegionAddress(List<AddressAdapter> jurisdictionRegionAddress) {
        this.taxScheme.setJurisdictionRegionAddress(jurisdictionRegionAddress);
    }

    @Override
    public String getId() {
        return this.taxScheme.getId();
    }

    @Override
    public void setId(String value) {
        this.taxScheme.setId(value);
    }

}
