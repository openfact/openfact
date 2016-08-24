package org.openfact.models.jpa.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Entity
@DiscriminatorValue(value = "VALUABLE")
public class ValuableDocumentEntity extends DocumentEntity {

    @Column(name = "VALUE")
    protected BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
