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
