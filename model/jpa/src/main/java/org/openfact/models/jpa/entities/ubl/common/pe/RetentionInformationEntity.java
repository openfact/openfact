/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
