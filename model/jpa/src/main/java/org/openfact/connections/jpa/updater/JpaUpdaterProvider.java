package org.openfact.connections.jpa.updater;

import org.openfact.provider.Provider;

import java.io.File;
import java.sql.Connection;

public interface JpaUpdaterProvider extends Provider {

    /**
     * Status of database up-to-dateness
     */
    enum Status {
        /**
         * Database is valid and up to date
         */
        VALID,
        /**
         * No database exists.
         */
        EMPTY,
        /**
         * Database needs to be updated
         */
        OUTDATED
    }

    /**
     * Updates the Openfact database
     *
     * @param connection    DB connection
     * @param defaultSchema DB connection
     */
    void update(Connection connection, String defaultSchema);

    /**
     * Checks whether Openfact database is up to date with the most recent changesets
     *
     * @param connection    DB connection
     * @param defaultSchema DB schema to use
     * @return
     */
    Status validate(Connection connection, String defaultSchema);

    /**
     * Exports the SQL update script into the given File.
     *
     * @param connection    DB connection
     * @param defaultSchema DB schema to use
     * @param file          File to write to
     */
    void export(Connection connection, String defaultSchema, File file);

}
