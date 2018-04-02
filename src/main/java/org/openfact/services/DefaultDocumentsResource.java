package org.openfact.services;

import org.openfact.DocumentsResource;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class DefaultDocumentsResource implements DocumentsResource {

    @Override
    public void getDocuments() {

    }

}
