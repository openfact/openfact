package org.openfact.actions;

import org.openfact.provider.ProviderFactory;

/**
 * You must specify a file
 * META-INF/services/org.keycloak.authentication.RequiredActionFactory in the jar that this class is contained in
 * This file must have the fully qualified class name of all your RequiredActionFactory classes
 */
public interface RequiredActionFactory extends ProviderFactory<RequiredActionProvider> {

    /**
     * Display text used in admin console to reference this required action
     *
     * @return
     */
    String getDisplayText();
}
