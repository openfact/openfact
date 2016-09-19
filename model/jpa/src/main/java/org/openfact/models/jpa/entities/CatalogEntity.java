package org.openfact.models.jpa.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.ModelException;
import org.openfact.models.enums.DocumentType;

@Entity
@Table(name = "CATALOG", uniqueConstraints = { @UniqueConstraint(columnNames = { "ORGANIZATION_ID", "TYPE", "CODE" }),
		@UniqueConstraint(columnNames = { "ORGANIZATION_ID", "TYPE", "CATALOG_ID" }) })
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "DOCUMENT_TYPE")
public abstract class CatalogEntity {

	@Id
	@Access(AccessType.PROPERTY)
	@Column(name = "ID", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	protected String id;

	@NotNull
	@Column(name = "CATALOG_ID")
	protected String documentId;

	@Column(name = "CODE")
	protected String code;

	@Column(name = "ABBREVIATION")
	protected String abbreviation;

	@NotNull
	@Column(name = "NAME")
	protected String name;

	@Column(name = "DESCRIPTION")
	protected String description;

	@Column(name = "VALUE")
	protected BigDecimal value;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE")
	protected DocumentType type;

	@OneToMany(mappedBy = "catalog", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<DocumentEntity> catalog = new ArrayList<>();

	@OneToMany(mappedBy = "children", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<DocumentEntity> children = new ArrayList<>();

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
	protected OrganizationEntity organization;

	public void add(CatalogEntity catalog) {
		throw new ModelException("Current operation is not support for this object");
	}

	public boolean remove(CatalogEntity catalog) {
		throw new ModelException("Current operation is not support for this object");
	}

	public boolean removeByCatalogId(String catalogId) {
		throw new ModelException("Current operation is not support for this object");
	}

	public boolean removeByname(String catalogname) {
		throw new ModelException("Current operation is not support for this object");
	}

	public CatalogEntity getChildByCatalogId(String catalogId) {
		throw new ModelException("Current operation is not support for this object");
	}

	public CatalogEntity getChildByName(String documentName) {
		throw new ModelException("Current operation is not support for this object");
	}

	public List<CatalogEntity> getChildrens() {
		throw new ModelException("Current operation is not support for this object");
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
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

	public DocumentType getType() {
		return type;
	}

	public void setType(DocumentType type) {
		this.type = type;
	}

	public List<DocumentEntity> getCatalog() {
		return catalog;
	}

	public void setCatalog(List<DocumentEntity> catalog) {
		this.catalog = catalog;
	}

	public List<DocumentEntity> getChildren() {
		return children;
	}

	public void setChildren(List<DocumentEntity> children) {
		this.children = children;
	}

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatalogEntity other = (CatalogEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
