package org.wildfly.swarm.howto.incontainer;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

@RunWith(Arquillian.class)
@DefaultDeployment(testable = false, type = DefaultDeployment.Type.WAR)
public class OrganizationProviderIT {

    @Test
    public void test() {
        Assert.assertEquals(43, 43);
    }

}
