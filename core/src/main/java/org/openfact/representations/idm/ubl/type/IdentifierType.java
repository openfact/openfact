package org.openfact.representations.idm.ubl.type;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by lxpary on 08/09/16.
 */
@Embeddable
@Access(AccessType.FIELD)
public class IdentifierType {
	@Column(name = "VALUE")
	private String value;
	@Column(name = "SCHEME_ID")
	private String schemeID;
	@Column(name = "SCHEME_NAME")
	private String schemeName;
	@Column(name = "SCHEME_AGENCY_ID")
	private String schemeAgencyID;
	@Column(name = "SCHEME_AGENCY_NAME")
	private String schemeAgencyName;
	@Column(name = "SCHEME_VERSION_ID")
	private String schemeVersionID;
	@Column(name = "SCHEME_DATA_URI")
	private String schemeDataURI;
	@Column(name = "SCHEME_URI")
	private String schemeURI;

	public IdentifierType() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSchemeID() {
		return schemeID;
	}

	public void setSchemeID(String schemeID) {
		this.schemeID = schemeID;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeAgencyID() {
		return schemeAgencyID;
	}

	public void setSchemeAgencyID(String schemeAgencyID) {
		this.schemeAgencyID = schemeAgencyID;
	}

	public String getSchemeAgencyName() {
		return schemeAgencyName;
	}

	public void setSchemeAgencyName(String schemeAgencyName) {
		this.schemeAgencyName = schemeAgencyName;
	}

	public String getSchemeVersionID() {
		return schemeVersionID;
	}

	public void setSchemeVersionID(String schemeVersionID) {
		this.schemeVersionID = schemeVersionID;
	}

	public String getSchemeDataURI() {
		return schemeDataURI;
	}

	public void setSchemeDataURI(String schemeDataURI) {
		this.schemeDataURI = schemeDataURI;
	}

	public String getSchemeURI() {
		return schemeURI;
	}

	public void setSchemeURI(String schemeURI) {
		this.schemeURI = schemeURI;
	}
}
