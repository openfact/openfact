package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PostalAddressModel;
import org.openfact.models.jpa.entities.PostalAddressEntity;

public class PostalAddressAdapter implements PostalAddressModel, JpaModel<PostalAddressEntity> {

    protected static final Logger logger = Logger.getLogger(PostalAddressAdapter.class);

    protected OrganizationModel organization;
    protected PostalAddressEntity postalAddress;
    protected EntityManager em;
    protected OpenfactSession session;

    public PostalAddressAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            PostalAddressEntity postalAddress) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.postalAddress = postalAddress;
    }

    @Override
    public PostalAddressEntity getEntity() {
        return postalAddress;
    }

    public static PostalAddressEntity toEntity(PostalAddressModel model, EntityManager em) {
        if (model instanceof PostalAddressAdapter) {
            return ((PostalAddressAdapter) model).getEntity();
        }
        return em.getReference(PostalAddressEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return postalAddress.getId();
    }

    @Override
    public String getStreetName() {
        return postalAddress.getStreetName();
    }

    @Override
    public void setStreetName(String streetName) {
        postalAddress.setStreetName(streetName);
    }

    @Override
    public String getCitySubdivisionName() {
        return postalAddress.getCitySubdivisionName();
    }

    @Override
    public void setCitySubdivisionName(String citySubdivisionName) {
        postalAddress.setCitySubdivisionName(citySubdivisionName);
    }

    @Override
    public String getCityName() {
        return postalAddress.getCityName();
    }

    @Override
    public void setCityName(String cityName) {
        postalAddress.setCityName(cityName);
    }

    @Override
    public String getCountrySubentity() {
        return postalAddress.getCountrySubentity();
    }

    @Override
    public void setCountrySubentity(String countrySubentity) {
        postalAddress.setCountrySubentity(countrySubentity);
    }

    @Override
    public String getDistrict() {
        return postalAddress.getDistrict();
    }

    @Override
    public void setDistrict(String district) {
        postalAddress.setDistrict(district);
    }

    @Override
    public String getCountryIdentificationCode() {
        return postalAddress.getCountryIdentificationCode();
    }

    @Override
    public void setCountryIdentificationCode(String countryIdentificationCode) {
        postalAddress.setCountryIdentificationCode(countryIdentificationCode);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((postalAddress == null) ? 0 : postalAddress.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PostalAddressAdapter other = (PostalAddressAdapter) obj;
        if (postalAddress == null) {
            if (other.postalAddress != null)
                return false;
        } else if (!postalAddress.equals(other.postalAddress))
            return false;
        return true;
    }

}
