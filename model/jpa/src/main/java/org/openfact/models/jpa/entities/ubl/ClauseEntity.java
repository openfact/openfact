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
 * A class to define a clause (a distinct article or provision) in a contract,
 * treaty, will, or other formal or legal written document requiring compliance.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:35 a. m.
 */
@Entity
@Table(name = "CLAUSE")
public class ClauseEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * The text of this clause.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CONTENT_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "CONTENT_LANGUAGEID")) })
	private TextType content;
	/**
	 * An identifier for this clause.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "ID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "ID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "ID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "ID_SCHEMEDATAURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "ID_SCHEMEURI")) })
	private IdentifierType ID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "PAYMENT_MANDATE_ID")
	private PaymentMandateEntity paymentMandate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TextType getContent() {
		return content;
	}

	public void setContent(TextType content) {
		this.content = content;
	}

	public IdentifierType getID() {
		return ID;
	}

	public void setID(IdentifierType iD) {
		ID = iD;
	}

	public PaymentMandateEntity getPaymentMandate() {
		return paymentMandate;
	}

	public void setPaymentMandate(PaymentMandateEntity paymentMandate) {
		this.paymentMandate = paymentMandate;
	}
	
}
