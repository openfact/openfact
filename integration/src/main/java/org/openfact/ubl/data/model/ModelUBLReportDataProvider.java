package org.openfact.ubl.data.model;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentModel;
import org.openfact.ubl.data.UBLReportDataProvider;

import javax.ejb.Stateless;

@Stateless
public class ModelUBLReportDataProvider implements UBLReportDataProvider {

    private static final Logger logger = Logger.getLogger(ModelUBLReportDataProvider.class);

    @Override
    public Object getFieldValue(DocumentModel document, String fieldName) {
        ModelSupportedAttribute attribute = ModelSupportedAttribute.fromString(fieldName.toUpperCase());
        if (attribute != null) {
            switch (attribute) {
                case OF_MODEL_ID:
                    return document.getId();
            }
        }
        return null;
    }
}
