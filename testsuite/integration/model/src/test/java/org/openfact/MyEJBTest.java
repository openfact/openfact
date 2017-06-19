package org.openfact;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class MyEJBTest {

    @Inject
    MyEJB myEJB;

    @Deployment
    public static Archive deploy(){
        return ShrinkWrap.create(WebArchive.class, "test.war").addClass(MyEJB.class);
    }

    @Test
    public void emptyInContainerTest(){
        System.out.println("=========================================");
        System.out.println("This test should run inside the container");
        System.out.println("=========================================");

        Assert.assertNotNull(myEJB.hello());
    }

}
