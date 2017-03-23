package org.openfact.models.utils;

import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.components.utils.ComponentUtil;
import org.openfact.keys.KeyProvider;
import org.openfact.models.ComponentProvider;
import org.openfact.models.ModelException;
import org.openfact.models.OrganizationModel;
import org.openfact.component.ComponentModel;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.representations.idm.ComponentExportRepresentation;
import org.openfact.representations.idm.ComponentRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;
import org.openfact.representations.idm.search.PagingRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterOperatorRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterRepresentation.FilterValueType;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

@Stateless
public class RepresentationToModel {

    @Inject
    private ComponentUtil componentUtil;

    @Inject
    private ComponentProvider componentProvider;

    @Inject
    private DefaultKeyProviders defaultKeyProviders;

    public SearchCriteriaModel toModel(SearchCriteriaRepresentation rep) {
        SearchCriteriaModel model = new SearchCriteriaModel();

        // filters
        Function<SearchCriteriaFilterOperatorRepresentation, SearchCriteriaFilterOperator> operatorFunction = f -> {
            return SearchCriteriaFilterOperator.valueOf(f.toString());
        };

        BiFunction<Object, FilterValueType, Object> valueFunction = (value, type) -> {
            if (type == null) return value;
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
        if (rep.getPaging() != null) {
            PagingRepresentation paging = rep.getPaging();
            model.setPageSize(paging.getPageSize());
            model.setPage(paging.getPage());
        }

        return model;
    }

    public void importOrganization(OrganizationRepresentation rep, OrganizationModel newOrganization) throws ModelException {
        newOrganization.setName(rep.getOrganization());

        generalUpdateOrganization(newOrganization, rep);

        /*
         * Postal address
         */
        if (rep.getPostalAddress() != null) {
            updatePostalAddress(newOrganization, rep);
        }

        /*
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

        if (rep.getComponents() != null) {
            MultivaluedHashMap<String, ComponentExportRepresentation> components = rep.getComponents();
            String parentId = newOrganization.getId();
            importComponents(newOrganization, components, parentId, componentProvider);
        }

        /*
         * Certificate
         */
        if (componentProvider.getComponents(newOrganization, newOrganization.getId(), KeyProvider.class.getName()).isEmpty()) {
            if (rep.getPrivateKey() != null) {
                defaultKeyProviders.createProviders(newOrganization, rep.getPrivateKey(), rep.getCertificate());
            } else {
                defaultKeyProviders.createProviders(newOrganization);
            }
        }

        /*
         * Attributes
         */
        if (rep.getAttributes() != null) {
            for (Map.Entry<String, String> attr : rep.getAttributes().entrySet()) {
                newOrganization.setAttribute(attr.getKey(), attr.getValue());
            }
        }
    }

    public void updateOrganization(OrganizationRepresentation rep, OrganizationModel organization) throws ModelException {
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

        generalUpdateOrganization(organization, rep);

        /*
         * Postal address
         */
        if (rep.getPostalAddress() != null) {
            updatePostalAddress(organization, rep);
        }

        /*
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
    }

    public void renameOrganization(OrganizationModel organization, String name) {
        if (name.equals(organization.getName())) {
            return;
        }

        organization.setName(name);
    }

    public void generalUpdateOrganization(OrganizationModel organization, OrganizationRepresentation rep) {
        /*
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

        /*
         * Themes
         */
        if (rep.getEmailTheme() != null) {
            organization.setEmailTheme(rep.getEmailTheme());
        }
        if (rep.getReportTheme() != null) {
            organization.setReportTheme(rep.getReportTheme());
        }

         /*
         * Internationalization
         */
        if (rep.getInternationalizationEnabled() != null) {
            organization.setInternationalizationEnabled(rep.getInternationalizationEnabled());
        }
        if (rep.getSupportedLocales() != null) {
            organization.setSupportedLocales(new HashSet<>(rep.getSupportedLocales()));
        }
        if (rep.getDefaultLocale() != null) {
            organization.setDefaultLocale(rep.getDefaultLocale());
        }

         /*
         * Tasks schedule
         */
        if (rep.isTasksEnabled() != null) {
            organization.setTaskEnabled(rep.isTasksEnabled());
        }
        if (rep.getTaskFirstTime() != null) {
            organization.setTaskFirstTime(rep.getTaskFirstTime());
        }
        if (rep.getTaskDelay() != null) {
            organization.setTaskDelay(rep.getTaskDelay());
        }

        /*
         * Currencies
         */
        if (rep.getDefaultCurrency() != null) {
            organization.setDefaultCurrency(rep.getDefaultCurrency());
        }
        if (rep.getSupportedCurrencies() != null) {
            organization.setSupportedCurrencies(new HashSet<String>(new HashSet<>(rep.getSupportedCurrencies())));
        }

         /*
         * Smtp server
         */
        if (rep.getSmtpServer() != null) {
            organization.setSmtpConfig(new HashMap<String, String>(rep.getSmtpServer()));
        }
    }

    public void updatePostalAddress(OrganizationModel organization, OrganizationRepresentation rep) {
        if (rep.getPostalAddress() != null) {
            PostalAddressRepresentation postalAddressRep = rep.getPostalAddress();
            if (postalAddressRep.getPostalAddressId() != null) {
                organization.setPostalAddressId(postalAddressRep.getPostalAddressId());
            }
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
    }

    public ComponentModel toModel(ComponentRepresentation rep) {
        ComponentModel model = new ComponentModel();
        model.setParentId(rep.getParentId());
        model.setProviderType(rep.getProviderType());
        model.setProviderId(rep.getProviderId());
        model.setConfig(new MultivaluedHashMap<>());
        model.setName(rep.getName());
        model.setSubType(rep.getSubType());

        if (rep.getConfig() != null) {
            Set<String> keys = new HashSet<>(rep.getConfig().keySet());
            for (String k : keys) {
                List<String> values = rep.getConfig().get(k);
                if (values != null) {
                    ListIterator<String> itr = values.listIterator();
                    while (itr.hasNext()) {
                        String v = itr.next();
                        if (v == null || v.trim().isEmpty()) {
                            itr.remove();
                        }
                    }

                    if (!values.isEmpty()) {
                        model.getConfig().put(k, values);
                    }
                }
            }
        }

        return model;
    }

    public void updateComponent(ComponentRepresentation rep, ComponentModel component, boolean internal) {
        if (rep.getName() != null) {
            component.setName(rep.getName());
        }

        if (rep.getParentId() != null) {
            component.setParentId(rep.getParentId());
        }

        if (rep.getProviderType() != null) {
            component.setProviderType(rep.getProviderType());
        }

        if (rep.getProviderId() != null) {
            component.setProviderId(rep.getProviderId());
        }

        if (rep.getSubType() != null) {
            component.setSubType(rep.getSubType());
        }

        Map<String, ProviderConfigProperty> providerConfiguration = null;
        if (!internal) {
            providerConfiguration = componentUtil.getComponentConfigProperties(component);
        }

        if (rep.getConfig() != null) {
            Set<String> keys = new HashSet<>(rep.getConfig().keySet());
            for (String k : keys) {
                if (!internal && !providerConfiguration.containsKey(k)) {
                    break;
                }

                List<String> values = rep.getConfig().get(k);
                if (values == null || values.isEmpty() || values.get(0) == null
                        || values.get(0).trim().isEmpty()) {
                    component.getConfig().remove(k);
                } else {
                    ListIterator<String> itr = values.listIterator();
                    while (itr.hasNext()) {
                        String v = itr.next();
                        if (v == null || v.trim().isEmpty() || v.equals(ComponentRepresentation.SECRET_VALUE)) {
                            itr.remove();
                        }
                    }

                    if (!values.isEmpty()) {
                        component.getConfig().put(k, values);
                    }
                }
            }
        }
    }

    protected void importComponents(OrganizationModel newOrganization, MultivaluedHashMap<String, ComponentExportRepresentation> components, String parentId, ComponentProvider componentProvider) throws ModelException {
        for (Map.Entry<String, List<ComponentExportRepresentation>> entry : components.entrySet()) {
            String providerType = entry.getKey();
            for (ComponentExportRepresentation compRep : entry.getValue()) {
                ComponentModel component = new ComponentModel();
                component.setId(compRep.getId());
                component.setName(compRep.getName());
                component.setConfig(compRep.getConfig());
                component.setProviderType(providerType);
                component.setProviderId(compRep.getProviderId());
                component.setSubType(compRep.getSubType());
                component.setParentId(parentId);

                component = componentProvider.addComponentModel(newOrganization, component);
                if (compRep.getSubComponents() != null) {
                    importComponents(newOrganization, compRep.getSubComponents(), component.getId(), componentProvider);
                }
            }
        }
    }

}