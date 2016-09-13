package org.openfact.models.jpa.entities.ubl;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.ubl.type.CountryIdentificationCodeType;
import org.openfact.models.ubl.type.NameType;

/**
 * A class to describe a country.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:11 a. m.
 */
@Entity
@Table(name = "COUNTRY")
public class CountryEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * A code signifying this country.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "IDENTIFICATIONCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "IDENTIFICATIONCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "IDENTIFICATIONCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "IDENTIFICATIONCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "IDENTIFICATIONCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "IDENTIFICATIONCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "IDENTIFICATIONCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "IDENTIFICATIONCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "IDENTIFICATIONCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "IDENTIFICATIONCODE_SCHEMEURI")) })
	private CountryIdentificationCodeType identificationCode;
	/**
	 * The name of this country.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "NAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "NAME_LANGUAGE")) })
	private NameType name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "ADDRESS_ID")
	private AddressEntity address;

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
	 * @return the identificationCode
	 */
	public CountryIdentificationCodeType getIdentificationCode() {
		return identificationCode;
	}

	/**
	 * @param identificationCode the identificationCode to set
	 */
	public void setIdentificationCode(CountryIdentificationCodeType identificationCode) {
		this.identificationCode = identificationCode;
	}

	/**
	 * @return the name
	 */
	public NameType getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(NameType name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public AddressEntity getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
	

}
