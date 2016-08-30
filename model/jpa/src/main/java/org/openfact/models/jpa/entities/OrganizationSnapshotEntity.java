package org.openfact.models.jpa.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "ORGANIZATION_SNAPSHOT")
public class OrganizationSnapshotEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "INVOICE_ID", length = 36)    
    private String id;

    @Column(name = "ASSIGNED_IDENTIFICATION_ID")
    private String assignedIdentificationId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "ADDITIONAL_ACCOUNTID_NAME")),
            @AttributeOverride(name = "documentId", column = @Column(name = "ADDITIONAL_ACCOUNTID_DOCUMENTID")) })
    private DocumentSnapshotEntity additionalAccountId;

    @Column(name = "SUPPLIER_NAME")
    private String supplierName;

    @Column(name = "REGISTRATION_NAME")
    private String registrationName;

    @Column(name = "STREET_NAME")
    protected String streetName;

    @Column(name = "CITY_SUBDIVISION_NAME")
    protected String citySubdivisionName;

    @Column(name = "CITY_NAME")
    protected String cityName;

    @Column(name = "COUNTRY_SUBENTITY")
    protected String countrySubentity;

    @Column(name = "DISTRICT")
    protected String district;

    @Column(name = "COUNTRY_IDENTIFICATION_CODE")
    protected String countryIdentificationCode;

    @NotNull
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID")
    private InvoiceEntity invoice;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the assignedIdentificationId
	 */
	public String getAssignedIdentificationId() {
		return assignedIdentificationId;
	}

	/**
	 * @param assignedIdentificationId the assignedIdentificationId to set
	 */
	public void setAssignedIdentificationId(String assignedIdentificationId) {
		this.assignedIdentificationId = assignedIdentificationId;
	}

	/**
	 * @return the additionalAccountId
	 */
	public DocumentSnapshotEntity getAdditionalAccountId() {
		return additionalAccountId;
	}

	/**
	 * @param additionalAccountId the additionalAccountId to set
	 */
	public void setAdditionalAccountId(DocumentSnapshotEntity additionalAccountId) {
		this.additionalAccountId = additionalAccountId;
	}

	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * @return the registrationName
	 */
	public String getRegistrationName() {
		return registrationName;
	}

	/**
	 * @param registrationName the registrationName to set
	 */
	public void setRegistrationName(String registrationName) {
		this.registrationName = registrationName;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the citySubdivisionName
	 */
	public String getCitySubdivisionName() {
		return citySubdivisionName;
	}

	/**
	 * @param citySubdivisionName the citySubdivisionName to set
	 */
	public void setCitySubdivisionName(String citySubdivisionName) {
		this.citySubdivisionName = citySubdivisionName;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the countrySubentity
	 */
	public String getCountrySubentity() {
		return countrySubentity;
	}

	/**
	 * @param countrySubentity the countrySubentity to set
	 */
	public void setCountrySubentity(String countrySubentity) {
		this.countrySubentity = countrySubentity;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the countryIdentificationCode
	 */
	public String getCountryIdentificationCode() {
		return countryIdentificationCode;
	}

	/**
	 * @param countryIdentificationCode the countryIdentificationCode to set
	 */
	public void setCountryIdentificationCode(String countryIdentificationCode) {
		this.countryIdentificationCode = countryIdentificationCode;
	}

	/**
	 * @return the invoice
	 */
	public InvoiceEntity getInvoice() {
		return invoice;
	}

	/**
	 * @param invoice the invoice to set
	 */
	public void setInvoice(InvoiceEntity invoice) {
		this.invoice = invoice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrganizationSnapshotEntity other = (OrganizationSnapshotEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
