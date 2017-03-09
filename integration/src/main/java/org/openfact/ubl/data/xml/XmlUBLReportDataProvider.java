package org.openfact.ubl.data.xml;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentModel;
import org.openfact.ubl.data.UBLReportDataProvider;

import javax.ejb.Stateless;

@Stateless
public class XmlUBLReportDataProvider implements UBLReportDataProvider {

    private static final Logger logger = Logger.getLogger(XmlUBLReportDataProvider.class);


    @Override
    public Object getFieldValue(DocumentModel document, String fieldName) {
        XmlSupportedAttribute attribute = XmlSupportedAttribute.fromString(fieldName.toUpperCase());
        if (attribute != null) {
            return attribute.asObject(document.getXmlAsJSONObject());
        }
        return null;
    }
}
