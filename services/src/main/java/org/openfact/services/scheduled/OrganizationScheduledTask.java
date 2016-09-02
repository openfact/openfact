package org.openfact.services.scheduled;

import java.util.List;

import org.openfact.email.EmailException;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.OrganizationModel;
import org.openfact.timer.ScheduledTask;

public class OrganizationScheduledTask implements ScheduledTask {

    protected OrganizationModel organization;
    
    public OrganizationScheduledTask(OrganizationModel organization) {
        this.organization = organization;
    }
    
    @Override
    public void run(OpenfactSession session) {             
        
    }

}
