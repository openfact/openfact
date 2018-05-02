package org.openfact.pe.models.jpa.entities;


import javax.persistence.*;

@Entity
@Table(name = "percepcion")
public class PercepcionEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
