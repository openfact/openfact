package org.openfact.models;

import javax.ejb.Stateless;

@Stateless
public class MyProvider {

    public String hello() {
        return "hello";
    }
}
