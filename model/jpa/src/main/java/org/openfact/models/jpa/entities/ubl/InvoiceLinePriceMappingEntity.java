package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "INVOICE_LINE_PRICE_MAPPING")
@Entity
@IdClass(InvoiceLinePriceMappingEntity.Key.class)
public class InvoiceLinePriceMappingEntity {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INVOICE_LINE_ID")
	protected InvoiceLineEntity invoiceLine;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRICE_ID")
	protected PriceEntity price;

	public InvoiceLineEntity getInvoiceLine() {
		return invoiceLine;
	}

	public void setInvoiceLine(InvoiceLineEntity invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

	public PriceEntity getPrice() {
		return price;
	}

	public void setPrice(PriceEntity price) {
		this.price = price;
	}

	public static class Key implements Serializable {

		protected InvoiceLineEntity invoiceLine;

		protected PriceEntity price;

		public Key() {

		}

		public Key(InvoiceLineEntity invoiceLine, PriceEntity price) {
			super();
			this.invoiceLine = invoiceLine;
			this.price = price;
		}

		public InvoiceLineEntity getInvoiceLine() {
			return invoiceLine;
		}

		public PriceEntity getPrice() {
			return price;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Key key = (Key) o;

			if (invoiceLine != null
					? !invoiceLine.getId().equals(key.invoiceLine != null ? key.invoiceLine.getId() : null)
					: key.invoiceLine != null)
				return false;
			if (price != null ? !price.getId().equals(key.price != null ? key.price.getId() : null) : key.price != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = invoiceLine != null ? invoiceLine.getId().hashCode() : 0;
			result = 31 * result + (price != null ? price.getId().hashCode() : 0);
			return result;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof InvoiceLinePriceMappingEntity))
			return false;

		InvoiceLinePriceMappingEntity key = (InvoiceLinePriceMappingEntity) o;

		if (invoiceLine != null ? !invoiceLine.getId().equals(key.invoiceLine != null ? key.invoiceLine.getId() : null)
				: key.invoiceLine != null)
			return false;
		if (price != null ? !price.getId().equals(key.price != null ? key.price.getId() : null) : key.price != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = invoiceLine != null ? invoiceLine.getId().hashCode() : 0;
		result = 31 * result + (price != null ? price.getId().hashCode() : 0);
		return result;
	}
}
