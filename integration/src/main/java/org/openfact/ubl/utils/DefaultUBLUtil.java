package org.openfact.ubl.utils;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.models.types.DocumentType;
import org.openfact.ubl.UBLCustomizator;
import org.openfact.ubl.UBLIDGenerator;
import org.openfact.ubl.UBLReaderWriter;
import org.openfact.ubl.UBLThirdPartySender;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.provider.ProviderType;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import java.lang.annotation.Annotation;

@Stateless
public class DefaultUBLUtil implements UBLUtil {

    private static final Logger logger = Logger.getLogger(DefaultUBLUtil.class);

    public static final String READER_WRITER = "readerWriter";
    public static final String ID_GENERATOR = "idGenerator";
    public static final String MODEL_CUSTOMIZATION = "modelCustomization";
    public static final String THIRD_PARTY_SENDER = "thirdPartySender";

    @Inject
    @Any
    private Instance<UBLReaderWriter> readerWriterProviders;

    @Inject
    @Any
    private Instance<UBLIDGenerator> idGenerators;

    @Inject
    @Any
    private Instance<UBLCustomizator> customizationProviders;

    @Inject
    @Any
    private Instance<UBLThirdPartySender> senderProviders;

    /**
     * Writer Reader
     */
    @Override
    public UBLReaderWriter getReaderWriter(DocumentType documentType) {
        return getReaderWriter(documentType.toString());
    }

    @Override
    public UBLReaderWriter getReaderWriter(String documentType) {
        return getReaderWriter(Config.scope(documentType.toLowerCase()).get(READER_WRITER, "default"), documentType);
    }

    @Override
    public UBLReaderWriter getReaderWriter(String providerType, String documentType) {
        Annotation providerTypeLiteral = new ProviderTypeLiteral(providerType);
        Annotation documentTypeLiteral = new DocumentTypeLiteral(documentType);

        Instance<UBLReaderWriter> instance = readerWriterProviders.select(providerTypeLiteral, documentTypeLiteral);
        if (!instance.isAmbiguous() && !instance.isUnsatisfied()) {
            return readerWriterProviders.select(providerTypeLiteral, documentTypeLiteral).get();
        }

        logger.warn("Insufficient information to get an instance of " + UBLReaderWriter.class.getSimpleName());
        return null;
    }

    /**
     * ID Generators
     */
    @Override
    public UBLIDGenerator getIDGenerator(DocumentType documentType) {
        return getIDGenerator(documentType.toString());
    }

    @Override
    public UBLIDGenerator getIDGenerator(String documentType) {
        return getIDGenerator(Config.scope(documentType.toLowerCase()).get(ID_GENERATOR, "default"), documentType);
    }

    @Override
    public UBLIDGenerator getIDGenerator(String providerType, String documentType) {
        Annotation providerTypeLiteral = new ProviderTypeLiteral(providerType);
        Annotation documentTypeLiteral = new DocumentTypeLiteral(documentType);

        Instance<UBLIDGenerator> instance = idGenerators.select(providerTypeLiteral, documentTypeLiteral);
        if (!instance.isAmbiguous() && !instance.isUnsatisfied()) {
            return idGenerators.select(providerTypeLiteral, documentTypeLiteral).get();
        }

        logger.warn("Insufficient information to get an instance of " + UBLIDGenerator.class.getSimpleName());
        return null;
    }

    /**
     * Customization providers
     */
    @Override
    public UBLCustomizator getCustomizationProvider(DocumentType documentType) {
        return getCustomizationProvider(documentType.toString());
    }

    @Override
    public UBLCustomizator getCustomizationProvider(String documentType) {
        return getCustomizationProvider(Config.scope(documentType.toLowerCase()).get(MODEL_CUSTOMIZATION, "default"), documentType);
    }

    @Override
    public UBLCustomizator getCustomizationProvider(String providerType, String documentType) {
        Annotation providerTypeLiteral = new ProviderTypeLiteral(providerType);
        Annotation documentTypeLiteral = new DocumentTypeLiteral(documentType);

        Instance<UBLCustomizator> instance = customizationProviders.select(providerTypeLiteral, documentTypeLiteral);
        if (!instance.isAmbiguous() && !instance.isUnsatisfied()) {
            return customizationProviders.select(providerTypeLiteral, documentTypeLiteral).get();
        }

        logger.warn("Insufficient information to get an instance of " + UBLCustomizator.class.getSimpleName());
        return null;
    }

    /**
     * Third party senders
     */
    @Override
    public UBLThirdPartySender getThirdPartySender(DocumentType documentType) {
        return getThirdPartySender(documentType.toString());
    }

    @Override
    public UBLThirdPartySender getThirdPartySender(String documentType) {
        return getThirdPartySender(Config.scope(documentType.toLowerCase()).get(THIRD_PARTY_SENDER, "default"), documentType);
    }

    @Override
    public UBLThirdPartySender getThirdPartySender(String providerType, String documentType) {
        Annotation providerTypeLiteral = new ProviderTypeLiteral(providerType);
        Annotation documentTypeLiteral = new DocumentTypeLiteral(documentType);

        Instance<UBLThirdPartySender> instance = senderProviders.select(providerTypeLiteral, documentTypeLiteral);
        if (!instance.isAmbiguous() && !instance.isUnsatisfied()) {
            return senderProviders.select(providerTypeLiteral, documentTypeLiteral).get();
        }

        logger.warn("Insufficient information to get an instance of " + UBLCustomizator.class.getSimpleName());
        return null;
    }

    /**
     * Literals
     */
    public class ProviderTypeLiteral extends AnnotationLiteral<ProviderType> implements ProviderType {
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
