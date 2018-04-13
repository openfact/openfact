package org.openfact.pe.messages;

import org.apache.camel.CamelContext;
import org.apache.camel.cdi.ContextName;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "SunatTopicMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "/jms/topic/my-topic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
})
public class SunatTopicMDB implements MessageListener {

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelContext;

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("received: " + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void printProductDetails(String id) {
//        ProducerTemplate template = camelContext.createProducerTemplate();
//        try {
//
//            ProductRequest request = new ProductRequest();
//            request.setId(id);
//
//            ProductResponse response = template.requestBody("direct:start", request, ProductResponse.class);
//        } catch (CamelExecutionException p) {
//            System.out.println(p.getCause());
//        }
    }

}
