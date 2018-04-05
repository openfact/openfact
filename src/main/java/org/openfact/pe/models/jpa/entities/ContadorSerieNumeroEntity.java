package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.openfact.core.models.jpa.entities.OrganizacionEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "contador_serie_numero_pe")
@NamedQueries(value = {
        @NamedQuery(name = "getContadorByOrganizacionIdTipoDocumentoAndSerie", query = "select c from ContadorSerieNumeroEntity c inner join c.organizacion o where o.id=:organizacionId and c.tipoDocumento=:tipoDocumento and c.serie=:serie")
})
public class ContadorSerieNumeroEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "prefijo")
    private String prefijo;

    @Column(name = "serie")
    private String serie;

    @Column(name = "numero_serie")
    private int numeroSerie;

    @Column(name = "numero")
    private int numero;

    @NotNull
    @Type(type = "org.hibernate.type.TrueFalseType")
    @Column(name = "registration_complete")
    private boolean registrationCompleted;

    @OneToOne
    @MapsId
    private OrganizacionEntity organizacion;

    @Version
    @Column(name = "version")
    private int version;

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (getId() != null)
            result += "id: " + getId();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContadorSerieNumeroEntity)) {
            return false;
        }
        ContadorSerieNumeroEntity other = (ContadorSerieNumeroEntity) obj;
        if (getId() != null) {
            if (!getId().equals(other.getId())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public OrganizacionEntity getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizacionEntity company) {
        this.organizacion = company;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
}
