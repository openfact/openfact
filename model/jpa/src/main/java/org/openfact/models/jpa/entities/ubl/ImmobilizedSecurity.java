package org.openfact.models.jpa.entities.ubl;


import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to describe an immobilized security to be used as a guarantee.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:32 a. m.
 */
public class ImmobilizedSecurity {

	/**
	 * The value of the security on the day it was immobilized.
	 */
	private BigDecimal faceValueAmount;
	/**
	 * An identifier for the certificate of this immobilized security.
	 */
	private String immobilizationCertificateID;
	/**
	 * The date on which this immobilized security was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The current market value of the immobilized security.
	 */
	private BigDecimal marketValueAmount;
	/**
	 * An identifier for the security being immobilized.
	 */
	private String securityID;

	public BigDecimal getFaceValueAmount() {
		return faceValueAmount;
	}

	public void setFaceValueAmount(BigDecimal faceValueAmount) {
		this.faceValueAmount = faceValueAmount;
	}

	public String getImmobilizationCertificateID() {
		return immobilizationCertificateID;
	}

	public void setImmobilizationCertificateID(String immobilizationCertificateID) {
		this.immobilizationCertificateID = immobilizationCertificateID;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public BigDecimal getMarketValueAmount() {
		return marketValueAmount;
	}

	public void setMarketValueAmount(BigDecimal marketValueAmount) {
		this.marketValueAmount = marketValueAmount;
	}

	public String getSecurityID() {
		return securityID;
	}

	public void setSecurityID(String securityID) {
		this.securityID = securityID;
	}

	public BigDecimal getSharesNumberQuantity() {
		return sharesNumberQuantity;
	}

	public void setSharesNumberQuantity(BigDecimal sharesNumberQuantity) {
		this.sharesNumberQuantity = sharesNumberQuantity;
	}

	public Party getIssuerParty() {
		return issuerParty;
	}

	public void setIssuerParty(Party issuerParty) {
		this.issuerParty = issuerParty;
	}

	/**
	 * The number of shares immobilized.
	 */
	private BigDecimal sharesNumberQuantity;
	private Party issuerParty;


}//end Immobilized Security