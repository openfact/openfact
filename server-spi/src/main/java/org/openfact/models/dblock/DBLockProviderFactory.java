package org.openfact.models.dblock;

import org.openfact.provider.ProviderFactory;

public interface DBLockProviderFactory extends ProviderFactory<DBLockProvider> {

    /**
     * Useful for testing to override provided configuration
     */
    void setTimeouts(long lockRecheckTimeMillis, long lockWaitTimeoutMillis);
}
