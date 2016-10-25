package org.openfact.services.scheduled;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OrganizationModel;
import org.openfact.ubl.send.UblTaskRunnerProvider;

public class OrganizationScheduledTaskRunner implements Runnable {

    protected OpenfactSession session;
    protected OpenfactSessionFactory sessionFactory;

    protected OrganizationModel organization;

    public OrganizationScheduledTaskRunner(OpenfactSessionFactory sessionFactory,
            OrganizationModel organization) {
        this.sessionFactory = sessionFactory;
        this.session = sessionFactory.create();
        this.organization = organization;
    }

    @Override
    public void run() {
        UblTaskRunnerProvider provider = session.getProvider(UblTaskRunnerProvider.class,
                organization.getDefaultUblLocale());
        provider.exececuteTask(organization);
    }

}
