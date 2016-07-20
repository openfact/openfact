package org.openfact.connections.jpa.entityprovider;

import java.util.List;

import org.openfact.provider.Provider;

/**
 * 
 * A JPA Entity Provider can supply extra JPA entities that the Openfact system should include in it's entity manager. The
 * entities should be provided as a list of Class objects.
 */
public interface JpaEntityProvider extends Provider {

    /**
     * Return the entities that should be added to the entity manager.
     * 
     * @return list of class objects
     */
	List<Class<?>> getEntities();
	
	/**
	 * Return the location of the Liquibase changelog that facilitates the extra JPA entities.
	 * This should be a location that can be found on the same classpath as the entity classes.
	 * 
	 * @return a changelog location or null if not needed
	 */
	String getChangelogLocation();

	/**
	 * Return the ID of provider factory, which created this provider. Might be used to "compute" the table name of liquibase changelog table.
	 * @return ID of provider factory
	 */
	String getFactoryId();

}
