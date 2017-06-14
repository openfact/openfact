package org.sistcoop;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
@LocalBean
public class MyEJB implements Serializable {

    private static final long serialVersionUID = -1L;

    public String hello() {
        return "Hello";
    }
}