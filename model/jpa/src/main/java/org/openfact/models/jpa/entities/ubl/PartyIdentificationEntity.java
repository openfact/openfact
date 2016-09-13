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
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.ubl.type.IdentifierType;

/**
 * A class to define an identifier for a party.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:26 a. m.
 */
@Entity
@Table(name = "PARTY_IDENTIFICATION")
public class PartyIdentificationEntity {
	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * An identifier for the party.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "ID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "ID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "ID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "ID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "ID_SCHEMEURI")) })
	private IdentifierType ID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "PARTY_ID")
	private PartyEntity party;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the iD
	 */
	public IdentifierType getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(IdentifierType iD) {
		ID = iD;
	}

	/**
	 * @return the party
	 */
	public PartyEntity getParty() {
		return party;
	}

	/**
	 * @param party
	 *            the party to set
	 */
	public void setParty(PartyEntity party) {
		this.party = party;
	}

}
