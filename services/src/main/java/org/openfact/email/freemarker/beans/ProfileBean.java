package org.openfact.email.freemarker.beans;

import org.jboss.logging.Logger;
import org.openfact.models.InvoiceModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileBean {

    private static final Logger logger = Logger.getLogger(ProfileBean.class);

    private InvoiceModel user;
    private final Map<String, String> attributes = new HashMap<>();

    public ProfileBean(InvoiceModel user) {
        this.user = user;

        if (user.getAttributes() != null) {
            for (Map.Entry<String, List<String>> attr : user.getAttributes().entrySet()) {
                List<String> attrValue = attr.getValue();
                if (attrValue != null && attrValue.size() > 0) {
                    attributes.put(attr.getKey(), attrValue.get(0));
                }

                if (attrValue != null && attrValue.size() > 1) {
                    logger.warnf("There are more values for attribute '%s' of user '%s' . Will display just first value", attr.getKey(), user.getCustomer().getRegistrationName());
                }
            }
        }
    }

    public String getUsername() { return user.getCustomer().getRegistrationName(); }

    public String getFirstName() {
        return user.getCustomer().getAdditionalAccountId().getName();
    }

    public String getLastName() {
        return user.getCustomer().getRegistrationName();
    }

    public String getEmail() {
        return user.getCustomer().getEmail();
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
