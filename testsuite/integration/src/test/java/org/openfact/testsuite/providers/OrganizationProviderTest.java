package org.openfact.testsuite.providers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.openfact.events.EventStoreProvider;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AdminEventQuery;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;

public class OrganizationProviderTest extends AbstractProviderTest {

    @Test
    public void createWithoutId() throws Exception {
        OrganizationProvider provider = session.organizations();
        OrganizationModel organization = provider.createOrganization("SISTCOOP");
        commit();
        
        assertThat(organization, is(notNullValue()));
        assertThat(organization.getId(), is(notNullValue()));
        assertThat(organization.getId(), not(equalTo("SISTCOOP")));
        assertThat(organization.getName(), is(equalTo("SISTCOOP")));
    }
    
    @Test
    public void createWithId() throws Exception {
        OrganizationProvider provider = session.organizations();
        OrganizationModel organization = provider.createOrganization("SISTCOOP_ID", "SISTCOOP_NAME");
        commit();
        
        assertThat(organization, is(notNullValue()));
        assertThat(organization.getId(), is(notNullValue()));
        assertThat(organization.getId(), is(equalTo("SISTCOOP_ID")));
        assertThat(organization.getName(), is(equalTo("SISTCOOP_NAME")));
    }
    
    /*@Test
    public void createAdminEvent() throws Exception {
        OrganizationProvider provider = session.organizations();
        provider.createOrganization("SISTCOOP1");
        provider.createOrganization("SISTCOOP2");
        commit();
        
        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        AdminEventQuery query = eventStore.createAdminQuery();        
        List<AdminEvent> events = query.getResultList();
        
        assertThat(events, is(notNullValue()));
        assertThat(events.size(), is(2));
    }*/
    
    @Test
    public void getOrganizationById() throws Exception {
        OrganizationModel organization1 = session.organizations().createOrganization("SISTCOOP");
        commit();        
        
        OrganizationModel organization2 = session.organizations().getOrganization(organization1.getId());        
        assertThat(organization2, is(notNullValue()));
        assertThat(organization2.getId(), is(notNullValue()));
        assertThat(organization2.getId(), is(equalTo(organization1.getId())));
        assertThat(organization2.getName(), is(equalTo(organization1.getName())));
    }
    
    @Test
    public void getOrganizationByName() throws Exception {
        session.organizations().createOrganization("SISTCOOP");
        commit();        
        
        OrganizationModel organization = session.organizations().getOrganizationByName("SISTCOOP");        
        assertThat(organization, is(notNullValue()));
        assertThat(organization.getId(), is(notNullValue()));
        assertThat(organization.getName(), is(equalTo("SISTCOOP")));
    }
    
    @Test
    public void getOrganizations() throws Exception {
        session.organizations().createOrganization("SISTCOOP1");
        session.organizations().createOrganization("SISTCOOP2");
        session.organizations().createOrganization("SISTCOOP3");
        commit();        
        
        List<OrganizationModel> organizations = session.organizations().getOrganizations();     
        assertThat(organizations, is(notNullValue()));
        assertThat(organizations.size(), is(4));
    }
    
    @Test
    public void removeByModel() throws Exception {
        session.organizations().createOrganization("SISTCOOP");
        commit();        
        
        OrganizationModel organization = model.getOrganizationByName("SISTCOOP");
        assertThat(session.organizations().removeOrganization(organization), is(true));
        assertThat(session.organizations().removeOrganization(organization), is(false));
        assertThat(session.organizations().getOrganizationByName("SISTCOOP"), is(nullValue()));
    }
    
    @Test
    public void removeById() throws Exception {
        session.organizations().createOrganization("SISTCOOP");
        commit();        
        
        OrganizationModel organization = model.getOrganizationByName("SISTCOOP");
        assertThat(session.organizations().removeOrganization(organization.getId()), is(true));
        assertThat(session.organizations().removeOrganization(organization.getId()), is(false));
        assertThat(session.organizations().getOrganizationByName("SISTCOOP"), is(nullValue()));
    }
    
    @Test
    public void count() throws Exception {
        session.organizations().createOrganization("SISTCOOP1");
        session.organizations().createOrganization("SISTCOOP2");
        session.organizations().createOrganization("SISTCOOP3");
        commit();     
        
        assertThat(session.organizations().getOrganizationsCount(), is(4));
    }
    
}
