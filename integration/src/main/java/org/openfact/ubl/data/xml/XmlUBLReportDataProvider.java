/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.ubl.data.xml;

import javax.ejb.Stateless;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.report.*;
import org.openfact.ubl.UBLModel;
import org.openfact.ubl.UBLReportDataProvider;

@Stateless
public class XmlUBLReportDataProvider implements UBLReportDataProvider {

    private static final Logger logger = Logger.getLogger(XmlUBLReportDataProvider.class);

    @Override
    public int getProviderPriority() {
        return 0;
    }

    @Override
    public ReportDataProvider<DocumentModel> document() {
        return new ReportDataProvider<DocumentModel>() {
            @Override
            public Object getFieldValue(DocumentModel invoice, String fieldName) {
                XmlSupportedAttribute attribute = XmlSupportedAttribute.fromString(fieldName.toUpperCase());
                if (attribute != null) {
                    return attribute.asObject(invoice.getXmlAsJSONObject());
                }
                return null;
            }
        };
    }

}
