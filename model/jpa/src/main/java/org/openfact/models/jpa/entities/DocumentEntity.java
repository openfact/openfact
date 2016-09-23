package org.openfact.models.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "DOCUMENT")
@IdClass(DocumentEntity.Key.class)
public abstract class DocumentEntity {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATALOG_ID")
	protected CatalogEntity catalog;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHILDREN_ID")
	protected CatalogEntity children;

	@Column(name = "VALUE")
	protected BigDecimal value;
	
	@Column(name = "PERCENT_VALUE")
	protected String percentValue;
	
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "STATUS")
    private boolean status;
		
	public CatalogEntity getCatalog() {
		return catalog;
	}

	public void setCatalog(CatalogEntity catalog) {
		this.catalog = catalog;
	}

	public CatalogEntity getChildren() {
		return children;
	}

	public void setChildren(CatalogEntity children) {
		this.children = children;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getPercentValue() {
		return percentValue;
	}

	public void setPercentValue(String percentValue) {
		this.percentValue = percentValue;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static class Key implements Serializable {

		protected CatalogEntity catalog;

		protected CatalogEntity children;

		public Key() {

		}
		
		public Key(CatalogEntity catalog, CatalogEntity children) {
			super();
			this.catalog = catalog;
			this.children = children;
		}

		public CatalogEntity getCatalog() {
			return catalog;
		}

		public CatalogEntity getChildren() {
			return children;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Key key = (Key) o;

			if (catalog != null
					? !catalog.getId().equals(key.catalog != null ? key.catalog.getId() : null)
					: key.catalog != null)
				return false;
			if (children != null ? !children.getId().equals(key.children != null ? key.children.getId() : null) : key.children != null)
				return false;

			return true;
		}
		@Override
		public int hashCode() {
			int result = catalog != null ? catalog.getId().hashCode() : 0;
			result = 31 * result + (children != null ? children.getId().hashCode() : 0);
			return result;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof DocumentEntity))
			return false;

		DocumentEntity key = (DocumentEntity) o;

		if (catalog != null ? !catalog.getId().equals(key.catalog != null ? key.catalog.getId() : null)
				: key.catalog != null)
			return false;
		if (children != null ? !children.getId().equals(key.children != null ? key.children.getId() : null) : key.children != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = catalog != null ? catalog.getId().hashCode() : 0;
		result = 31 * result + (children != null ? children.getId().hashCode() : 0);
		return result;
	}
}




