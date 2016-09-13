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

/**
 * A class to describe a customer party.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:16 a. m.
 */
@Entity
@Table(name = "CUSTOMER_PARTY")
public class CustomerPartyEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * An identifier for the customer's account, assigned by a third party.
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
	 * An identifier for the customer's account, assigned by the customer
	 * itself.
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
	 * An identifier for the customer's account, assigned by the supplier.
	 */
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "value", column = @Column(name = "SUPPLIERASSIGNEDACCOUNTID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "SUPPLIERASSIGNEDACCOUNTID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "SUPPLIERASSIGNEDACCOUNTID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "SUPPLIERASSIGNEDACCOUNTID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "SUPPLIERASSIGNEDACCOUNTID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "SUPPLIERASSIGNEDACCOUNTID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "SUPPLIERASSIGNEDACCOUNTID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "SUPPLIERASSIGNEDACCOUNTID_SCHEMEURI")) })
	private IdentifierType supplierAssignedAccountID;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREDIT_NOTE_ID")
	private CreditNoteEntity creditNote;

	@Transient
	private ContactEntity deliveryContact;

	@Transient
	private ContactEntity accountingContact;

	@Transient
	private ContactEntity buyerContact;

	@OneToMany(mappedBy = "customerParty", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CustumerPartyPartyMappingEntity> parties = new ArrayList<>();

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
	 * @return the additionalAccountID
	 */
	public IdentifierType getAdditionalAccountID() {
		return additionalAccountID;
	}

	/**
	 * @param additionalAccountID the additionalAccountID to set
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
	 * @param customerAssignedAccountID the customerAssignedAccountID to set
	 */
	public void setCustomerAssignedAccountID(IdentifierType customerAssignedAccountID) {
		this.customerAssignedAccountID = customerAssignedAccountID;
	}

	/**
	 * @return the supplierAssignedAccountID
	 */
	public IdentifierType getSupplierAssignedAccountID() {
		return supplierAssignedAccountID;
	}

	/**
	 * @param supplierAssignedAccountID the supplierAssignedAccountID to set
	 */
	public void setSupplierAssignedAccountID(IdentifierType supplierAssignedAccountID) {
		this.supplierAssignedAccountID = supplierAssignedAccountID;
	}

	/**
	 * @return the creditNote
	 */
	public CreditNoteEntity getCreditNote() {
		return creditNote;
	}

	/**
	 * @param creditNote the creditNote to set
	 */
	public void setCreditNote(CreditNoteEntity creditNote) {
		this.creditNote = creditNote;
	}

	/**
	 * @return the deliveryContact
	 */
	public ContactEntity getDeliveryContact() {
		return deliveryContact;
	}

	/**
	 * @param deliveryContact the deliveryContact to set
	 */
	public void setDeliveryContact(ContactEntity deliveryContact) {
		this.deliveryContact = deliveryContact;
	}

	/**
	 * @return the accountingContact
	 */
	public ContactEntity getAccountingContact() {
		return accountingContact;
	}

	/**
	 * @param accountingContact the accountingContact to set
	 */
	public void setAccountingContact(ContactEntity accountingContact) {
		this.accountingContact = accountingContact;
	}

	/**
	 * @return the buyerContact
	 */
	public ContactEntity getBuyerContact() {
		return buyerContact;
	}

	/**
	 * @param buyerContact the buyerContact to set
	 */
	public void setBuyerContact(ContactEntity buyerContact) {
		this.buyerContact = buyerContact;
	}

	/**
	 * @return the parties
	 */
	public List<CustumerPartyPartyMappingEntity> getParties() {
		return parties;
	}

	/**
	 * @param parties the parties to set
	 */
	public void setParties(List<CustumerPartyPartyMappingEntity> parties) {
		this.parties = parties;
	}

	
}
