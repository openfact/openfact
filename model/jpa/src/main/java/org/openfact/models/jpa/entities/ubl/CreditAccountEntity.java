package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to identify a credit account for sales on account.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:12 a. m.
 */
@Entity
@Table(name = "CREDIT_ACCOUNT")
public class CreditAccountEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * An identifier for this credit account.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "ACCOUNTID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "ACCOUNTID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ACCOUNTID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ACCOUNTID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "ACCOUNTID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "ACCOUNTID_SCHEMEDATAURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "ACCOUNTID_SCHEMEURI")) })
	private IdentifierType accountID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "PAYMENT_MEANS_ID")
	private PaymentMeansEntity paymentMeans;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IdentifierType getAccountID() {
		return accountID;
	}

	public void setAccountID(IdentifierType accountID) {
		this.accountID = accountID;
	}

	public PaymentMeansEntity getPaymentMeans() {
		return paymentMeans;
	}

	public void setPaymentMeans(PaymentMeansEntity paymentMeans) {
		this.paymentMeans = paymentMeans;
	}
	
}
