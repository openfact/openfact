/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */
package org.openfact.services.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openfact.Config;
import org.openfact.common.Version;
import org.openfact.models.*;
import org.openfact.models.catalog.CodeCatalogModel;
import org.openfact.models.catalog.CountryCatalogModel;
import org.openfact.models.catalog.CurrencyCatalogModel;
import org.openfact.models.catalog.UnitCatalogModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.representations.idm.catalog.CodeCatalogRepresentation;
import org.openfact.representations.idm.catalog.CountryCatalogRepresentation;
import org.openfact.representations.idm.catalog.CurrencyCatalogRepresentation;
import org.openfact.representations.idm.catalog.UnitCatalogRepresentation;
import org.openfact.services.ServicesLogger;
import org.openfact.util.JsonSerialization;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class ApplianceBootstrap {

    private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;
    private final OpenfactSession session;

    public ApplianceBootstrap(OpenfactSession session) {
        this.session = session;
    }

    public boolean isNewInstall() {
        if (session.organizations().getOrganizations().size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isNoMasterOrganization() {
        OrganizationModel organization = session.organizations().getOrganization(Config.getAdminOrganization());
        return session.organizations().getOrganizationsCount() == 0;
    }

    public boolean createMasterOrganization(String contextPath) {
        if (!isNewInstall()) {
            throw new IllegalStateException("Can't create default organization as organizations already exists");
        }

        String adminOrganizationName = Config.getAdminOrganization();
        logger.initializingAdminOrganization(adminOrganizationName);

        OrganizationManager manager = new OrganizationManager(session);
        manager.setContextPath(contextPath);
        OrganizationModel organization = manager.createOrganization(adminOrganizationName, adminOrganizationName);
        organization.setName(adminOrganizationName);
        organization.setDisplayName(Version.NAME);
        organization.setDisplayNameHtml(Version.NAME_HTML);
        organization.setEnabled(true);
        
        organization.setAttempNumber(1);
        organization.setDelayTime(1);
        organization.setOnErrorAttempNumber(1);
        organization.setOnErrorLapseTime(1);
        OpenfactModelUtils.generateOrganizationKeys(organization);

        return true;
    }

    public void createMasterOrganizationUser(String username, String password) {
        /*OrganizationModel organization = session.organizations().getOrganization(Config.getAdminOrganization());
        session.getContext().setOrganization(organization);

        if (session.users().getUsersCount(organization) > 0) {
            throw new IllegalStateException("Can't create initial user as users already exists");
        }

        UserModel adminUser = session.users().addUser(organization, username);
        adminUser.setEnabled(true);

        UserCredentialModel usrCredModel = new UserCredentialModel();
        usrCredModel.setType(UserCredentialModel.PASSWORD);
        usrCredModel.setValue(password);
        session.users().updateCredential(organization, adminUser, usrCredModel);

        RoleModel adminRole = organization.getRole(AdminRoles.ADMIN);
        adminUser.grantRole(adminRole);*/
    }

    public boolean createDefaultCatalog(String contextPath) {
        createDefaultCodeCatalog(contextPath);
        createDefaultCountryCatalog(contextPath);
        createDefaultCurrencyCatalog(contextPath);
        createDefaultUnitCatalog(contextPath);   
        return true;
    }
    
    public boolean createDefaultCodeCatalog(String contextPath) {
        if (session.codesCatalog().getCodesCatalogCount() > 0) {
            throw new IllegalStateException("Can't create initial codes catalog as codes already exists");
        }
                
        File addCodeCatalogFile = null;
        
        String configDir = System.getProperty("jboss.server.config.dir");
        if (configDir != null) {
            addCodeCatalogFile = new File(configDir + File.separator + "openfact-default-codeCatalog.json");                        
        } else {
            addCodeCatalogFile = new File(getClass().getResource("/META-INF/openfact-default-codeCatalog.json").getFile());
        }
        
        if (addCodeCatalogFile.isFile()) {
            logger.importingCodesCatalogFrom(addCodeCatalogFile);

            List<CodeCatalogRepresentation> catalogs;
            try {
                catalogs = JsonSerialization.readValue(new FileInputStream(addCodeCatalogFile), new TypeReference<List<CodeCatalogRepresentation>>() {
                });
            } catch (IOException e) {
                logger.failedToLoadCodesCatalog(e);
                return false;
            }

            for (CodeCatalogRepresentation catalogRep : catalogs) {
                try {
                    CodeCatalogModel catalog = session.codesCatalog().addCodeCatalog(catalogRep.getLocale(), catalogRep.getType(), catalogRep.getCode(), catalogRep.getDescription());
                    catalog.setAttributes(catalogRep.getAttributes());

                    logger.addCodeCatalogSuccess(catalogRep.getDescription());
                } catch (ModelDuplicateException e) {
                    logger.addCodeCatalogFailedCodeCatalogExists(catalogRep.getCode(), catalogRep.getDescription());
                } catch (Throwable t) {
                    logger.addCodeCatalogFailed(t, catalogRep.getCode(), catalogRep.getDescription());
                } 
            }
        }
        
        return true;
    }
    
    public boolean createDefaultCountryCatalog(String contextPath) {
        if (session.countriesCatalog().getCountriesCatalogCount() > 0) {
            throw new IllegalStateException("Can't create initial country catalog as countries already exists");
        }
        
        File addCountryCatalogFile = null;
        
        String configDir = System.getProperty("jboss.server.config.dir");
        if (configDir != null) {
            addCountryCatalogFile = new File(configDir + File.separator + "openfact-default-countryCatalog.json");                        
        } else {
            addCountryCatalogFile = new File(getClass().getResource("/META-INF/openfact-default-countryCatalog.json").getFile());
        }
        
        if (addCountryCatalogFile.isFile()) {
            logger.importingCountrysCatalogFrom(addCountryCatalogFile);

            List<CountryCatalogRepresentation> catalogs;
            try {
                catalogs = JsonSerialization.readValue(new FileInputStream(addCountryCatalogFile), new TypeReference<List<CountryCatalogRepresentation>>() {
                });
            } catch (IOException e) {
                logger.failedToLoadCountrysCatalog(e);
                return false;
            }

            for (CountryCatalogRepresentation catalogRep : catalogs) {
                try {
                    CountryCatalogModel catalog = session.countriesCatalog().addCountryCatalog(catalogRep.getName());
                    catalog.setShortName(catalogRep.getShortName());
                    catalog.setAlpha2Code(catalogRep.getAlpha2Code());
                    catalog.setAlpha3Code(catalogRep.getAlpha3Code());
                    catalog.setNumericCode(catalogRep.getNumericCode());
                    
                    logger.addCountryCatalogSuccess(catalogRep.getName());
                } catch (ModelDuplicateException e) {                    
                    logger.addCountryCatalogFailedCountryCatalogExists(catalogRep.getName(), catalogRep.getShortName());
                } catch (Throwable t) {                    
                    logger.addCountryCatalogFailed(t, catalogRep.getName(), catalogRep.getShortName());
                }
            }
        }
        return true;
    }
    
    public boolean createDefaultCurrencyCatalog(String contextPath) {
        if (session.currenciesCatalog().getCurrenciesCatalogCount() > 0) {
            throw new IllegalStateException("Can't create initial currency catalog as currencys already exists");
        }
        
        File addCurrencyCatalogFile = null;
        
        String configDir = System.getProperty("jboss.server.config.dir");
        if (configDir != null) {
            addCurrencyCatalogFile = new File(configDir + File.separator + "openfact-default-currencyCatalog.json");                        
        } else {
            addCurrencyCatalogFile = new File(getClass().getResource("/META-INF/openfact-default-currencyCatalog.json").getFile());
        }
        
        if (addCurrencyCatalogFile.isFile()) {
            logger.importingCurrencysCatalogFrom(addCurrencyCatalogFile);

            List<CurrencyCatalogRepresentation> catalogs;
            try {
                catalogs = JsonSerialization.readValue(new FileInputStream(addCurrencyCatalogFile), new TypeReference<List<CurrencyCatalogRepresentation>>() {
                });
            } catch (IOException e) {
                logger.failedToLoadCurrencysCatalog(e);
                return false;
            }

            for (CurrencyCatalogRepresentation catalogRep : catalogs) {
                try {
                    CurrencyCatalogModel catalog = session.currenciesCatalog().addCurrencyCatalog(catalogRep.getEntity(), catalogRep.getCurrency());
                    catalog.setAlphabeticCode(catalogRep.getAlphabeticCode());
                    catalog.setNumericCode(catalogRep.getNumericCode());
                    catalog.setMinorUnit(catalogRep.getMinorUnit());
                    
                    logger.addCurrencyCatalogSuccess(catalogRep.getCurrency());
                } catch (ModelDuplicateException e) {                    
                    logger.addCurrencyCatalogFailedCurrencyCatalogExists(catalogRep.getCurrency(), catalogRep.getEntity());
                } catch (Throwable t) {                    
                    logger.addCurrencyCatalogFailed(t, catalogRep.getCurrency(), catalogRep.getEntity());
                }
            }
        }
        return true;
    }
    
    public boolean createDefaultUnitCatalog(String contextPath) {
        if (session.unitsCatalog().getUnitsCatalogCount() > 0) {
            throw new IllegalStateException("Can't create initial units catalog as units already exists");
        }
        
        File addUnitCatalogFile = null;
        
        String configDir = System.getProperty("jboss.server.config.dir");
        if (configDir != null) {
            addUnitCatalogFile = new File(configDir + File.separator + "openfact-default-unitCatalog.json");                        
        } else {
            addUnitCatalogFile = new File(getClass().getResource("/META-INF/openfact-default-unitCatalog.json").getFile());
        }
        
        if (addUnitCatalogFile.isFile()) {
            logger.importingUnitsCatalogFrom(addUnitCatalogFile);

            List<UnitCatalogRepresentation> catalogs;
            try {
                catalogs = JsonSerialization.readValue(new FileInputStream(addUnitCatalogFile), new TypeReference<List<UnitCatalogRepresentation>>() {
                });
            } catch (IOException e) {
                logger.failedToLoadUnitsCatalog(e);
                return false;
            }

            for (UnitCatalogRepresentation catalogRep : catalogs) {
                try {
                    UnitCatalogModel catalog = session.unitsCatalog().addUnitCatalog(catalogRep.getName(), catalogRep.getSymbol(), catalogRep.getDescription());                    

                    logger.addUnitCatalogSuccess(catalogRep.getDescription());
                } catch (ModelDuplicateException e) {
                    logger.addUnitCatalogFailedUnitCatalogExists(catalogRep.getName(), catalogRep.getDescription());
                } catch (Throwable t) {
                    logger.addUnitCatalogFailed(t, catalogRep.getName(), catalogRep.getDescription());
                }
            }
        }
        return true;
    }

}
