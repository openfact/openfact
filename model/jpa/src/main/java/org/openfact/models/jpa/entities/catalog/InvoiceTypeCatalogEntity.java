package org.openfact.models.jpa.entities.catalog;

import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "INVOICE_TYPE_CATALOG")
public class InvoiceTypeCatalogEntity {
	@Id
	@Access(AccessType.PROPERTY)
	@Column(name = "ID", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	protected String id;

	@Column(name = "ID_CATALOG")
	protected String ID;
	@Column(name = "CODE")
	protected String code;

	@NotNull
	@Column(name = "NAME")
	protected String name;

	@Column(name = "DESCRIPTION")
	protected String description;

	@Column(name = "VALUE")
	protected BigDecimal value;

	/**
	 * Locale
	 */

	@Column(name = "LOCALE")
	protected String locale;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
}
