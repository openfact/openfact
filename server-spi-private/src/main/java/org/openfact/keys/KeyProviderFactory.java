package org.openfact.keys;

import org.openfact.models.OrganizationModel;
import org.openfact.models.component.ComponentFactory;
import org.openfact.models.component.ComponentModel;

public interface KeyProviderFactory<T extends KeyProvider> extends ComponentFactory<T, KeyProvider> {

    T create(OrganizationModel organization, ComponentModel model);

}
