package org.openfact.models.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SERIE_NUMERO", uniqueConstraints = {@UniqueConstraint(columnNames = {"DOCUMENT_TYPE", "ORGANIZATION_ID", "FIRST_LETTER"})})
@NamedQueries(value = {
        @NamedQuery(name = "selectSerieNumero", query = "select s from SerieNumeroEntity s where s.organizationId=:organizationId and s.documentType=:documentType and s.firstLetter=:firstLetter"),
})
public class SerieNumeroEntity {

    @Id
    @Column(name = "ID")
    @Access(AccessType.PROPERTY)
    private String id;

    @NotNull
    @Column(name = "DOCUMENT_TYPE")
    private String documentType;

    @NotNull
    @Column(name = "FIRST_LETTER")
    private String firstLetter;

    @NotNull
    @Column(name = "SERIE")
    private int serie;

    @NotNull
    @Column(name = "NUMERO")
    private int numero;

    @NotNull
    @Column(name = "ORGANIZATION_ID")
    private String organizationId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }
}
