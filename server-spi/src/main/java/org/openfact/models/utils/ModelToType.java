package org.openfact.models.utils;

import java.time.LocalDate;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openfact.models.ubl.*;
import org.openfact.models.ubl.common.*;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.*;

public class ModelToType {

	public static InvoiceType toType(InvoiceModel model) throws DatatypeConfigurationException {
		InvoiceType type = new InvoiceType();
		type.setIssueDate(toType(model.getIssueDate()));
		type.setUBLExtensions(toType(model.getUBLExtensions()));
		type.setAccountingSupplierParty(toType(model.getAccountingSupplierParty()));
		
		
		
	//	type.setInvoiceTypeCode(model.getInvoiceModelCode());	
		
		return type;
	}

	private static UBLExtensionsType toType(UBLExtensionsModel model) {
		UBLExtensionsType type = new UBLExtensionsType();
		for (UBLExtensionModel item : model.getUBLExtension()) {
			type.addUBLExtension(toType(item));
		}

		return null;
	}

	private static UBLExtensionType toType(UBLExtensionModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	private static SupplierPartyType toType(SupplierPartyModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	private static SignatureType toType(SignatureModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	public static XMLGregorianCalendar toType(LocalDate date) throws DatatypeConfigurationException {
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
	}
}
