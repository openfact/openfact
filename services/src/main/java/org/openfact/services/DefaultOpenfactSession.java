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
package org.openfact.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.keys.DefaultKeyManager;
import org.openfact.models.*;
import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class DefaultOpenfactSession implements OpenfactSession {

	private final DefaultOpenfactSessionFactory factory;
	private final Map<Integer, Provider> providers = new HashMap<>();
	private final List<Provider> closable = new LinkedList<Provider>();
	private final DefaultOpenfactTransactionManager transactionManager;
	private final Map<String, Object> attributes = new HashMap<>();
	private OrganizationProvider model;
	private OpenfactContext context;
	private KeyManager keyManager;

	private InvoiceProvider invoices;
	private CreditNoteProvider creditNotes;
	private DebitNoteProvider debitNotes;

	private StorageFileProvider storageFiles;

	public DefaultOpenfactSession(DefaultOpenfactSessionFactory factory) {
		this.factory = factory;
		this.transactionManager = new DefaultOpenfactTransactionManager(this);
		context = new DefaultOpenfactContext(this);
	}

	@Override
	public OpenfactContext getContext() {
		return context;
	}

	private OrganizationProvider getOrganizationProvider() {
		OrganizationProvider cache = getProvider(OrganizationProvider.class);
		if (cache != null) {
			return cache;
		} else {
			return getProvider(OrganizationProvider.class);
		}
	}

	private InvoiceProvider getInvoiceProvider() {
		InvoiceProvider cache = getProvider(InvoiceProvider.class);
		if (cache != null) {
			return cache;
		} else {
			return getProvider(InvoiceProvider.class);
		}
	}

	private CreditNoteProvider getCreditNoteProvider() {
		CreditNoteProvider cache = getProvider(CreditNoteProvider.class);
		if (cache != null) {
			return cache;
		} else {
			return getProvider(CreditNoteProvider.class);
		}
	}

	private DebitNoteProvider getDebitNoteProvider() {
		DebitNoteProvider cache = getProvider(DebitNoteProvider.class);
		if (cache != null) {
			return cache;
		} else {
			return getProvider(DebitNoteProvider.class);
		}
	}

	private StorageFileProvider getStorageFileProvider() {
		StorageFileProvider cache = getProvider(StorageFileProvider.class);
		if (cache != null) {
			return cache;
		} else {
			return getProvider(StorageFileProvider.class);
		}
	}

	@Override
	public void enlistForClose(Provider provider) {
		closable.add(provider);
	}

	@Override
	public Object getAttribute(String attribute) {
		return attributes.get(attribute);
	}

	@Override
	public Object removeAttribute(String attribute) {
		return attributes.remove(attribute);
	}

	@Override
	public void setAttribute(String name, Object value) {
		attributes.put(name, value);
	}

	@Override
	public OpenfactTransactionManager getTransactionManager() {
		return transactionManager;
	}

	@Override
	public OpenfactSessionFactory getOpenfactSessionFactory() {
		return factory;
	}

	public <T extends Provider> T getProvider(Class<T> clazz) {
		Integer hash = clazz.hashCode();
		T provider = (T) providers.get(hash);
		if (provider == null) {
			ProviderFactory<T> providerFactory = factory.getProviderFactory(clazz);
			if (providerFactory != null) {
				provider = providerFactory.create(this);
				providers.put(hash, provider);
			}
		}
		return provider;
	}

	public <T extends Provider> T getProvider(Class<T> clazz, String id) {
		Integer hash = clazz.hashCode() + id.hashCode();
		T provider = (T) providers.get(hash);
		if (provider == null) {
			ProviderFactory<T> providerFactory = factory.getProviderFactory(clazz, id);

			if (providerFactory != null) {
				provider = providerFactory.create(this);
				providers.put(hash, provider);
			}
		}
		return provider;
	}

	@Override
	public <T extends Provider> T getProvider(Class<T> clazz, ComponentModel componentModel) {
		String modelId = componentModel.getProviderType() + "::" + componentModel.getId();

		Object found = getAttribute(modelId);
		if (found != null) {
			return clazz.cast(found);
		}

		ProviderFactory<T> providerFactory = factory.getProviderFactory(clazz, componentModel.getProviderId());
		if (providerFactory == null) {
			return null;
		}

		ComponentFactory<T, T> componentFactory = (ComponentFactory<T, T>) providerFactory;
		T provider = componentFactory.create(this, componentModel);
		enlistForClose(provider);
		setAttribute(modelId, provider);

		return provider;
	}

	public <T extends Provider> Set<String> listProviderIds(Class<T> clazz) {
		return factory.getAllProviderIds(clazz);
	}

	@Override
	public <T extends Provider> Set<T> getAllProviders(Class<T> clazz) {
		Set<T> providers = new HashSet<T>();
		for (String id : listProviderIds(clazz)) {
			providers.add(getProvider(clazz, id));
		}
		return providers;
	}

	@Override
	public Class<? extends Provider> getProviderClass(String providerClassName) {
		return factory.getProviderClass(providerClassName);
	}

	@Override
	public OrganizationProvider organizations() {
		if (model == null) {
			model = getOrganizationProvider();
		}
		return model;
	}

	@Override
	public InvoiceProvider invoices() {
		if (invoices == null) {
			invoices = getInvoiceProvider();
		}
		return invoices;
	}

	@Override
	public CreditNoteProvider creditNotes() {
		if (creditNotes == null) {
			creditNotes = getCreditNoteProvider();
		}
		return creditNotes;
	}

	@Override
	public DebitNoteProvider debitNotes() {
		if (debitNotes == null) {
			debitNotes = getDebitNoteProvider();
		}
		return debitNotes;
	}

	@Override
	public StorageFileProvider storageFiles() {
		if (storageFiles == null) {
			storageFiles = getStorageFileProvider();
		}
		return storageFiles;
	}

	@Override
	public KeyManager keys() {
		if (keyManager == null) {
			keyManager = new DefaultKeyManager(this);
		}
		return keyManager;
	}

	public void close() {
		for (Provider p : providers.values()) {
			try {
				p.close();
			} catch (Exception e) {
			}
		}
		for (Provider p : closable) {
			try {
				p.close();
			} catch (Exception e) {
			}
		}
	}	
}