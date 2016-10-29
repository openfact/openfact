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
@Table(name = "TRANSPORT_EQUIPAMENT_SEAL")
public class TransportEquipmentSealEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "SEAL_ISSUER_TYPE_CODE")
	protected String sealIssuerTypeCode;

	@Column(name = "CONDITION")
	protected String condition;

	@Column(name = "SEAL_STATUS_CODE")
	protected String sealStatusCode;

	@Column(name = "SEALIN_GPARTY_TYPE")
	protected String sealingPartyType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSealIssuerTypeCode() {
		return sealIssuerTypeCode;
	}

	public void setSealIssuerTypeCode(String sealIssuerTypeCode) {
		this.sealIssuerTypeCode = sealIssuerTypeCode;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getSealStatusCode() {
		return sealStatusCode;
	}

	public void setSealStatusCode(String sealStatusCode) {
		this.sealStatusCode = sealStatusCode;
	}

	public String getSealingPartyType() {
		return sealingPartyType;
	}

	public void setSealingPartyType(String sealingPartyType) {
		this.sealingPartyType = sealingPartyType;
	}

}
