package org.openfact.keys;

import org.openfact.keys.component.ComponentFactory;
import org.openfact.keys.component.ComponentModel;
import org.openfact.models.CompanyModel;

public interface KeyProviderFactory<T extends KeyProvider> extends ComponentFactory<T, KeyProvider> {

    T create(CompanyModel organization, ComponentModel model);

}
