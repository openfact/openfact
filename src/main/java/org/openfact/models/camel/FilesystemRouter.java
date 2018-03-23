package org.openfact.models.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ContextName("cdi-context")
public class FilesystemRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start").transform(body().prepend("Hi ")).log(body().toString());
    }

}
