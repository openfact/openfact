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
package org.openfact.models.jpa.entities.ubl.common;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TRANSPORTATION_SERVICE")
public class TransportationServiceEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "TRANSPORT_SERVICE_CODE")
	protected String transportServiceCode;

	@Column(name = "TARIFF_CLASS_CODE")
	protected String tariffClassCode;

	@Column(name = "PRIORITY")
	protected String priority;

	@Column(name = "FREIGHT_RATE_CLASS_CODE")
	protected String freightRateClassCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTransportServiceCode() {
		return transportServiceCode;
	}

	public void setTransportServiceCode(String transportServiceCode) {
		this.transportServiceCode = transportServiceCode;
	}

	public String getTariffClassCode() {
		return tariffClassCode;
	}

	public void setTariffClassCode(String tariffClassCode) {
		this.tariffClassCode = tariffClassCode;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getFreightRateClassCode() {
		return freightRateClassCode;
	}

	public void setFreightRateClassCode(String freightRateClassCode) {
		this.freightRateClassCode = freightRateClassCode;
	}

}
