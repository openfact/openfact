package org.wildfly.swarm.service;

import org.junit.runner.RunWith;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.wildfly.swarm.arquillian.DefaultDeployment;
import org.wildfly.swarm.service.MyEjb;
import org.junit.Assert;
import org.junit.Test;

@RunWith(Arquillian.class)
@DefaultDeployment(type = DefaultDeployment.Type.WAR)
public class MyEjbTest {

	@Inject 
	private MyEjb ejb;
	
	@Test
	public void should_start_service() {
		Assert.assertNotNull(ejb);
	}
}