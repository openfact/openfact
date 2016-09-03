package org.openfact.ubl;

import org.openfact.common.util.ObjectUtil;
import org.openfact.email.EmailException;
import org.openfact.email.EmailSenderProvider;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.email.freemarker.beans.EventBean;
import org.openfact.email.freemarker.beans.ProfileBean;
import org.openfact.events.Event;
import org.openfact.events.EventType;
import org.openfact.theme.FreeMarkerException;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.beans.MessageFormatterMethod;
import org.w3c.dom.Document;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;

import java.text.MessageFormat;
import java.util.*;

public class DefaultUblProvider implements UblProvider {

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Document getDocument(OrganizationModel organization, InvoiceModel invoice) throws UblException {
        // TODO Auto-generated method stub
        return null;
    }

}
