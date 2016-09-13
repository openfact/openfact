package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.openfact.models.jpa.entities.ubl.InvoiceLinePriceMappingEntity.Key;

@Table(name = "INVOICE_LINE_PRICE_MAPPING")
@Entity
@IdClass(InvoiceLineTaxTotalMappingEntity.Key.class)
public class InvoiceLineTaxTotalMappingEntity {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INVOICE_LINE_ID")
	protected InvoiceLineEntity invoiceLine;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAX_TOTAL_ID")
	protected TaxTotalEntity taxTotal;

	public InvoiceLineEntity getInvoiceLine() {
		return invoiceLine;
	}

	public void setInvoiceLine(InvoiceLineEntity invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

	public TaxTotalEntity getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(TaxTotalEntity taxTotal) {
		this.taxTotal = taxTotal;
	}
	
	public static class Key implements Serializable {

		protected InvoiceLineEntity invoiceLine;

		protected TaxTotalEntity taxTotal;

		public Key() {

		}

		public Key(InvoiceLineEntity invoiceLine, TaxTotalEntity taxTotal) {
			super();
			this.invoiceLine = invoiceLine;
			this.taxTotal = taxTotal;
		}

		public InvoiceLineEntity getInvoiceLine() {
			return invoiceLine;
		}

		public TaxTotalEntity getTaxTotal() {
			return taxTotal;
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
			if (taxTotal != null ? !taxTotal.getId().equals(key.taxTotal != null ? key.taxTotal.getId() : null) : key.taxTotal != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = invoiceLine != null ? invoiceLine.getId().hashCode() : 0;
			result = 31 * result + (taxTotal != null ? taxTotal.getId().hashCode() : 0);
			return result;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof InvoiceLineTaxTotalMappingEntity))
			return false;

		InvoiceLineTaxTotalMappingEntity key = (InvoiceLineTaxTotalMappingEntity) o;

		if (invoiceLine != null ? !invoiceLine.getId().equals(key.invoiceLine != null ? key.invoiceLine.getId() : null)
				: key.invoiceLine != null)
			return false;
		if (taxTotal != null ? !taxTotal.getId().equals(key.taxTotal != null ? key.taxTotal.getId() : null) : key.taxTotal != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = invoiceLine != null ? invoiceLine.getId().hashCode() : 0;
		result = 31 * result + (taxTotal != null ? taxTotal.getId().hashCode() : 0);
		return result;
	}

}
