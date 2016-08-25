package org.openfact.models.jpa.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Entity
@DiscriminatorValue(value = "CHECKABLE")
public class CheckableDocumentEntity extends DocumentEntity {

    @Column(name = "CHECK")
    protected Boolean check;

    public Boolean isCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

}
