package org.openfact.models;

import org.junit.runner.RunWith;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.wildfly.swarm.arquillian.DefaultDeployment;
import org.junit.Assert;
import org.junit.Test;

@RunWith(Arquillian.class)
@DefaultDeployment
public class MyProviderTest {

    @Inject
    private MyProvider provider;

    @Test
    public void should_start_service() {
        Assert.assertNotNull(provider);
        Assert.assertEquals(provider.hello(), "hello");
    }
}