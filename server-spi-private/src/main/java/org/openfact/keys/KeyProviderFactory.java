package org.openfact.keys;

import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.models.OpenfactSession;

public interface KeyProviderFactory<T extends KeyProvider> extends ComponentFactory<T, KeyProvider> {

    T create(OpenfactSession session, ComponentModel model);

}
