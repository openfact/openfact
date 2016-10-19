package org.openfact.models.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.catalog.CodeCatalogModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.BinaryObjectModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ExtensionContentModel;
import org.openfact.models.ubl.common.ExternalReferenceModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.ItemIdentificationModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.PartyLegalModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ResponseModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSchemeModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;
import org.openfact.representations.idm.catalog.CodeCatalogRepresentation;
import org.openfact.representations.idm.search.PagingRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterOperatorRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterRepresentation.FilterValueType;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.representations.idm.ubl.common.AddressRepresentation;
import org.openfact.representations.idm.ubl.common.AllowanceChargeRepresentation;
import org.openfact.representations.idm.ubl.common.AttachmentRepresentation;
import org.openfact.representations.idm.ubl.common.BillingReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.BinaryObjectRepresentation;
import org.openfact.representations.idm.ubl.common.CountryRepresentation;
import org.openfact.representations.idm.ubl.common.CreditNoteLineRepresentation;
import org.openfact.representations.idm.ubl.common.CustomerPartyRepresentation;
import org.openfact.representations.idm.ubl.common.DebitNoteLineRepresentation;
import org.openfact.representations.idm.ubl.common.DocumentReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.ExtensionContentRepresentation;
import org.openfact.representations.idm.ubl.common.ExternalReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.InvoiceLineRepresentation;
import org.openfact.representations.idm.ubl.common.ItemIdentificationRepresentation;
import org.openfact.representations.idm.ubl.common.ItemRepresentation;
import org.openfact.representations.idm.ubl.common.MonetaryTotalRepresentation;
import org.openfact.representations.idm.ubl.common.PartyLegalEntityRepresentation;
import org.openfact.representations.idm.ubl.common.PartyRepresentation;
import org.openfact.representations.idm.ubl.common.PriceRepresentation;
import org.openfact.representations.idm.ubl.common.PricingReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.QuantityRepresentation;
import org.openfact.representations.idm.ubl.common.ResponseRepresentation;
import org.openfact.representations.idm.ubl.common.SignatureRepresentation;
import org.openfact.representations.idm.ubl.common.SupplierPartyRepresentation;
import org.openfact.representations.idm.ubl.common.TaxCategoryRepresentation;
import org.openfact.representations.idm.ubl.common.TaxSchemeRepresentation;
import org.openfact.representations.idm.ubl.common.TaxSubtotalRepresentation;
import org.openfact.representations.idm.ubl.common.TaxTotalRepresentation;
import org.openfact.representations.idm.ubl.common.UBLExtensionRepresentation;
import org.openfact.representations.idm.ubl.common.UBLExtensionsRepresentation;
import org.openfact.ubl.UblIDGeneratorProvider;

public class RepresentationToModel {

    public static SearchCriteriaModel toModel(SearchCriteriaRepresentation rep) {
        SearchCriteriaModel model = new SearchCriteriaModel();

        // filters
        Function<SearchCriteriaFilterOperatorRepresentation, SearchCriteriaFilterOperator> operatorFunction = f -> {
            return SearchCriteriaFilterOperator.valueOf(f.toString());
        };

        BiFunction<Object, FilterValueType, Object> valueFunction = (value, type) -> {
            Object result = null;
            switch (type) {
            case LONG:
                result = (long) value;
                break;
            case STRING:
                result = (String) value;
                break;
            case DATE:
                result = LocalDateTime.parse((String) value, DateTimeFormatter.ISO_DATE);
                break;
            case DATETIME:
                result = LocalDateTime.parse((String) value, DateTimeFormatter.ISO_DATE_TIME);
                break;
            default:
                result = value;
                break;
            }
            return result;
        };

        rep.getFilters().forEach(f -> {
            model.addFilter(f.getName(), valueFunction.apply(f.getValue(), f.getType()),
                    operatorFunction.apply(f.getOperator()));
        });

        // sorter
        rep.getOrders().forEach(f -> model.addOrder(f.getName(), f.isAscending()));

        // paging
        PagingRepresentation paging = rep.getPaging();
        model.setPageSize(paging.getPageSize());
        model.setPage(paging.getPage());

        return model;
    }

    public static void importOrganization(OpenfactSession session, OrganizationRepresentation rep,
            OrganizationModel newOrganization) {

        newOrganization.setName(rep.getOrganization());

        /**
         * General information
         */
        if (rep.getDescription() != null) {
            newOrganization.setDescription(rep.getDescription());
        }
        if (rep.getEnabled() != null) {
            newOrganization.setEnabled(rep.getEnabled());
        }

        if (rep.getAssignedIdentificationId() != null) {
            newOrganization.setAssignedIdentificationId(rep.getAssignedIdentificationId());
        }
        if (rep.getAdditionalAccountId() != null) {
            newOrganization.setAdditionalAccountId(rep.getAdditionalAccountId());
        }
        if (rep.getSupplierName() != null) {
            newOrganization.setSupplierName(rep.getSupplierName());
        }
        if (rep.getRegistrationName() != null) {
            newOrganization.setRegistrationName(rep.getRegistrationName());
        }

        /**
         * Postal address
         */
        if (rep.getPostalAddress() != null) {
            PostalAddressRepresentation postalAddressRep = rep.getPostalAddress();
            if (postalAddressRep.getCountryIdentificationCode() != null) {
                newOrganization.setCountryIdentificationCode(postalAddressRep.getCountryIdentificationCode());
            }
            if (postalAddressRep.getCountrySubentity() != null) {
                newOrganization.setCountrySubentity(postalAddressRep.getCountrySubentity());
            }
            if (postalAddressRep.getCityName() != null) {
                newOrganization.setCityName(postalAddressRep.getCityName());
            }
            if (postalAddressRep.getCitySubdivisionName() != null) {
                newOrganization.setCitySubdivisionName(postalAddressRep.getCitySubdivisionName());
            }
            if (postalAddressRep.getDistrict() != null) {
                newOrganization.setDistrict(postalAddressRep.getDistrict());
            }
            if (postalAddressRep.getStreetName() != null) {
                newOrganization.setStreetName(postalAddressRep.getStreetName());
            }
        }

        /**
         * Themes
         */
        if (rep.getEmailTheme() != null) {
            newOrganization.setEmailTheme(rep.getEmailTheme());
        }

        /**
         * Internationalization
         */
        if (rep.getInternationalizationEnabled() != null) {
            newOrganization.setInternationalizationEnabled(rep.getInternationalizationEnabled());
        }
        if (rep.getSupportedLocales() != null) {
            newOrganization.setSupportedLocales(new HashSet<String>(rep.getSupportedLocales()));
        }
        if (rep.getDefaultLocale() != null) {
            newOrganization.setDefaultLocale(rep.getDefaultLocale());
        }

        /**
         * Internationalization ubl
         */
        if (rep.getInternationalizationUblEnabled() != null) {
            newOrganization.setInternationalizationUblEnabled(rep.getInternationalizationUblEnabled());
        }
        if (rep.getSupportedUblLocales() != null) {
            newOrganization.setSupportedUblLocales(new HashSet<String>(rep.getSupportedUblLocales()));
        }
        if (rep.getDefaultUblLocale() != null) {
            newOrganization.setDefaultUblLocale(rep.getDefaultUblLocale());
        }

        /**
         * Tasks schedule
         */
        if (rep.getTaskFirstTime() != null) {
            newOrganization.setTaskFirstTime(rep.getTaskFirstTime());
        }
        if (rep.getTaskDelay() != null) {
            newOrganization.setTaskDelay(rep.getTaskDelay());
        }
        if (rep.isTasksEnabled() != null) {
            newOrganization.setTaskEnabled(rep.isTasksEnabled());
        } else {
            newOrganization.setTaskEnabled(false);
        }

        /**
         * Currencies
         */
        if (rep.getDefaultCurrency() != null) {
            newOrganization.setDefaultCurrency(rep.getDefaultCurrency());
        }
        if (rep.getSupportedCurrencies() != null) {
            newOrganization.setSupportedCurrencies(new HashSet<String>(rep.getSupportedCurrencies()));
        }

        /**
         * Events
         */
        if (rep.getEventsEnabled() != null) {
            newOrganization.setEventsEnabled(rep.getEventsEnabled());
        }
        if (rep.getEventsExpiration() != null) {
            newOrganization.setEventsExpiration(rep.getEventsExpiration());
        }
        if (rep.getEventsListeners() != null) {
            newOrganization.setEventsListeners(new HashSet<>(rep.getEventsListeners()));
        }
        if (rep.getAdminEventsEnabled() != null) {
            newOrganization.setAdminEventsEnabled(rep.getAdminEventsEnabled());
        }
        if (rep.getAdminEventsDetailsEnabled() != null) {
            newOrganization.setAdminEventsDetailsEnabled(rep.getAdminEventsDetailsEnabled());
        }

        /**
         * Smtp server
         */
        if (rep.getSmtpServer() != null) {
            newOrganization.setSmtpConfig(new HashMap<String, String>(rep.getSmtpServer()));
        }

        /**
         * Ubl server
         */
        if (rep.getUblSenderServer() != null) {
            newOrganization.setUblSenderConfig(new HashMap<String, String>(rep.getUblSenderServer()));
        }

        /**
         * Certificate
         */
        if (rep.getPrivateKey() == null || rep.getPublicKey() == null) {
            OpenfactModelUtils.generateOrganizationKeys(newOrganization);
        } else {
            newOrganization.setPrivateKeyPem(rep.getPrivateKey());
            newOrganization.setPublicKeyPem(rep.getPublicKey());
        }
        if (rep.getCertificate() == null) {
            OpenfactModelUtils.generateOrganizationCertificate(newOrganization);
        } else {
            newOrganization.setCertificatePem(rep.getCertificate());
        }
        if (rep.getCodeSecret() == null) {
            newOrganization.setCodeSecret(OpenfactModelUtils.generateCodeSecret());
        } else {
            newOrganization.setCodeSecret(rep.getCodeSecret());
        }

        /**
         * Attributes
         */
        if (rep.getAttributes() != null) {
            for (Map.Entry<String, String> attr : rep.getAttributes().entrySet()) {
                newOrganization.setAttribute(attr.getKey(), attr.getValue());
            }
        }

        /**
         * Required actions
         */

        // create invoices and their lines
        if (rep.getInvoices() != null) {
            for (InvoiceRepresentation invoiceRep : rep.getInvoices()) {
                InvoiceModel invoice = createInvoice(session, newOrganization, invoiceRep);
            }
        }

        // create debit notes and their lines
        if (rep.getDebitNotes() != null) {
            for (DebitNoteRepresentation debitNoteRep : rep.getDebitNotes()) {
                DebitNoteModel debitNote = createDebitNote(session, newOrganization, debitNoteRep);
            }
        }

        // create debit notes and their lines
        if (rep.getCreditNotes() != null) {
            for (CreditNoteRepresentation creditNoteRep : rep.getCreditNotes()) {
                CreditNoteModel creditNote = createCreditNote(session, newOrganization, creditNoteRep);
            }
        }
    }

    public static void updateOrganization(OrganizationRepresentation rep, OrganizationModel organization,
            OpenfactSession session) {
        if (rep.getOrganization() != null) {
            renameOrganization(organization, rep.getOrganization());
        }

        // Import attributes first, so the stuff saved directly on
        // representation (displayName, bruteForce etc) has bigger priority
        if (rep.getAttributes() != null) {
            Set<String> attrsToRemove = new HashSet<>(organization.getAttributes().keySet());
            attrsToRemove.removeAll(rep.getAttributes().keySet());

            for (Map.Entry<String, String> entry : rep.getAttributes().entrySet()) {
                organization.setAttribute(entry.getKey(), entry.getValue());
            }

            for (String attr : attrsToRemove) {
                organization.removeAttribute(attr);
            }
        }

        /**
         * General information
         */
        if (rep.getDescription() != null) {
            organization.setDescription(rep.getDescription());
        }
        if (rep.getEnabled() != null) {
            organization.setEnabled(rep.getEnabled());
        }

        if (rep.getAssignedIdentificationId() != null) {
            organization.setAssignedIdentificationId(rep.getAssignedIdentificationId());
        }
        if (rep.getAdditionalAccountId() != null) {
            organization.setAdditionalAccountId(rep.getAdditionalAccountId());
        }
        if (rep.getSupplierName() != null) {
            organization.setSupplierName(rep.getSupplierName());
        }
        if (rep.getRegistrationName() != null) {
            organization.setRegistrationName(rep.getRegistrationName());
        }

        /**
         * Postal address
         */
        if (rep.getPostalAddress() != null) {
            PostalAddressRepresentation postalAddressRep = rep.getPostalAddress();
            if (postalAddressRep.getCountryIdentificationCode() != null) {
                organization.setCountryIdentificationCode(postalAddressRep.getCountryIdentificationCode());
            }
            if (postalAddressRep.getCountrySubentity() != null) {
                organization.setCountrySubentity(postalAddressRep.getCountrySubentity());
            }
            if (postalAddressRep.getCityName() != null) {
                organization.setCityName(postalAddressRep.getCityName());
            }
            if (postalAddressRep.getCitySubdivisionName() != null) {
                organization.setCitySubdivisionName(postalAddressRep.getCitySubdivisionName());
            }
            if (postalAddressRep.getDistrict() != null) {
                organization.setDistrict(postalAddressRep.getDistrict());
            }
            if (postalAddressRep.getStreetName() != null) {
                organization.setStreetName(postalAddressRep.getStreetName());
            }
        }

        /**
         * Themes
         */
        if (rep.getEmailTheme() != null) {
            organization.setEmailTheme(rep.getEmailTheme());
        }

        /**
         * Internationalization
         */
        if (rep.getInternationalizationEnabled() != null) {
            organization.setInternationalizationEnabled(rep.getInternationalizationEnabled());
        }
        if (rep.getSupportedLocales() != null) {
            organization.setSupportedLocales(new HashSet<String>(rep.getSupportedLocales()));
        }
        if (rep.getDefaultLocale() != null) {
            organization.setDefaultLocale(rep.getDefaultLocale());
        }

        /**
         * Internationalization ubl
         */
        if (rep.getInternationalizationUblEnabled() != null) {
            organization.setInternationalizationUblEnabled(rep.getInternationalizationUblEnabled());
        }
        if (rep.getSupportedUblLocales() != null) {
            organization.setSupportedUblLocales(new HashSet<String>(rep.getSupportedUblLocales()));
        }
        if (rep.getDefaultUblLocale() != null) {
            organization.setDefaultUblLocale(rep.getDefaultUblLocale());
        }

        /**
         * Tasks schedule
         */
        if (rep.getTaskFirstTime() != null) {
            organization.setTaskFirstTime(rep.getTaskFirstTime());
        }
        if (rep.getTaskDelay() != null) {
            organization.setTaskDelay(rep.getTaskDelay());
        }

        /**
         * Currencies
         */
        if (rep.getDefaultCurrency() != null) {
            organization.setDefaultCurrency(rep.getDefaultCurrency());
        }
        if (rep.getSupportedCurrencies() != null) {
            organization
                    .setSupportedCurrencies(new HashSet<String>(new HashSet<>(rep.getSupportedCurrencies())));
        }

        /**
         * Events
         */
        if (rep.getEventsEnabled() != null) {
            organization.setEventsEnabled(rep.getEventsEnabled());
        }
        if (rep.getEventsExpiration() != null) {
            organization.setEventsExpiration(rep.getEventsExpiration());
        }
        if (rep.getEventsListeners() != null) {
            organization.setEventsListeners(new HashSet<>(rep.getEventsListeners()));
        }
        if (rep.getEnabledEventTypes() != null) {
            organization.setEnabledEventTypes(new HashSet<>(rep.getEnabledEventTypes()));
        }

        if (rep.getAdminEventsEnabled() != null) {
            organization.setAdminEventsEnabled(rep.getAdminEventsEnabled());
        }
        if (rep.getAdminEventsDetailsEnabled() != null) {
            organization.setAdminEventsDetailsEnabled(rep.getAdminEventsDetailsEnabled());
        }

        /**
         * Smtp Server
         **/
        if (rep.getSmtpServer() != null) {
            organization.setSmtpConfig(new HashMap(rep.getSmtpServer()));
        }

        /**
         * Ubl Server
         **/
        if (rep.getSmtpServer() != null) {
            organization.setUblSenderConfig(new HashMap(rep.getUblSenderServer()));
        }
    }

    public static void renameOrganization(OrganizationModel organization, String name) {
        if (name.equals(organization.getName())) {
            return;
        }

        String oldName = organization.getName();
        organization.setName(name);
    }

    public static void importCodeCatalog(OpenfactSession session, CodeCatalogRepresentation rep,
            CodeCatalogModel codeCatalog) {
        codeCatalog.setCode(rep.getCode());
        codeCatalog.setDescription(rep.getDescription());
        codeCatalog.setLocale(rep.getLocale());
        codeCatalog.setType(rep.getType());
        codeCatalog.setAttributes(rep.getAttributes());
    }

    public static void updateCodeCatalog(CodeCatalogRepresentation rep, CodeCatalogModel codeCatalog) {
        if (rep.getCode() != null) {
            codeCatalog.setCode(codeCatalog.getCode());
        }
        if (rep.getDescription() != null) {
            codeCatalog.setDescription(codeCatalog.getDescription());
        }
        if (rep.getLocale() != null) {
            codeCatalog.setLocale(codeCatalog.getLocale());
        }
        if (rep.getType() != null) {
            codeCatalog.setType(codeCatalog.getType());
        }
        if (rep.getAttributes() != null) {
            codeCatalog.setAttributes(codeCatalog.getAttributes());
        }
    }

    public static InvoiceModel createInvoice(OpenfactSession session, OrganizationModel organization,
            InvoiceRepresentation rep) {
        String idUbl = rep.getIdUbl();
        if (idUbl == null) {
            idUbl = session.getProvider(UblIDGeneratorProvider.class, organization.getDefaultUblLocale())
                    .generateInvoiceID(organization, rep.getInvoiceTypeCode());
        }

        InvoiceModel model = session.invoices().addInvoice(organization, idUbl);
        return importInvoice(session, organization, model, rep);
    }

    public static InvoiceModel importInvoice(OpenfactSession session, OrganizationModel organization,
            InvoiceModel model, InvoiceRepresentation rep) {
        if (rep.getUblVersionID() != null) {
            model.setUBLVersionID(rep.getUblVersionID());
        }
        if (rep.getCustomizationID() != null) {
            model.setCustomizationID(rep.getCustomizationID());
        }
        if (rep.getSignature() != null) {
            for (SignatureRepresentation item : rep.getSignature()) {
                updateModel(model.addSignature(), item);
            }
        }

        if (rep.getIssueDateTime() != null) {
            model.setIssueDateTime(rep.getIssueDateTime());
        }
        if (rep.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierParty(), rep.getAccountingSupplierParty());
        }
        if (rep.getInvoiceTypeCode() != null) {
            model.setInvoiceTypeCode(rep.getInvoiceTypeCode());
        }
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getAccountingCustomerParty() != null) {
            updateModel(model.getAccountingCustomerParty(), rep.getAccountingCustomerParty());
        }
        if (rep.getInvoiceLine() != null) {
            for (InvoiceLineRepresentation item : rep.getInvoiceLine()) {
                updateModel(model.addInvoiceLine(), item);
            }
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (rep.getLegalMonetaryTotal() != null) {
            updateModel(model.getLegalMonetaryTotal(), rep.getLegalMonetaryTotal());
        }
        model.setDocumentCurrencyCode(rep.getDocumentCurrencyCode());

        if (rep.getUblExtensions() != null) {
            updateModel(model.getUBLExtensions(), rep.getUblExtensions());
        }

        return model;
    }

    public static CreditNoteModel createCreditNote(OpenfactSession session, OrganizationModel organization,
            CreditNoteRepresentation rep) {
        String idUbl = rep.getIdUbl();
        if (idUbl == null) {
            List<String> referenceIDs = rep.getDiscrepancyResponse().stream().map(f -> f.getReferenceID())
                    .collect(Collectors.toList());
            idUbl = session.getProvider(UblIDGeneratorProvider.class, organization.getDefaultUblLocale())
                    .generateCreditNoteID(organization,
                            referenceIDs.toArray(new String[referenceIDs.size()]));
        }

        CreditNoteModel model = session.creditNotes().addCreditNote(organization, idUbl);
        return importCreditNote(session, organization, model, rep);
    }

    public static CreditNoteModel importCreditNote(OpenfactSession session, OrganizationModel organization,
            CreditNoteModel model, CreditNoteRepresentation rep) {
        if (rep.getUblVersionID() != null) {
            model.setUBLVersionID(rep.getUblVersionID());
        }
        if (rep.getCustomizationID() != null) {
            model.setCustomizationID(rep.getCustomizationID());
        }
        if (rep.getSignature() != null) {
            for (SignatureRepresentation item : rep.getSignature()) {
                updateModel(model.addSignature(), item);
            }
        }

        if (rep.getIssueDateTime() != null) {
            model.setIssueDateTime(rep.getIssueDateTime());
        }
        if (rep.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierParty(), rep.getAccountingSupplierParty());
        }
        if (rep.getDiscrepancyResponse() != null) {
            for (ResponseRepresentation item : rep.getDiscrepancyResponse()) {
                updateModel(model.addDiscrepancyResponse(), item);
            }
        }
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getCreditNoteLine() != null) {
            for (CreditNoteLineRepresentation item : rep.getCreditNoteLine()) {
                updateModel(model.addCreditNoteLine(), item);
            }
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }

        if (rep.getLegalMonetaryTotal() != null) {
            updateModel(model.getLegalMonetaryTotal(), rep.getLegalMonetaryTotal());
        }

        if (rep.getDocumentCurrencyCode() != null) {
            model.setDocumentCurrencyCode(rep.getDocumentCurrencyCode());
        }
        if (rep.getDespatchDocumentReference() != null) {
            for (DocumentReferenceRepresentation item : rep.getDespatchDocumentReference()) {
                updateModel(model.addDespatchDocumentReference(), item);
            }
        }
        return model;
    }

    public static DebitNoteModel createDebitNote(OpenfactSession session, OrganizationModel organization,
            DebitNoteRepresentation rep) {
        String idUbl = rep.getIdUbl();
        if (idUbl == null) {
            List<String> referenceIDs = rep.getDiscrepancyResponse().stream().map(f -> f.getReferenceID())
                    .collect(Collectors.toList());
            idUbl = session.getProvider(UblIDGeneratorProvider.class, organization.getDefaultUblLocale())
                    .generateDebitNoteID(organization, referenceIDs.toArray(new String[referenceIDs.size()]));
        }

        DebitNoteModel model = session.debitNotes().addDebitNote(organization, idUbl);
        return importDebitNote(session, organization, model, rep);
    }

    public static DebitNoteModel importDebitNote(OpenfactSession session, OrganizationModel organization,
            DebitNoteModel model, DebitNoteRepresentation rep) {
        if (rep.getUblVersionID() != null) {
            model.setUBLVersionID(rep.getUblVersionID());
        }
        if (rep.getCustomizationID() != null) {
            model.setCustomizationID(rep.getCustomizationID());
        }
        if (rep.getSignature() != null) {
            for (SignatureRepresentation item : rep.getSignature()) {
                updateModel(model.addSignature(), item);
            }
        }

        if (rep.getIssueDateTime() != null) {
            model.setIssueDateTime(rep.getIssueDateTime());
        }
        if (rep.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierParty(), rep.getAccountingSupplierParty());
        }
        if (rep.getDiscrepancyResponse() != null) {
            for (ResponseRepresentation item : rep.getDiscrepancyResponse()) {
                updateModel(model.addDiscrepancyResponse(), item);
            }
        }
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getAccountingCustomerParty() != null) {
            updateModel(model.getAccountingCustomerParty(), rep.getAccountingCustomerParty());
        }
        if (rep.getDebitNoteLine() != null) {
            for (DebitNoteLineRepresentation item : rep.getDebitNoteLine()) {
                updateModel(model.addDebitNoteLine(), item);
            }
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (rep.getRequestedMonetaryTotal() != null) {
            updateModel(model.getRequestedMonetaryTotal(), rep.getRequestedMonetaryTotal());
        }
        if (rep.getDocumentCurrencyCode() != null) {
            model.setDocumentCurrencyCode(rep.getDocumentCurrencyCode());
        }
        if (rep.getBillingReference() != null) {
            for (BillingReferenceRepresentation item : rep.getBillingReference()) {
                updateModel(model.addBillingReference(), item);
            }
        }
        if (rep.getDespatchDocumentReference() != null) {
            for (DocumentReferenceRepresentation item : rep.getDespatchDocumentReference()) {
                updateModel(model.addDespatchDocumentReference(), item);
            }
        }
        return model;
    }

    public static void updateModel(UBLExtensionsModel model, UBLExtensionsRepresentation rep) {
        if (rep.getUblExtension() != null) {
            for (UBLExtensionRepresentation item : rep.getUblExtension()) {
                updateModel(model.addUblExtension(), item);
            }
        }
    }

    public static void updateModel(UBLExtensionModel model, UBLExtensionRepresentation rep) {
        if (rep.getExtensionAgencyID() != null) {
            model.setExtensionAgencyID(rep.getExtensionAgencyID());
        }
        if (rep.getExtensionAgencyName() != null) {
            model.setExtensionAgencyName(rep.getExtensionAgencyName());
        }
        if (rep.getExtensionAgencyURI() != null) {
            model.setExtensionAgencyURI(rep.getExtensionAgencyURI());
        }
        if (rep.getExtensionReason() != null) {
            model.setExtensionReason(rep.getExtensionReason());
        }
        if (rep.getExtensionReasonCode() != null) {
            model.setExtensionReasonCode(rep.getExtensionReasonCode());
        }
        if (rep.getExtensionURI() != null) {
            model.setExtensionURI(rep.getExtensionURI());
        }
        if (rep.getExtensionVersionID() != null) {
            model.setExtensionVersionID(rep.getExtensionVersionID());
        }
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getName() != null) {
            model.setName(rep.getName());
        }
        if (rep.getExtensionContent() != null) {
            updateModel(model.getExtensionContent(), rep.getExtensionContent());
        }
    }

    public static void updateModel(ExtensionContentModel model, ExtensionContentRepresentation rep) {
        if (rep.getAnyItem() != null) {
            model.setAnyItem(rep.getAnyItem());
        }
        if (rep.getAny() != null) {
            model.setAny(rep.getAny());
        }
    }

    public static void updateModel(InvoiceLineModel model, InvoiceLineRepresentation rep) {
        if (rep.getInvoicedQuantity() != null) {
            updateModel(model.getInvoicedQuantity(), rep.getInvoicedQuantity());
        }
        if (rep.getItem() != null) {
            updateModel(model.getItem(), rep.getItem());
        }
        if (rep.getPrice() != null) {
            updateModel(model.getPrice(), rep.getPrice());
        }
        if (rep.getPricingReference() != null) {
            updateModel(model.getPricingReference(), rep.getPricingReference());
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (rep.getLineExtensionAmount() != null) {
            model.setLineExtensionAmount(rep.getLineExtensionAmount());
        }
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getAllowanceCharge() != null) {
            for (AllowanceChargeRepresentation item : rep.getAllowanceCharge()) {
                updateModel(model.addAllowanceCharge(), item);
            }
        }
    }

    public static void updateModel(CreditNoteLineModel model, CreditNoteLineRepresentation rep) {
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getCreditedQuantity() != null) {
            updateModel(model.getCreditedQuantity(), rep.getCreditedQuantity());
        }
        if (rep.getItem() != null) {
            updateModel(model.getItem(), rep.getItem());
        }
        if (rep.getPrice() != null) {
            updateModel(model.getPrice(), rep.getPrice());
        }
        if (rep.getPricingReference() != null) {
            updateModel(model.getPricingReference(), rep.getPricingReference());
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (rep.getLineExtensionAmount() != null) {
            model.setLineExtensionAmount(rep.getLineExtensionAmount());
        }
    }

    public static void updateModel(DebitNoteLineModel model, DebitNoteLineRepresentation rep) {
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getDebitedQuantity() != null) {
            updateModel(model.getDebitedQuantity(), rep.getDebitedQuantity());
        }
        if (rep.getItem() != null) {
            updateModel(model.getItem(), rep.getItem());
        }
        if (rep.getPrice() != null) {
            updateModel(model.getPrice(), rep.getPrice());
        }
        if (rep.getPricingReference() != null) {
            updateModel(model.getPricingReference(), rep.getPricingReference());
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (rep.getLineExtensionAmount() != null) {
            model.setLineExtensionAmount(rep.getLineExtensionAmount());
        }
    }

    public static void updateModel(BillingReferenceModel model, BillingReferenceRepresentation rep) {
        if (rep.getInvoiceDocumentReference() != null) {
            updateModel(model.getInvoiceDocumentReference(), rep.getInvoiceDocumentReference());
        }
    }

    public static void updateModel(DocumentReferenceModel model, DocumentReferenceRepresentation rep) {
        if (rep.getDocumentCodeRepresentation() != null) {
            model.setDocumentCode(rep.getDocumentCodeRepresentation());
        }
    }

    public static void updateModel(ResponseModel model, ResponseRepresentation rep) {
        if (rep.getReferenceID() != null) {
            model.setReferenceID(rep.getReferenceID());
        }
        if (rep.getReferenceID() != null) {
            model.setReferenceID(rep.getReferenceID());
        }
        if (rep.getDescription() != null) {
            for (String item : rep.getDescription()) {
                model.getDescription().add(item);
            }
        }
    }

    public static void updateModel(MonetaryTotalModel model, MonetaryTotalRepresentation rep) {
        if (rep.getChargeTotalAmount() != null) {
            model.setChargeTotalAmount(rep.getChargeTotalAmount());
        }
        if (rep.getPayableAmount() != null) {
            model.setPayableAmount(rep.getPayableAmount());
        }
        if (rep.getAllowanceTotalAmount() != null) {
            model.setAllowanceTotalAmount(rep.getAllowanceTotalAmount());
        }
    }

    public static void updateModel(AllowanceChargeModel model, AllowanceChargeRepresentation rep) {
        if (rep.getAmount() != null) {
            model.setAmount(rep.getAmount());
        }
        if (rep.getChargeIndicator() != null) {
            model.setChargeIndicator(rep.getChargeIndicator());
        }
    }

    public static void updateModel(PricingReferenceModel model, PricingReferenceRepresentation rep) {
        if (rep.getAlternativeConditionPrice() != null) {
            for (PriceRepresentation item : rep.getAlternativeConditionPrice()) {
                updateModel(model.addAlternativeConditionPrice(), item);
            }
        }
    }

    public static void updateModel(PriceModel model, PriceRepresentation rep) {
        if (rep.getPriceAmount() != null) {
            model.setPriceAmount(rep.getPriceAmount());
        }
        if (rep.getPriceTypeCode() != null) {
            model.setPriceTypeCode(rep.getPriceTypeCode());
        }
    }

    public static void updateModel(ItemModel model, ItemRepresentation rep) {
        if (rep.getDescription() != null) {
            for (String item : rep.getDescription()) {
                model.getDescription().add(item);
            }
        }
        if (rep.getSellersItemIdentification() != null) {
            updateModel(model.getSellersItemIdentification(), rep.getSellersItemIdentification());
        }
    }

    public static void updateModel(ItemIdentificationModel model, ItemIdentificationRepresentation rep) {
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
    }

    public static void updateModel(TaxTotalModel model, TaxTotalRepresentation rep) {
        if (rep.getTaxAmount() != null) {
            model.setTaxAmount(rep.getTaxAmount());
        }
        if (rep.getTaxSubtotal() != null) {
            for (TaxSubtotalRepresentation item : rep.getTaxSubtotal()) {
                updateModel(model.addTaxSubtotal(), item);
            }
        }
    }

    public static void updateModel(TaxSubtotalModel model, TaxSubtotalRepresentation rep) {
        if (rep.getTaxAmount() != null) {
            model.setTaxAmount(rep.getTaxAmount());
        }
        if (rep.getTaxCategory() != null) {
            updateModel(model.getTaxCategory(), rep.getTaxCategory());
        }
    }

    public static void updateModel(TaxCategoryModel model, TaxCategoryRepresentation rep) {
        if (rep.getTaxExemptionReasonCode() != null) {
            model.setTaxExemptionReasonCode(rep.getTaxExemptionReasonCode());
        }
        if (rep.getTaxScheme() != null) {
            updateModel(model.getTaxScheme(), rep.getTaxScheme());
        }
        if (rep.getTierRange() != null) {
            model.setTierRange(rep.getTierRange());
        }
    }

    public static void updateModel(TaxSchemeModel model, TaxSchemeRepresentation rep) {
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getName() != null) {
            model.setName(rep.getName());
        }
        if (rep.getTaxCodeType() != null) {
            model.setTaxTypeCode(rep.getTaxCodeType());
        }
    }

    public static void updateModel(CustomerPartyModel model, CustomerPartyRepresentation rep) {
        if (rep.getCustomerAssignedAccountID() != null) {
            model.setCustomerAssignedAccountID(rep.getCustomerAssignedAccountID());
        }
        if (rep.getAdditionalAccountID() != null) {
            for (String item : rep.getAdditionalAccountID()) {
                model.getAdditionalAccountID().add(item);
            }
        }
        if (rep.getParty() != null) {
            updateModel(model.getParty(), rep.getParty());
        }
    }

    public static void updateModel(SupplierPartyModel model, SupplierPartyRepresentation rep) {
        if (rep.getParty() != null) {
            updateModel(model.getParty(), rep.getParty());
        }
        if (rep.getCustomerAssignedAccountID() != null) {
            model.setCustomerAssignedAccountID(rep.getCustomerAssignedAccountID());
        }
        if (rep.getAdditionalAccountID() != null) {
            for (String item : rep.getAdditionalAccountID()) {
                model.getAdditionalAccountID().add(item);
            }
        }
    }

    public static void updateModel(PartyModel model, PartyRepresentation rep) {
        if (rep.getPartyLegalEntity() != null) {
            for (PartyLegalEntityRepresentation item : rep.getPartyLegalEntity()) {
                updateModel(model.addPartyLegalEntity(), item);
            }
        }
        if (rep.getPartyIdentification() != null) {
            for (String item : rep.getPartyIdentification()) {
                model.getPartyIdentification().add(item);
            }
        }
        if (rep.getPartyName() != null) {
            for (String item : rep.getPartyName()) {
                model.getPartyName().add(item);
            }
        }
        if (rep.getPostalAddress() != null) {
            updateModel(model.getPostalAddress(), rep.getPostalAddress());
        }
    }

    public static void updateModel(PartyLegalModel model, PartyLegalEntityRepresentation rep) {
        if (rep.getRegistrationName() != null) {
            model.setRegistrationName(rep.getRegistrationName());
        }
    }

    public static void updateModel(AddressModel model, AddressRepresentation rep) {
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getStreetName() != null) {
            model.setStreetName(rep.getStreetName());
        }
        if (rep.getCitySubdivisionName() != null) {
            model.setCitySubdivisionName(rep.getCitySubdivisionName());
        }
        if (rep.getCityName() != null) {
            model.setCityName(rep.getCityName());
        }
        if (rep.getCountrySubentity() != null) {
            model.setCountrySubentity(rep.getCountrySubentity());
        }
        if (rep.getDistrict() != null) {
            model.setDistrict(rep.getDistrict());
        }
        if (rep.getDepartment() != null) {
            model.setDepartment(rep.getDepartment());
        }
        if (rep.getCountry() != null) {
            updateModel(model.getCountry(), rep.getCountry());
        }
    }

    public static void updateModel(CountryModel model, CountryRepresentation rep) {
        if (rep.getIdentificationCode() != null) {
            model.setIdentificationCode(rep.getIdentificationCode());
        }
    }

    public static void updateModel(QuantityModel model, QuantityRepresentation rep) {
        if (rep.getUnitCode() != null) {
            model.setUnitCode(rep.getUnitCode());
        }
        if (rep.getValue() != null) {
            model.setValue(rep.getValue());
        }
    }

    public static void updateModel(SignatureModel model, SignatureRepresentation rep) {
        if (rep.getCanonicalizationMethod() != null) {
            model.setCanonicalizationMethod(rep.getCanonicalizationMethod());
        }
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getNote() != null) {
            model.setNote(rep.getNote());
        }
        if (rep.getSignatureMethod() != null) {
            model.setSignatureMethod(rep.getSignatureMethod());
        }
        if (rep.getValidationDate() != null) {
            model.setValidationDate(rep.getValidationDate());
        }
        if (rep.getValidationTime() != null) {
            model.setValidationTime(rep.getValidationTime());
        }
        if (rep.getValidatorID() != null) {
            model.setValidatorID(rep.getValidatorID());
        }
        if (rep.getSignatoryParty() != null) {
            updateModel(model.getSignatoryParty(), rep.getSignatoryParty());
        }
        if (rep.getDigitalSignatureAttachment() != null) {
            updateModel(model.getDigitalSignatureAttachment(), rep.getDigitalSignatureAttachment());
        }
    }

    public static void updateModel(AttachmentModel model, AttachmentRepresentation rep) {
        if (rep.getExternalReference() != null) {
            updateModel(model.getExternalReference(), rep.getExternalReference());
        }
        if (rep.getEmbeddedDocumentBinaryObject() != null) {
            updateModel(model.getEmbeddedDocumentBinaryObject(), rep.getEmbeddedDocumentBinaryObject());
        }
    }

    public static void updateModel(ExternalReferenceModel model, ExternalReferenceRepresentation rep) {
        if (rep.getDocumentHash() != null) {
            model.setDocumentHash(rep.getDocumentHash());
        }
        if (rep.getExpiryDate() != null) {
            model.setExpiryDate(rep.getExpiryDate());
        }
        if (rep.getExpiryTime() != null) {
            model.setExpiryTime(rep.getExpiryTime());
        }
        if (rep.getUri() != null) {
            model.setURI(rep.getUri());
        }
    }

    public static void updateModel(BinaryObjectModel model, BinaryObjectRepresentation rep) {
        if (rep.getCharacterSetCode() != null) {
            model.setCharacterSetCode(rep.getCharacterSetCode());
        }
        if (rep.getEncodingCode() != null) {
            model.setEncodingCode(rep.getEncodingCode());
        }
        if (rep.getFilename() != null) {
            model.setFilename(rep.getFilename());
        }
        if (rep.getFormat() != null) {
            model.setFormat(rep.getFormat());
        }
        if (rep.getMimeCode() != null) {
            model.setMimeCode(rep.getMimeCode());
        }
        if (rep.getUri() != null) {
            model.setUri(rep.getUri());
        }
        if (rep.getValue() != null) {
            model.setValue(rep.getValue());
        }
    }

}