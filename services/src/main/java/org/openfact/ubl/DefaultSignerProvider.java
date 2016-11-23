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
package org.openfact.ubl;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;

import org.openfact.models.KeyManager;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.w3c.dom.Document;

public class DefaultSignerProvider implements SignerProvider {

    protected OpenfactSession session;

    public DefaultSignerProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public Document sign(Document document, OrganizationModel organization) {
        try {
            // Create XML Signature Factory
            XMLSignatureFactory xmlSigFactory = XMLSignatureFactory.getInstance("DOM");
            KeyManager keystore = session.keys();
            PrivateKey privateKey = keystore.getActiveKey(organization).getPrivateKey();

            DOMSignContext domSignCtx = new DOMSignContext(privateKey, document.getDocumentElement());
            Reference ref = null;
            SignedInfo signedInfo = null;

            ref = xmlSigFactory.newReference("", xmlSigFactory.newDigestMethod(DigestMethod.SHA1, null),
                    Collections.singletonList(xmlSigFactory.newTransform(Transform.ENVELOPED, 
                            (TransformParameterSpec) null)), null, null);
            
            signedInfo = xmlSigFactory.newSignedInfo(
                    xmlSigFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), 
                    xmlSigFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));

            // Pass the Public Key File Path
            KeyInfo keyInfo = getKeyInfo(organization, keystore);

            // Create a new XML Signature
            XMLSignature xmlSignature = xmlSigFactory.newXMLSignature(signedInfo, keyInfo);

            // Sign the document
            xmlSignature.sign(domSignCtx);
            return document;
        } catch (NoSuchAlgorithmException ex) {
            throw new ModelException(ex);
        } catch (InvalidAlgorithmParameterException ex) {
            throw new ModelException(ex);
        } catch (MarshalException ex) {
            throw new ModelException(ex);
        } catch (XMLSignatureException ex) {
            throw new ModelException(ex);
        }
    }

    protected KeyInfo getKeyInfo(OrganizationModel organization, KeyManager keystore) {
        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance();
        KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        List<X509Certificate> x509Content = new ArrayList<>();

        x509Content.add(keystore.getActiveKey(organization).getCertificate());
        X509Data xdata = keyInfoFactory.newX509Data(x509Content);
        KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(xdata));
        return keyInfo;
    }

    @Override
    public void close() {
    }

}
