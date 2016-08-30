package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentSnapshotModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationSnapshotModel;
import org.openfact.models.jpa.entities.DocumentSnapshotEntity;
import org.openfact.models.jpa.entities.OrganizationSnapshotEntity;

public class OrganizationSnapshotAdapter implements OrganizationSnapshotModel, JpaModel<OrganizationSnapshotEntity> {

	protected static final Logger logger = Logger.getLogger(OrganizationSnapshotAdapter.class);

	protected InvoiceModel invoice;
	protected OrganizationSnapshotEntity organization;
	protected EntityManager em;
	protected OpenfactSession session;

	public OrganizationSnapshotAdapter(OpenfactSession session, InvoiceModel invoice, EntityManager em,
			OrganizationSnapshotEntity organizationSnapshot) {
		this.session = session;
		this.em = em;
		this.invoice = invoice;
		this.organization = organizationSnapshot;
	}

	@Override
	public OrganizationSnapshotEntity getEntity() {
		return organization;
	}

	@Override
	public String getId() {
		return organization.getId();
	}

	@Override
	public String getAssignedIdentificationId() {
		return organization.getAssignedIdentificationId();
	}

	@Override
	public void setAssignedIdentificationId(String assignedIdentificationId) {
		organization.setAssignedIdentificationId(assignedIdentificationId);
	}

	@Override
	public DocumentSnapshotModel getAdditionalAccountId() {
		return new DocumentSnapshotAdapter(session, em, organization.getAdditionalAccountId());
	}

	@Override
	public void setAdditionalAccountId(String documentName, String documentId) {
		DocumentSnapshotEntity document = new DocumentSnapshotEntity();
		document.setName(documentName);
		document.setDocumentId(documentId);
		organization.setAdditionalAccountId(document);
	}

	@Override
	public String getSupplierName() {
		return organization.getSupplierName();
	}

	@Override
	public void setSuppliername(String supplierName) {
		organization.setSupplierName(supplierName);
	}

	@Override
	public String getRegistrationName() {
		return organization.getRegistrationName();
	}

	@Override
	public void setRegistrationName(String registrationName) {
		organization.setRegistrationName(registrationName);
	}

	@Override
	public String getStreetName() {
		return organization.getStreetName();
	}

	@Override
	public void setStreetName(String streetName) {
		organization.setStreetName(streetName);
	}

	@Override
	public String getCitySubdivisionName() {
		return organization.getCitySubdivisionName();
	}

	@Override
	public void setCitySubdivisionName(String citySubdivisionName) {
		organization.setCitySubdivisionName(citySubdivisionName);
	}

	@Override
	public String getCityName() {
		return organization.getCityName();
	}

	@Override
	public void setCityName(String cityName) {
		organization.setCityName(cityName);
	}

	@Override
	public String getCountrySubentity() {
		return organization.getCountrySubentity();
	}

	@Override
	public void setCountrySubentity(String countrySubentity) {
		organization.setCountrySubentity(countrySubentity);
	}

	@Override
	public String getDistrict() {
		return organization.getDistrict();
	}

	@Override
	public void setDistrict(String district) {
		organization.setDistrict(district);
	}

	@Override
	public String getCountryIdentificationCode() {
		return organization.getCountryIdentificationCode();
	}

	@Override
	public void setCountryIdentificationCode(String countryIdentificationCode) {
		organization.setCountryIdentificationCode(countryIdentificationCode);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
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
		OrganizationSnapshotAdapter other = (OrganizationSnapshotAdapter) obj;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		return true;
	}

}
