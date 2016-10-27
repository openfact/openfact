package org.openfact.models.jpa.entities.ubl.common.pe;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.jpa.entities.ubl.common.ExchangeRateEntity;

@Entity
@Table(name = "RETENTION_INFORMATION")
public class RetentionInformationEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "RETENTION_AMOUNT")
	protected BigDecimal sunatRetentionAmount;

	@Column(name = "RETENTION_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime sunatRetentionDate;

	@Column(name = "NET_TOTAL_PAID")
	protected BigDecimal sunatNetTotalPaid;

	@ManyToOne(targetEntity = ExchangeRateEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "EXCHANGERATE_RETENTIONINFORMATION_ID")
	protected ExchangeRateEntity exchangeRate=new ExchangeRateEntity();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getSunatRetentionAmount() {
		return sunatRetentionAmount;
	}

	public void setSunatRetentionAmount(BigDecimal sunatRetentionAmount) {
		this.sunatRetentionAmount = sunatRetentionAmount;
	}

	public LocalDateTime getSunatRetentionDate() {
		return sunatRetentionDate;
	}

	public void setSunatRetentionDate(LocalDateTime sunatRetentionDate) {
		this.sunatRetentionDate = sunatRetentionDate;
	}

	public BigDecimal getSunatNetTotalPaid() {
		return sunatNetTotalPaid;
	}

	public void setSunatNetTotalPaid(BigDecimal sunatNetTotalPaid) {
		this.sunatNetTotalPaid = sunatNetTotalPaid;
	}

	public ExchangeRateEntity getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(ExchangeRateEntity exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	

}
