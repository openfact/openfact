package org.openfact.core.keys;

import org.openfact.core.keys.component.ComponentFactory;
import org.openfact.core.keys.component.ComponentModel;
import org.openfact.core.models.OrganizationModel;

public interface KeyProviderFactory<T extends KeyProvider> extends ComponentFactory<T, KeyProvider> {

    T create(OrganizationModel organization, ComponentModel model);

}
