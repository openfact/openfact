package org.openfact.ubl.data;

import org.openfact.models.DocumentModel;

public interface UBLReportDataProvider {

    Object getFieldValue(DocumentModel document, String fieldName);

}
