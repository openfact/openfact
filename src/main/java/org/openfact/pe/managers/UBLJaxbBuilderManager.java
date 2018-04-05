package org.openfact.pe.managers;

import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.BoletaFacturaModel;
import org.openfact.pe.models.InformacionAdicionalModel;
import org.openfact.pe.models.utils.ModelToJaxb;
import org.openfact.pe.ubl20.xsd.invoice_2.InvoiceType;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class UBLJaxbBuilderManager {

//    @Inject
//    private FileProvider fileProvider;

//    @Inject
//    private JMSContext context;

//    @Resource(lookup = "/jms/topic/sunat-topic")
//    private Topic topic;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildBoletaFacturaJaxb(
            OrganizationModel organization,
            InformacionAdicionalModel informacionAdicionalModel,
            BoletaFacturaModel boletaFactura
    ) {
        InvoiceType invoiceType = ModelToJaxb.toInvoiceType(organization, informacionAdicionalModel, boletaFactura);

        // Guardar archivo xml
//        try {
//            fileProvider.addFile(null, null, null);
//        } catch (FileException e) {
//            e.printStackTrace();
//        }

        // Enviar a la sunat
//        JMSProducer send = context.createProducer().send(topic, "");
    }

}
