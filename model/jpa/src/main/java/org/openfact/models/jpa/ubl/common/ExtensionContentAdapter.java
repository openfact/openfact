/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa.ubl.common;

import java.io.ByteArrayOutputStream;

import javax.persistence.EntityManager;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;

import org.apache.commons.lang.ArrayUtils;
import org.jboss.logging.Logger;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ExtensionContentEntity;
import org.openfact.models.ubl.common.ExtensionContentModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExtensionContentAdapter implements ExtensionContentModel, JpaModel<ExtensionContentEntity> {

    protected static final Logger logger = Logger.getLogger(ExtensionContentAdapter.class);
    protected ExtensionContentEntity extensionContent;
    protected EntityManager em;
    protected OpenfactSession session;

    public ExtensionContentAdapter(OpenfactSession session, EntityManager em,
            ExtensionContentEntity extensionContent) {
        this.session = session;
        this.em = em;
        this.extensionContent = extensionContent;
    }

    @Override
    public Element getAny() {
        if(this.extensionContent.getAny() != null) {
            Transformer transformer;
            try {
                transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(DocumentUtils.byteToDocument(this.extensionContent.getAny()));
                Element elem = ((Document) source.getNode()).getDocumentElement();
                return elem;
            } catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
                throw new ModelException(e);
            } catch (Exception e) {
                throw new ModelException(e);
            }
        }
        return  null;
    }

    @Override
    public void setAny(Element value) {
        if (value != null) {
            try {
                Document document = value.getOwnerDocument();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DocumentUtils.elementToByte(document.getDocumentElement(), baos);
                this.extensionContent.setAny(ArrayUtils.toObject(baos.toByteArray()));
            } catch (TransformerException e) {
                throw new ModelException(e);
            }
        } else {
            this.extensionContent.setAny(null);
        }
    }

    @Override
    public String getId() {
        return this.extensionContent.getId();
    }

    @Override
    public String getAnyItem() {
        return this.extensionContent.getAny().toString();
    }

    @Override
    public void setAnyItem(String target) {
        // TODO
    }

    public static ExtensionContentEntity toEntity(ExtensionContentModel model, EntityManager em) {
        if (model instanceof ExtensionContentAdapter) {
            return ((ExtensionContentAdapter) model).getEntity();
        }
        return em.getReference(ExtensionContentEntity.class, model.getId());
    }

    @Override
    public ExtensionContentEntity getEntity() {
        return extensionContent;
    }

}
