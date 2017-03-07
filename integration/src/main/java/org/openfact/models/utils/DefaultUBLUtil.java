package org.openfact.models.utils;

import org.openfact.models.ModelException;
import org.openfact.models.types.DocumentType;
import org.openfact.ubl.UBLReaderWriterProvider;
import org.openfact.ubl.qualifiers.UBLDocumentType;
import org.openfact.ubl.qualifiers.UBLProviderType;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import java.lang.annotation.Annotation;

@Stateless
public class DefaultUBLUtil implements UBLUtil {

    @Inject
    @Any
    private Instance<UBLReaderWriterProvider> ublReaderWriters;

    @Override
    public UBLReaderWriterProvider getFactory(String providerType, DocumentType documentType) {
        return getFactory(providerType, documentType.toString());
    }

    @Override
    public UBLReaderWriterProvider getFactory(String providerType, String documentType) {
        Annotation providerTypeLiteral = new ProviderTypeLiteral(providerType);
        Annotation documentTypeLiteral = new DocumentTypeLiteral(documentType);

        Instance<UBLReaderWriterProvider> instance = ublReaderWriters.select(providerTypeLiteral, documentTypeLiteral);
        if (instance.isAmbiguous() || instance.isUnsatisfied()) {
            throw new ModelException("Insuficient information to get an instance of UBLReader");
        }
        return ublReaderWriters.select(providerTypeLiteral, documentTypeLiteral).get();
    }

    public class ProviderTypeLiteral extends AnnotationLiteral<UBLProviderType> implements UBLProviderType {
        private final String value;

        public ProviderTypeLiteral(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }
    }

    public class DocumentTypeLiteral extends AnnotationLiteral<UBLDocumentType> implements UBLDocumentType {
        private final String value;

        public DocumentTypeLiteral(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }
    }

}
