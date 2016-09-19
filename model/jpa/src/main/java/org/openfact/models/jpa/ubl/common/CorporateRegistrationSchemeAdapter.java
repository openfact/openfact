package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.CorporateRegistrationSchemeModel;

public class CorporateRegistrationSchemeAdapter
        implements CorporateRegistrationSchemeModel, JpaModel<CorporateRegistrationSchemeEntity> {

    protected static final Logger logger = Logger.getLogger(CorporateRegistrationSchemeAdapter.class);
    protected CorporateRegistrationSchemeEntity corporateRegistrationScheme;
    protected EntityManager em;
    protected OpenfactSession session;

    public CorporateRegistrationSchemeAdapter(OpenfactSession session, EntityManager em,
            CorporateRegistrationSchemeEntity corporateRegistrationScheme) {
        this.session = session;
        this.em = em;
        this.corporateRegistrationScheme = corporateRegistrationScheme;
    }

    @Override
    public String getID() {
        return this.corporateRegistrationScheme.getID();
    }

    @Override
    public void setID(String value) {
        this.corporateRegistrationScheme.setID(value);
    }

    @Override
    public String getName() {
        return this.corporateRegistrationScheme.getName();
    }

    @Override
    public void setName(String value) {
        this.corporateRegistrationScheme.setName(value);
    }

    @Override
    public String getCorporateRegistrationModelCode() {
        return this.corporateRegistrationScheme.getCorporateRegistrationModelCode();
    }

    @Override
    public void setCorporateRegistrationAdapterCode(String value) {
        this.corporateRegistrationScheme.setCorporateRegistrationAdapterCode(value);
    }

    @Override
    public List<AddressModel> getJurisdictionRegionAddress() {
        return this.corporateRegistrationScheme.getJurisdictionRegionAddress();
    }

    @Override
    public void setJurisdictionRegionAddress(List<AddressAdapter> jurisdictionRegionAddress) {
        this.corporateRegistrationScheme.setJurisdictionRegionAddress(jurisdictionRegionAddress);
    }

    @Override
    public String getId() {
        return this.corporateRegistrationScheme.getId();
    }

    @Override
    public void setId(String value) {
        this.corporateRegistrationScheme.setId(value);
    }

}
