package org.openfact.models;

/**
 * @author carlosthe19916@sistcoop.com
 */

public interface OrganizationSnapshotModel {

	String getId();

	String getAssignedIdentificationId();

	void setAssignedIdentificationId(String assignedIdentificationId);

	DocumentSnapshotModel getAdditionalAccountId();

	void setAdditionalAccountId(String documentName, String documentId);

	String getSupplierName();

	void setSuppliername(String supplierName);

	String getRegistrationName();

	void setRegistrationName(String registrationName);

	/**
	 * Postal address
	 */
	String getStreetName();

	void setStreetName(String streetName);

	String getCitySubdivisionName();

	void setCitySubdivisionName(String citySubdivisionName);

	String getCityName();

	void setCityName(String cityName);

	String getCountrySubentity();

	void setCountrySubentity(String countrySubentity);

	String getDistrict();

	void setDistrict(String district);

	String getCountryIdentificationCode();

	void setCountryIdentificationCode(String countryIdentificationCode);

}
