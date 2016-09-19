package org.openfact.models.jpa.ubl.common;

import java.util.List;

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

    String getID() {
        return this.corporateRegistrationScheme.getID();
    }

    void setID(String value) {
        this.corporateRegistrationScheme.setID(value);
    }

    String getName() {
        return this.corporateRegistrationScheme.getName();
    }

    void setName(String value) {
        this.corporateRegistrationScheme.setName(value);
    }

    String getCorporateRegistrationAdapterCode() {
        return this.corporateRegistrationScheme.getCorporateRegistrationAdapterCode();
    }

    void setCorporateRegistrationAdapterCode(String value) {
        this.corporateRegistrationScheme.setCorporateRegistrationAdapterCode(value);
    }

    List<AddressAdapter> getJurisdictionRegionAddress() {
        return this.corporateRegistrationScheme.getJurisdictionRegionAddress();
    }

    void setJurisdictionRegionAddress(List<AddressAdapter> jurisdictionRegionAddress) {
        this.corporateRegistrationScheme.setJurisdictionRegionAddress(jurisdictionRegionAddress);
    }

    String getId() {
        return this.corporateRegistrationScheme.getId();
    }

    void setId(String value) {
        this.corporateRegistrationScheme.setId(value);
    }

}
