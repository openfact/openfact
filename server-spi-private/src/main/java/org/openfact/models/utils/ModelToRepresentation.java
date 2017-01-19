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
package org.openfact.models.utils;

import java.util.*;
import java.util.stream.Collectors;

import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.component.ComponentModel;
import org.openfact.events.Event;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AuthDetails;
import org.openfact.models.*;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.representations.idm.*;

public class ModelToRepresentation {

    public static OrganizationRepresentation toRepresentation(OrganizationModel organization,
            boolean internal) {
        /**
         * General information
         */
        OrganizationRepresentation rep = new OrganizationRepresentation();
        rep.setId(organization.getId());
        rep.setOrganization(organization.getName());
        rep.setDescription(organization.getDescription());
        rep.setEnabled(organization.isEnabled());
        rep.setCreatedTimestamp(organization.getCreatedTimestamp());

        rep.setAdditionalAccountId(organization.getAdditionalAccountId());
        rep.setAssignedIdentificationId(organization.getAssignedIdentificationId());
        rep.setRegistrationName(organization.getRegistrationName());
        rep.setSupplierName(organization.getSupplierName());

        /**
         * Postal address
         */
        PostalAddressRepresentation postalAddressRep = new PostalAddressRepresentation();
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

    public static InvoiceRepresentation toRepresentation(InvoiceModel model) {
        InvoiceRepresentation rep = new InvoiceRepresentation();

        rep.setId(model.getId());
        rep.setDocumentId(model.getDocumentId());
        rep.setIssueDateTime(model.getIssueDateTime());
        rep.setDocumentCurrencyCode(model.getDocumentCurrencyCode());

        rep.setInvoiceTypeCode(model.getInvoiceTypeCode());

        rep.setCustomerRegistrationName(model.getCustomerRegistrationName());
        rep.setCustomerAssignedAccountId(model.getCustomerAssignedAccountId());
        rep.setCustomerAdditionalAccountId(model.getCustomerAdditionalAccountId());
        rep.setCustomerElectronicMail(model.getCustomerElectronicMail());

        rep.setAllowanceTotalAmount(model.getAllowanceTotalAmount());
        rep.setChargeTotalAmount(model.getChargeTotalAmount());
        rep.setPayableAmount(model.getPayableAmount());

        if (model.getAttributes() != null && !model.getAttributes().isEmpty()) {
            Map<String, List<String>> attrs = new HashMap<>();
            attrs.putAll(model.getAttributes());
            rep.setAttributes(attrs);
        }

        if(model.getRequiredActions() != null) {
            rep.setRequiredActions(new HashSet<String>());
            rep.getRequiredActions().addAll(model.getRequiredActions());
        }

        if(model.getAttatchedDocuments() != null) {
            List<AttatchedDocumentRepresentation> attatchedDocuments = new ArrayList<>();
            for (AttatchedDocumentModel attatchedDocument: model.getAttatchedDocuments()) {
                attatchedDocuments.add(toRepresentation(attatchedDocument));
            }
            rep.setAttatchedDocuments(attatchedDocuments);
        }

        return rep;
    }

    public static CreditNoteRepresentation toRepresentation(CreditNoteModel model) {
        CreditNoteRepresentation rep = new CreditNoteRepresentation();

        rep.setId(model.getId());
        rep.setDocumentId(model.getDocumentId());
        rep.setIssueDateTime(model.getIssueDateTime());
        rep.setDocumentCurrencyCode(model.getDocumentCurrencyCode());

        rep.setCustomerRegistrationName(model.getCustomerRegistrationName());
        rep.setCustomerAssignedAccountId(model.getCustomerAssignedAccountId());
        rep.setCustomerElectronicMail(model.getCustomerElectronicMail());

        rep.setAllowanceTotalAmount(model.getAllowanceTotalAmount());
        rep.setChargeTotalAmount(model.getChargeTotalAmount());
        rep.setPayableAmount(model.getPayableAmount());

        if (model.getAttributes() != null && !model.getAttributes().isEmpty()) {
            Map<String, List<String>> attrs = new HashMap<>();
            attrs.putAll(model.getAttributes());
            rep.setAttributes(attrs);
        }

        if(model.getRequiredActions() != null) {
            rep.setRequiredActions(new HashSet<String>());
            rep.getRequiredActions().addAll(model.getRequiredActions());
        }

        if(model.getAttatchedDocuments() != null) {
            List<AttatchedDocumentRepresentation> attatchedDocuments = new ArrayList<>();
            for (AttatchedDocumentModel attatchedDocument: model.getAttatchedDocuments()) {
                attatchedDocuments.add(toRepresentation(attatchedDocument));
            }
            rep.setAttatchedDocuments(attatchedDocuments);
        }

        return rep;
    }

    public static DebitNoteRepresentation toRepresentation(DebitNoteModel model) {
        DebitNoteRepresentation rep = new DebitNoteRepresentation();

        rep.setId(model.getId());
        rep.setDocumentId(model.getDocumentId());
        rep.setIssueDateTime(model.getIssueDateTime());
        rep.setDocumentCurrencyCode(model.getDocumentCurrencyCode());

        rep.setCustomerRegistrationName(model.getCustomerRegistrationName());
        rep.setCustomerAssignedAccountId(model.getCustomerAssignedAccountId());
        rep.setCustomerElectronicMail(model.getCustomerElectronicMail());

        rep.setAllowanceTotalAmount(model.getAllowanceTotalAmount());
        rep.setChargeTotalAmount(model.getChargeTotalAmount());
        rep.setPayableAmount(model.getPayableAmount());

        if (model.getAttributes() != null && !model.getAttributes().isEmpty()) {
            Map<String, List<String>> attrs = new HashMap<>();
            attrs.putAll(model.getAttributes());
            rep.setAttributes(attrs);
        }

        if(model.getRequiredActions() != null) {
            rep.setRequiredActions(new HashSet<String>());
            rep.getRequiredActions().addAll(model.getRequiredActions());
        }

        if(model.getAttatchedDocuments() != null) {
            List<AttatchedDocumentRepresentation> attatchedDocuments = new ArrayList<>();
            for (AttatchedDocumentModel attatchedDocument: model.getAttatchedDocuments()) {
                attatchedDocuments.add(toRepresentation(attatchedDocument));
            }
            rep.setAttatchedDocuments(attatchedDocuments);
        }

        return rep;
    }

    public static AttatchedDocumentRepresentation toRepresentation(AttatchedDocumentModel model) {
        AttatchedDocumentRepresentation rep = new AttatchedDocumentRepresentation();
        rep.setId(model.getId());
        rep.setDocumentId(model.getDocumentId());
        rep.setDocumentType(model.getDocumentType().toString());

        if (model.getAttributes() != null && !model.getAttributes().isEmpty()) {
            Map<String, List<String>> attrs = new HashMap<>();
            attrs.putAll(model.getAttributes());
            rep.setAttributes(attrs);
        }
        return rep;
    }

    public static MonetaryTotalRepresentation toRepresentation(MonetaryTotalModel model) {
        MonetaryTotalRepresentation rep = new MonetaryTotalRepresentation();
        rep.setChargeTotalAmount(model.getChargeTotalAmount());
        rep.setPayableAmount(model.getPayableAmount());
        rep.setAllowanceTotalAmount(model.getAllowanceTotalAmount());
        return rep;
    }

    public static AllowanceChargeRepresentation toRepresentation(AllowanceChargeModel model) {
        AllowanceChargeRepresentation rep = new AllowanceChargeRepresentation();
        rep.setAmount(model.getAmount());
        return rep;
    }

    public static TaxTotalRepresentation toRepresentation(TaxTotalModel model) {
        TaxTotalRepresentation rep = new TaxTotalRepresentation();
        rep.setTaxAmount(model.getTaxAmount());
        return rep;
    }

    private static ResponseRepresentation toRepresentation(ResponseModel model) {
        ResponseRepresentation rep = new ResponseRepresentation();
        rep.setReferenceId(model.getReferenceID());
        rep.setResponseCode(model.getResponseCode());
        if (model.getDescription() != null) {
            for (String item : model.getDescription()) {
                if(rep.getDescriptions() == null) {
                    rep.setDescriptions(new ArrayList<>());
                }
                rep.getDescriptions().add(item);
            }
        }
        return rep;
    }

    public static CustomerPartyRepresentation toRepresentation(CustomerPartyModel model) {
        CustomerPartyRepresentation rep = new CustomerPartyRepresentation();
        rep.setCustomerAssignedAccountId(model.getCustomerAssignedAccountID());
        for (String item : model.getAdditionalAccountID()) {
            if(rep.getAdditionalAccountId() == null) {
                rep.setAdditionalAccountId(new ArrayList<>());
            }
            rep.getAdditionalAccountId().add(item);
        }
        if (model.getParty() != null) {
            rep.setParty(toRepresentation(model.getParty()));
        }
        return rep;
    }

    public static SupplierPartyRepresentation toRepresentation(SupplierPartyModel model) {
        SupplierPartyRepresentation rep = new SupplierPartyRepresentation();
        if (model.getParty() != null) {
            rep.setParty(toRepresentation(model.getParty()));
        }
        rep.setCustomerAssignedAccountId(model.getCustomerAssignedAccountID());
        for (String item : model.getAdditionalAccountID()) {
            if(rep.getAdditionalAccountId() == null) {
                rep.setAdditionalAccountId(new ArrayList<>());
            }
            rep.getAdditionalAccountId().add(item);
        }
        return rep;
    }

    public static PartyRepresentation toRepresentation(PartyModel model) {
        PartyRepresentation rep = new PartyRepresentation();
        for (PartyLegalEntityModel item : model.getPartyLegalEntity()) {
            if(rep.getPartyLegalEntity() == null) {
                rep.setPartyLegalEntity(new ArrayList<>());
            }
            rep.getPartyLegalEntity().add(toRepresentation(item));
        }
        return rep;
    }

    public static PartyLegalEntityRepresentation toRepresentation(PartyLegalEntityModel model) {
        PartyLegalEntityRepresentation rep = new PartyLegalEntityRepresentation();
        rep.setRegistrationName(model.getRegistrationName());
        rep.setCompanyId(model.getCompanyID());
        return rep;
    }

    public static OrganizationEventsConfigRepresentation toEventsConfigReprensetation(
            OrganizationModel organization) {

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

    public static EventRepresentation toRepresentation(Event event) {
        EventRepresentation rep = new EventRepresentation();
        rep.setTime(event.getTime());
        rep.setType(event.getType().toString());
        rep.setOrganizationId(event.getOrganizationId());
        rep.setUserId(event.getUserId());
        rep.setIpAddress(event.getIpAddress());
        rep.setError(event.getError());
        rep.setDetails(event.getDetails());
        return rep;
    }

    public static AdminEventRepresentation toRepresentation(AdminEvent adminEvent) {
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

    public static AuthDetailsRepresentation toRepresentation(AuthDetails authDetails) {
        AuthDetailsRepresentation rep = new AuthDetailsRepresentation();
        rep.setOrganizationId(authDetails.getOrganizationId());
        rep.setUserId(authDetails.getUserId());
        rep.setIpAddress(authDetails.getIpAddress());
        return rep;
    }

    public static List<ConfigPropertyRepresentation> toRepresentation(
            List<ProviderConfigProperty> configProperties) {
        List<ConfigPropertyRepresentation> propertiesRep = new LinkedList<>();
        for (ProviderConfigProperty prop : configProperties) {
            ConfigPropertyRepresentation propRep = toRepresentation(prop);
            propertiesRep.add(propRep);
        }
        return propertiesRep;
    }

    public static ConfigPropertyRepresentation toRepresentation(ProviderConfigProperty prop) {
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

    public static ComponentRepresentation toRepresentation(OpenfactSession session, ComponentModel component,
            boolean internal) {
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
            Map<String, ProviderConfigProperty> configProperties = ComponentUtil
                    .getComponentConfigProperties(session, component);
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

    public static SendEventRepresentation toRepresentation(SendEventModel model) {
        SendEventRepresentation rep = new SendEventRepresentation();
        rep.setId(model.getId());
        rep.setDestinyType(model.getDestityType().toString());
        rep.setResult(model.getResult().toString());
        rep.setDescription(model.getDescription());
        rep.setType(model.getType());
        rep.setCreatedTimestamp(model.getCreatedTimestamp());

        if (model.getDestinyAttributes() != null && !model.getDestinyAttributes().isEmpty()) {
            Map<String, List<String>> attrs = new HashMap<>();
            attrs.putAll(model.getDestinyAttributes());
            rep.setDestinyAttributes(attrs);
        }
        if (model.getResponseAttributes() != null && !model.getResponseAttributes().isEmpty()) {
            Map<String, List<String>> attrs = new HashMap<>();
            attrs.putAll(model.getResponseAttributes());
            rep.setResponseAttributes(attrs);
        }

        if(model.getFileAttatchments() != null && !model.getFileAttatchments().isEmpty()) {
            rep.setFileAttachments(new ArrayList<>());
            List<FileRepresentation> filesRep = model.getFileAttatchments().stream().map(f -> {
                FileRepresentation fileRep = new FileRepresentation();
                fileRep.setId(f.getId());
                fileRep.setFileName(f.getFileName());
                return fileRep;
            }).collect(Collectors.toList());
            rep.getFileAttachments().addAll(filesRep);
        }
        if(model.getResponseFileAttatchments()!= null && !model.getResponseFileAttatchments().isEmpty()) {
            rep.setResponseFileAttachments(new ArrayList<>());
            List<FileRepresentation> filesRep = model.getResponseFileAttatchments().stream().map(f -> {
                FileRepresentation fileRep = new FileRepresentation();
                fileRep.setId(f.getId());
                fileRep.setFileName(f.getFileName());
                return fileRep;
            }).collect(Collectors.toList());
            rep.getResponseFileAttachments().addAll(filesRep);
        }
        return rep;
    }

    public static JobReportRepresentation toRepresentation(AdminJobReport model) {
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
