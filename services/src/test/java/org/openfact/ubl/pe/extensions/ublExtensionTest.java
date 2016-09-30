package org.openfact.ubl.pe.extensions;

import java.math.BigDecimal;

import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class ublExtensionTest {

	private AdditionalInformationTypeSunatAgg informacionAdicional;

	private ExtensionContentType contenidoDeExtension, contenidoSign;
	private static Marshaller marshallerElement;

	public void addTotalMonetary(AdditionalInformationType cod, BigDecimal monto) {
		IDType idAMonetaryTotal = new IDType();
		idAMonetaryTotal.setValue(cod.getValue());
		PayableAmountType pa = new PayableAmountType();
		pa.setCurrencyID("PEN");
		pa.setValue(monto);
		AdditionalMonetaryTotalType amtt = new AdditionalMonetaryTotalType();
		amtt.setID(idAMonetaryTotal);
		amtt.setPayableAmount(pa);
		informacionAdicional.getAdditionalMonetaryTotal().add(amtt);

	}

	public void addPropertyAdditional(String cod, String valor) {
		IDType IdPropiedadAdicional = new IDType();
		IdPropiedadAdicional.setValue(cod);
		ValueType valorDePropiedad = new ValueType();
		valorDePropiedad.setValue(valor);
		AdditionalPropertyType propiedadAdicional = new AdditionalPropertyType();
		propiedadAdicional.setID(IdPropiedadAdicional);
		propiedadAdicional.setValue(valorDePropiedad);
		informacionAdicional.getAdditionalProperty().add(propiedadAdicional);
	}

	public void generate() throws JAXBException, DatatypeConfigurationException {

		ObjectFactory fact = new ObjectFactory();
		JAXBElement<AdditionalInformationTypeSunatAgg> jeAits = fact.createAdditionalInformation(informacionAdicional);
		DOMResult res = new DOMResult();
		marshallerElement.marshal(jeAits, res);
		Element elem = ((Document) res.getNode()).getDocumentElement();

		/* init test marshall */
		InvoiceModel i = null;
		InvoiceType t = ModelToType.toType(i);

		UBLExtensionsType ex = null;

		UBLExtensionType ex1 = null;
		ExtensionContentType cc = null;
		cc.setAny(elem);
		ex1.setExtensionContent(cc);
		ex.addUBLExtension(ex1);

		t.setUBLExtensions(ex);
		/* end test marshall */
		// contenidoDeExtension=new ExtensionContentType();
		// contenidoDeExtension.setAny(elem);

	}

	
	
}
