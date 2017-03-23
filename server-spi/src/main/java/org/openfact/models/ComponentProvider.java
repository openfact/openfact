package org.openfact.models;

import java.util.List;

import org.openfact.component.ComponentModel;

public interface ComponentProvider {

	/**
     * Adds component model. Will call onCreate() method of ComponentFactory
     *
     * @param model
     * @return
     */
    ComponentModel addComponentModel(OrganizationModel organization, ComponentModel model) throws ModelException;

    /**
     * Adds component model. Will NOT call onCreate() method of ComponentFactory
     *
     * @param model
     * @return
     */
    ComponentModel importComponentModel(OrganizationModel organization, ComponentModel model) throws ModelException;

    void updateComponent(OrganizationModel organization, ComponentModel component) throws ModelException;

    void removeComponent(OrganizationModel organization, ComponentModel component);

    void removeComponents(OrganizationModel organization, String parentId);

    List<ComponentModel> getComponents(OrganizationModel organization, String parentId, String providerType);

    List<ComponentModel> getComponents(OrganizationModel organization, String parentId);

    List<ComponentModel> getComponents(OrganizationModel organization);

    ComponentModel getComponent(OrganizationModel organization, String id);
    
}
