package org.openfact.services;

import org.openfact.DocumentsResource;
import org.openfact.models.FileProvider;
import org.openfact.models.FileProviderVendor;
import org.openfact.models.files.FileException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Transactional
@ApplicationScoped
public class DefaultDocumentsResource implements DocumentsResource {

    @Override
    public void getDocuments() {

    }

}
