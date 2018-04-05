package org.openfact.pe.models.jpa.entities;

import org.openfact.core.models.jpa.entities.OrganizacionEntity;
import org.openfact.pe.models.EstadoComprobantePago;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "boleta_pe")
@NamedQueries(value = {
        @NamedQuery(name = "GetBoletaByOrganizationIdAndBoletaId", query = "select b from BoletaEntity b inner join b.organizacion o where o.id=:organizacionId and b.id=:boletaId"),
        @NamedQuery(name = "GetBoletaEnOrganizationConSerieYNumero", query = "select b from BoletaEntity b inner join b.organizacion o where o.id=:organizacionId and b.serie=:serie and b.numero=:numero"),
        @NamedQuery(name = "GetUltimaBoletaDeOrganizacionConSerie", query = "select b from BoletaEntity b inner join b.organizacion o where o.id=:organizacionId and b.serie=:serie order by b.createdAt")
})
public class BoletaEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "serie")
    private String serie;

    @NotNull
    @Column(name = "numero")
    private int numero;

    @Embedded
    private ClienteEntity cliente;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoComprobantePago estado;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "organizacion_id")
    private OrganizacionEntity organizacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

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
        if (!(obj instanceof BoletaEntity)) {
            return false;
        }
        BoletaEntity other = (BoletaEntity) obj;
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public EstadoComprobantePago getEstado() {
        return estado;
    }

    public void setEstado(EstadoComprobantePago estado) {
        this.estado = estado;
    }

    public OrganizacionEntity getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizacionEntity organizacion) {
        this.organizacion = organizacion;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
