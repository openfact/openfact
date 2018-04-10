package org.openfact.pe.managers;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

@ApplicationScoped
public class CFXManager {

    @Inject
    private JMSContext context;

    @Resource(lookup = "/jms/topic/my-topic")
    private Topic topic;

    public void test() {
        context.createProducer().send(topic, "Hello!");
    }
}
