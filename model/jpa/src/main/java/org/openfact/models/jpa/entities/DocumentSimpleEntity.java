package org.openfact.models.jpa.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Entity
@DiscriminatorValue(value = "SIMPLE")
public class DocumentSimpleEntity extends DocumentComponentEntity {

}
