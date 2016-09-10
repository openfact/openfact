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
public class LineStatusCodeType {
	@Column(name = "VALUE")
	protected String value;
	@Column(name = "LIST_ID")
	protected String listID;
	@Column(name = "LIST_AGENCY_ID")
	protected String listAgencyID;
	@Column(name = "LIST_AGENCY_NAME")
	protected String listAgencyName;
	@Column(name = "LIST_NAME")
	protected String listName;
	@Column(name = "LIST_VERSION_ID")
	protected String listVersionID;
	@Column(name = "NAME")
	protected String name;
	@Column(name = "LANGUAGE_ID")
	protected String languageID;
	@Column(name = "LIST_URL")
	protected String listURI;
	@Column(name = "LIST_SCHEME_URL")
	protected String listSchemeURI;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getListID() {
		return listID;
	}

	public void setListID(String listID) {
		this.listID = listID;
	}

	public String getListAgencyID() {
		return listAgencyID;
	}

	public void setListAgencyID(String listAgencyID) {
		this.listAgencyID = listAgencyID;
	}

	public String getListAgencyName() {
		return listAgencyName;
	}

	public void setListAgencyName(String listAgencyName) {
		this.listAgencyName = listAgencyName;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getListVersionID() {
		return listVersionID;
	}

	public void setListVersionID(String listVersionID) {
		this.listVersionID = listVersionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguageID() {
		return languageID;
	}

	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}

	public String getListURI() {
		return listURI;
	}

	public void setListURI(String listURI) {
		this.listURI = listURI;
	}

	public String getListSchemeURI() {
		return listSchemeURI;
	}

	public void setListSchemeURI(String listSchemeURI) {
		this.listSchemeURI = listSchemeURI;
	}
}
