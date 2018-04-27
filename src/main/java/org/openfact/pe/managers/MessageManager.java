package org.openfact.pe.managers;

import org.openfact.pe.models.InvoiceModel;
import org.openfact.pe.models.NotaModel;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class MessageManager {

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:/jms/topic/my-topic")
    private Topic topic;


    public void enviarInvoice(InvoiceModel invoice) {

    }

    public void enviarNota(NotaModel nota) {

    }

}
