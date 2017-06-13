package org.openfact.models.utils;

import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.components.utils.ComponentUtil;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AuthDetails;
import org.openfact.models.*;
import org.openfact.component.ComponentModel;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.representations.idm.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Stateless
public class ModelToRepresentation {

    @Inject
    private ComponentUtil componentUtil;

    public OrganizationRepresentation toRepresentation(OrganizationModel organization, boolean internal) {
        /**
         * General information
         */
        OrganizationRepresentation rep = new OrganizationRepresentation();
        rep.setId(organization.getId());
        rep.setOrganization(organization.getName());
        rep.setDescription(organization.getDescription());
        rep.setEnabled(organization.isEnabled());
        if (organization.getCreatedTimestamp() != null) {
            rep.setCreatedTimestamp(Date.from(organization.getCreatedTimestamp().atZone(ZoneId.systemDefault()).toInstant()));
        }

        rep.setAdditionalAccountId(organization.getAdditionalAccountId());
        rep.setAssignedIdentificationId(organization.getAssignedIdentificationId());
        rep.setRegistrationName(organization.getRegistrationName());
        rep.setSupplierName(organization.getSupplierName());

        /**
         * Postal address
         */
        PostalAddressRepresentation postalAddressRep = new PostalAddressRepresentation();
        postalAddressRep.setPostalAddressId(organization.getPostalAddressId());
        postalAddressRep.setStreetName(organization.getStreetName());
        postalAddressRep.setCitySubdivisionName(organization.getCitySubdivisionName());
        postalAddressRep.setCityName(organization.getCityName());
        postalAddressRep.setCountrySubentity(organization.getCountrySubentity());
        postalAddressRep.setDistrict(organization.getDistrict());
        postalAddressRep.setCountryIdentificationCode(organization.getCountryIdentificationCode());
        rep.setPostalAddress(postalAddressRep);

        /**
         * Themes
         */
        rep.setEmailTheme(organization.getEmailTheme());
        rep.setReportTheme(organization.getReportTheme());

        /**
         * Internationalization
         */
        rep.setInternationalizationEnabled(organization.isInternationalizationEnabled());
        if (organization.getSupportedLocales() != null) {
            rep.setSupportedLocales(new HashSet<String>());
            rep.getSupportedLocales().addAll(organization.getSupportedLocales());
        }
        rep.setDefaultLocale(organization.getDefaultLocale());

        /**
         * Tasks schedule
         */
        rep.setTaskFirstTime(organization.getTaskFirstTime());
        rep.setTaskDelay(organization.getTaskDelay());
        rep.setTasksEnabled(organization.isTasksEnabled());

        /**
         * Currencies
         */
        rep.setDefaultCurrency(organization.getDefaultCurrency());
        if (organization.getSupportedCurrencies() != null) {
            rep.setSupportedCurrencies(new HashSet<String>());
            rep.getSupportedCurrencies().addAll(organization.getSupportedCurrencies());
        }

        /**
         * Events
         */
        rep.setEventsEnabled(organization.isEventsEnabled());
        if (organization.getEventsExpiration() != 0) {
            rep.setEventsExpiration(organization.getEventsExpiration());
        }
        if (organization.getEventsListeners() != null) {
            rep.setEventsListeners(new LinkedList<String>(organization.getEventsListeners()));
        }
        if (organization.getEnabledEventTypes() != null) {
            rep.setEnabledEventTypes(new LinkedList<String>(organization.getEnabledEventTypes()));
        }
        rep.setAdminEventsEnabled(organization.isAdminEventsEnabled());
        rep.setAdminEventsDetailsEnabled(organization.isAdminEventsDetailsEnabled());

        /**
         * Smtp server
         */
        rep.setSmtpServer(new HashMap<>(organization.getSmtpConfig()));

        /**
         * Attributes
         */
        rep.setAttributes(new HashMap<>(organization.getAttributes()));

        if (internal) {

        }

        return rep;
    }

    public DocumentRepresentation toRepresentation(DocumentModel model, boolean includeLine) {
        DocumentRepresentation rep = new DocumentRepresentation();

        rep.setId(model.getId());
        rep.setDocumentId(model.getDocumentId());
        rep.setDocumentType(model.getDocumentType());
        if (model.getCreatedTimestamp() != null) {
            rep.setCreatedTimestamp(Date.from(model.getCreatedTimestamp().atZone(ZoneId.systemDefault()).toInstant()));
        }
        rep.setEnabled(model.isEnabled());

        rep.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        rep.setCustomerRegistrationName(model.getCustomerRegistrationName());
        rep.setCustomerAssignedAccountId(model.getCustomerAssignedAccountId());
        rep.setCustomerElectronicMail(model.getCustomerElectronicMail());

        if (model.getAttributes() != null && !model.getAttributes().isEmpty()) {
            Map<String, List<String>> attrs = new HashMap<>();
            attrs.putAll(model.getAttributes());
            rep.setAttributes(attrs);
        }

        if (model.getRequiredActions() != null) {
            rep.setRequiredActions(new HashSet<String>());
            rep.getRequiredActions().addAll(model.getRequiredActions());
        }

        Function<DocumentModel, DocumentRepresentation> attachedDocumentRepFunction = (documentModel) -> {
            DocumentRepresentation documentRepresentation = new DocumentRepresentation();
            documentRepresentation.setId(documentModel.getId());
            documentRepresentation.setDocumentId(documentModel.getDocumentId());
            documentRepresentation.setDocumentType(documentModel.getDocumentType());
            return documentRepresentation;
        };

        if (model.getAttachedDocumentsAsOrigin() != null && !model.getAttachedDocumentsAsOrigin().isEmpty()) {
            rep.setAttachedDocumentsAsOrigin(model.getAttachedDocumentsAsOrigin().stream().map(attachedDocumentRepFunction).collect(Collectors.toList()));
        }
        if (model.getAttachedDocumentsAsDestiny() != null && !model.getAttachedDocumentsAsDestiny().isEmpty()) {
            rep.setAttachedDocumentsAsDestiny(model.getAttachedDocumentsAsDestiny().stream().map(attachedDocumentRepFunction).collect(Collectors.toList()));
        }

        if (includeLine) {
            if (model.getDocumentLines() != null && !model.getDocumentLines().isEmpty()) {
                List<Map<String, String>> documentLines = model.getDocumentLines().stream().map(DocumentLineModel::getAttributes).collect(Collectors.toList());
                rep.setDocumentLines(documentLines);
            }
        }

        return rep;
    }

    public OrganizationEventsConfigRepresentation toEventsConfigReprensetation(OrganizationModel organization) {
        OrganizationEventsConfigRepresentation rep = new OrganizationEventsConfigRepresentation();
        rep.setEventsEnabled(organization.isEventsEnabled());

        if (organization.getEventsExpiration() != 0) {
            rep.setEventsExpiration(organization.getEventsExpiration());
        }
        if (organization.getEventsListeners() != null) {
            rep.setEventsListeners(new LinkedList<>(organization.getEventsListeners()));
        }
        if (organization.getEnabledEventTypes() != null) {
            rep.setEnabledEventTypes(new LinkedList<>(organization.getEnabledEventTypes()));
        }
        rep.setAdminEventsEnabled(organization.isAdminEventsEnabled());
        rep.setAdminEventsDetailsEnabled(organization.isAdminEventsDetailsEnabled());

        return rep;
    }

    public AdminEventRepresentation toRepresentation(AdminEvent adminEvent) {
        AdminEventRepresentation rep = new AdminEventRepresentation();
        rep.setTime(adminEvent.getTime());
        rep.setOrganizationId(adminEvent.getOrganizationId());
        if (adminEvent.getAuthDetails() != null) {
            rep.setAuthDetails(toRepresentation(adminEvent.getAuthDetails()));
        }
        rep.setOperationType(adminEvent.getOperationType().toString());
        if (adminEvent.getResourceType() != null) {
            rep.setResourceType(adminEvent.getResourceType().toString());
        }
        rep.setResourcePath(adminEvent.getResourcePath());
        rep.setRepresentation(adminEvent.getRepresentation());
        rep.setError(adminEvent.getError());

        return rep;
    }

    public AuthDetailsRepresentation toRepresentation(AuthDetails authDetails) {
        AuthDetailsRepresentation rep = new AuthDetailsRepresentation();
        rep.setOrganizationId(authDetails.getOrganizationId());
        rep.setUserId(authDetails.getUserId());
        rep.setIpAddress(authDetails.getIpAddress());
        return rep;
    }

    public List<ConfigPropertyRepresentation> toRepresentation(List<ProviderConfigProperty> configProperties) {
        List<ConfigPropertyRepresentation> propertiesRep = new LinkedList<>();
        for (ProviderConfigProperty prop : configProperties) {
            ConfigPropertyRepresentation propRep = toRepresentation(prop);
            propertiesRep.add(propRep);
        }
        return propertiesRep;
    }

    public ConfigPropertyRepresentation toRepresentation(ProviderConfigProperty prop) {
        ConfigPropertyRepresentation propRep = new ConfigPropertyRepresentation();
        propRep.setName(prop.getName());
        propRep.setLabel(prop.getLabel());
        propRep.setType(prop.getType());
        propRep.setDefaultValue(prop.getDefaultValue());
        propRep.setOptions(prop.getOptions());
        propRep.setHelpText(prop.getHelpText());
        propRep.setSecret(prop.isSecret());
        return propRep;
    }

    public ComponentRepresentation toRepresentation(ComponentModel component, boolean internal) {
        ComponentRepresentation rep = new ComponentRepresentation();
        rep.setId(component.getId());
        rep.setName(component.getName());
        rep.setProviderId(component.getProviderId());
        rep.setProviderType(component.getProviderType());
        rep.setSubType(component.getSubType());
        rep.setParentId(component.getParentId());
        if (internal) {
            rep.setConfig(component.getConfig());
        } else {
            Map<String, ProviderConfigProperty> configProperties = componentUtil.getComponentConfigProperties(component);
            MultivaluedHashMap<String, String> config = new MultivaluedHashMap<>();

            for (Map.Entry<String, List<String>> e : component.getConfig().entrySet()) {
                ProviderConfigProperty configProperty = configProperties.get(e.getKey());
                if (configProperty != null) {
                    if (configProperty.isSecret()) {
                        config.putSingle(e.getKey(), ComponentRepresentation.SECRET_VALUE);
                    } else {
                        config.put(e.getKey(), e.getValue());
                    }
                }
            }

            rep.setConfig(config);
        }
        return rep;
    }

    public SendEventRepresentation toRepresentation(SendEventModel model) {
        SendEventRepresentation rep = new SendEventRepresentation();
        rep.setId(model.getId());
        rep.setDestinyType(model.getDestityType().toString());
        rep.setResult(model.getResult().toString());
        rep.setDescription(model.getDescription());
        if (model.getCreatedTimestamp() != null) {
            rep.setCreatedTimestamp(Date.from(model.getCreatedTimestamp().atZone(ZoneId.systemDefault()).toInstant()));
        }

        if (model.getAttributes() != null && !model.getAttributes().isEmpty()) {
            Map<String, String> attrs = new HashMap<>();
            attrs.putAll(model.getAttributes());
            rep.setResponseAttributes(attrs);
        }

        /*if (model.getAttachedFiles() != null && !model.getAttachedFiles().isEmpty()) {
            rep.setResponseFileAttachments(new ArrayList<>());
            List<FileRepresentation> filesRep = model.getAttachedFiles().stream().map(f -> {
                FileRepresentation fileRep = new FileRepresentation();
                fileRep.setId(f.getId());
                fileRep.setFileName(f.getFileName());
                return fileRep;
            }).collect(Collectors.toList());
            rep.getResponseFileAttachments().addAll(filesRep);
        }*/
        return rep;
    }

    public JobReportRepresentation toRepresentation(AdminJobReport model) {
        JobReportRepresentation rep = new JobReportRepresentation();
        rep.setId(model.getId());
        rep.setJobName(model.getJobName());
        rep.setDuration(model.getDuration());
        rep.setStartTime(model.getStartTime());
        rep.setEndTime(model.getEndTime());
        rep.setErrorCount(model.getErrorCount());
        rep.setReadCount(model.getReadCount());
        rep.setWriteCount(model.getWriteCount());
        return rep;
    }

    public JobReportRepresentation toRepresentation(JobReportModel model) {
        JobReportRepresentation rep = new JobReportRepresentation();
        rep.setId(model.getId());
        rep.setJobName(model.getJobName());
        rep.setDuration(model.getDuration());
        rep.setStartTime(model.getStartTime());
        rep.setEndTime(model.getEndTime());
        rep.setErrorCount(model.getErrorCount());
        rep.setReadCount(model.getReadCount());
        rep.setWriteCount(model.getWriteCount());
        return rep;
    }
}
