package org.wildfly.swarm.service;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class MyEjb {
	
	public String hello() {
		return "carlos";
	}
	
}