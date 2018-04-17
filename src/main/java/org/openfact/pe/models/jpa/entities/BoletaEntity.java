package org.openfact.pe.models.jpa.entities;

import org.openfact.core.models.jpa.entities.OrganizationEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "boleta_pe", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"serie", "numero", "organization_id"})
})
@NamedQueries(value = {
        @NamedQuery(name = "DeleteBoleta", query = "delete from BoletaEntity b where b.id=:boletaId"),
        @NamedQuery(name = "GetBoletaPorId", query = "select b from BoletaEntity b inner join b.organization o where o.id=:organizationId and b.id=:boletaId"),
        @NamedQuery(name = "GetBoletaPorEstado", query = "select b from BoletaEntity b inner join b.organization o where o.id=:organizationId and b.estado=:estado"),
        @NamedQuery(name = "GetBoletaPorSerieYNumero", query = "select b from BoletaEntity b inner join b.organization o where o.id=:organizationId and b.serie=:serie and b.numero=:numero"),
        @NamedQuery(name = "getBoletasEmpezandoPorLasMasRecientes", query = "select b from BoletaEntity b inner join b.organization o where o.id=:organizationId order by b.createdAt"),
        @NamedQuery(name = "getBoletasConSerieEmpezandoPorLasMasRecientes", query = "select b from BoletaEntity b inner join b.organization o where o.id=:organizationId and b.serie=:serie order by b.createdAt")
})
public class BoletaEntity extends AbstractInvoiceEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "serie")
    private String serie;

    @NotNull
    @Column(name = "numero")
    private int numero;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "organization_id")
    private OrganizationEntity organization;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @OneToMany(mappedBy = "boleta", fetch = FetchType.LAZY)
    private List<BoletaDetalleEntity> detalle = new ArrayList<>();

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

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<BoletaDetalleEntity> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<BoletaDetalleEntity> detalle) {
        this.detalle = detalle;
    }
}
