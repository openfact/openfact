package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe the distribution of a document to an interested party.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:32 a. m.
 */
public class DocumentDistribution {

	/**
	 * The maximum number of printed copies of the document that the interested
	 * party is allowed to make.
	 */
	private BigDecimal maximumCopiesNumeric;
	/**
	 * Text describing the interested party's distribution rights.
	 */
	private String printQualifier;
	private List<Party> partys=new ArrayList<>();

	public DocumentDistribution() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getMaximumCopiesNumeric() {
		return maximumCopiesNumeric;
	}

	public void setMaximumCopiesNumeric(BigDecimal maximumCopiesNumeric) {
		this.maximumCopiesNumeric = maximumCopiesNumeric;
	}

	public String getPrintQualifier() {
		return printQualifier;
	}

	public void setPrintQualifier(String printQualifier) {
		this.printQualifier = printQualifier;
	}


	public List<Party> getPartys() {
		return partys;
	}

	public void setPartys(List<Party> partys) {
		this.partys = partys;
	}
}// end DocumentDistribution