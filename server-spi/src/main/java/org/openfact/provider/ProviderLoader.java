package org.openfact.provider;

import java.util.List;

/**
 * @author carlosthe19916@gmail.com
 * @version 1.0.0.Final
 */
public interface ProviderLoader {

    /**
     * Load the SPI definitions themselves.
     *
     * @return a list of Spi definition objects
     */
    List<Spi> loadSpis();

    /**
     * Load all provider factories of a specific SPI.
     *
     * @param spi
     *            the Spi definition
     * @return a list of provider factories
     */
    List<ProviderFactory> load(Spi spi);

}
