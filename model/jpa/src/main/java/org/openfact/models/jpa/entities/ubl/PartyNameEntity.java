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
import org.openfact.models.ubl.type.NameType;

/**
 * A class for defining the name of a party.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:30 a. m.
 */
@Entity
@Table(name = "PARTY_NAME")
public class PartyNameEntity {


	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
    /**
     * The name of the party.
     */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "NAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "NAME_LANGUAGE")) })
    private NameType name;
    
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
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the party
	 */
	public PartyEntity getParty() {
		return party;
	}

	/**
	 * @param party the party to set
	 */
	public void setParty(PartyEntity party) {
		this.party = party;
	}

    
}
