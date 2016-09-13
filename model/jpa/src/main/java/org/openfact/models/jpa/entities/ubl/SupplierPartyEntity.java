package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe a supplier party.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:00 a. m.
 */
@Entity
@Table(name = "SUPPLIER_PARTY")
public class SupplierPartyEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;

	/**
	 * An additional identifier for this supplier party.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ADDITIONALACCOUNTID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "ADDITIONALACCOUNTID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "ADDITIONALACCOUNTID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ADDITIONALACCOUNTID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ADDITIONALACCOUNTID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "ADDITIONALACCOUNTID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "ADDITIONALACCOUNTID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "ADDITIONALACCOUNTID_SCHEMEURI")) })
	private IdentifierType additionalAccountID;
	/**
	 * An identifier for this supplier party, assigned by the customer.
	 */
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "value", column = @Column(name = "CUSTOMERASSIGNEDACCOUNTID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "CUSTOMERASSIGNEDACCOUNTID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "CUSTOMERASSIGNEDACCOUNTID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "CUSTOMERASSIGNEDACCOUNTID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "CUSTOMERASSIGNEDACCOUNTID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "CUSTOMERASSIGNEDACCOUNTID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "CUSTOMERASSIGNEDACCOUNTID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "CUSTOMERASSIGNEDACCOUNTID_SCHEMEURI")) })
	private IdentifierType customerAssignedAccountID;
	/**
	 * Text describing the supplier's ability to send invoice data via a
	 * purchase card provider (e.g., VISA, MasterCard, American Express).
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DATASENDINGCAPABILITY_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DATASENDINGCAPABILITY_LANGUAGE")) })
	private TextType dataSendingCapability;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREDIT_NOTE_ID")
	private CreditNoteEntity creditNote;

	@Transient
	private ContactEntity sellerContact;

	@Transient
	private ContactEntity accountingContact;

	@Transient
	private ContactEntity despatchContact;

	@OneToMany(mappedBy = "supplierParty", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<SupplierPartyPartyMappingEntity> parties = new ArrayList<>();

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
	 * @return the additionalAccountID
	 */
	public IdentifierType getAdditionalAccountID() {
		return additionalAccountID;
	}

	/**
	 * @param additionalAccountID
	 *            the additionalAccountID to set
	 */
	public void setAdditionalAccountID(IdentifierType additionalAccountID) {
		this.additionalAccountID = additionalAccountID;
	}

	/**
	 * @return the customerAssignedAccountID
	 */
	public IdentifierType getCustomerAssignedAccountID() {
		return customerAssignedAccountID;
	}

	/**
	 * @param customerAssignedAccountID
	 *            the customerAssignedAccountID to set
	 */
	public void setCustomerAssignedAccountID(IdentifierType customerAssignedAccountID) {
		this.customerAssignedAccountID = customerAssignedAccountID;
	}

	/**
	 * @return the dataSendingCapability
	 */
	public TextType getDataSendingCapability() {
		return dataSendingCapability;
	}

	/**
	 * @param dataSendingCapability
	 *            the dataSendingCapability to set
	 */
	public void setDataSendingCapability(TextType dataSendingCapability) {
		this.dataSendingCapability = dataSendingCapability;
	}

	/**
	 * @return the creditNote
	 */
	public CreditNoteEntity getCreditNote() {
		return creditNote;
	}

	/**
	 * @param creditNote
	 *            the creditNote to set
	 */
	public void setCreditNote(CreditNoteEntity creditNote) {
		this.creditNote = creditNote;
	}

	/**
	 * @return the sellerContact
	 */
	public ContactEntity getSellerContact() {
		return sellerContact;
	}

	/**
	 * @param sellerContact
	 *            the sellerContact to set
	 */
	public void setSellerContact(ContactEntity sellerContact) {
		this.sellerContact = sellerContact;
	}

	/**
	 * @return the accountingContact
	 */
	public ContactEntity getAccountingContact() {
		return accountingContact;
	}

	/**
	 * @param accountingContact
	 *            the accountingContact to set
	 */
	public void setAccountingContact(ContactEntity accountingContact) {
		this.accountingContact = accountingContact;
	}

	/**
	 * @return the despatchContact
	 */
	public ContactEntity getDespatchContact() {
		return despatchContact;
	}

	/**
	 * @param despatchContact
	 *            the despatchContact to set
	 */
	public void setDespatchContact(ContactEntity despatchContact) {
		this.despatchContact = despatchContact;
	}

	/**
	 * @return the parties
	 */
	public List<SupplierPartyPartyMappingEntity> getParties() {
		return parties;
	}

	/**
	 * @param parties the parties to set
	 */
	public void setParties(List<SupplierPartyPartyMappingEntity> parties) {
		this.parties = parties;
	}

	

}
