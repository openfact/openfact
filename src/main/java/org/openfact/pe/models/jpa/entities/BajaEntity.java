package org.openfact.pe.models.jpa.entities;

import org.openfact.pe.models.EstadoComprobantePago;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "bajas")
@NamedQueries(value = {
        @NamedQuery(name = "getBajasEmpezandoPorLasMasRecientes", query = "select b from BajaEntity b inner join b.invoice i inner join i.organization o where o.id=:organizationId and b.fechaGeneracionBaja=:fechaGeneracionBaja order by b.numero"),
        @NamedQuery(name = "getBajasPorSerieYNumero", query = "select b from BajaEntity b inner join b.invoice i inner join i.organization o where o.id=:organizationId and b.serie=:serie and b.numero=:numero"),
        @NamedQuery(name = "countBajas", query = "select count(b) from BajaEntity b inner join b.invoice i inner join i.organization o where o.id=:organizationId"),
        @NamedQuery(name = "getBajasPorId", query = "select b from BajaEntity b inner join b.invoice i inner join i.organization o where o.id=:organizationId and b.id=:bajaId"),
        @NamedQuery(name = "filterDistinctBajas", query = "select distinct b from BajaEntity b inner join b.invoice i inner join i.organization o where o.id=:organizationId and lower(b.serie) like :filterText"),
})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "graph.ListBajas", attributeNodes = {
                @NamedAttributeNode(value = "id"),
                @NamedAttributeNode(value = "invoice", subgraph = "invoice")
        }, subgraphs = {
                @NamedSubgraph(name = "invoice", attributeNodes = {
                        @NamedAttributeNode(value = "id")
                })
        })
})
public class BajaEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "id")
    private String id;

    @NotNull
    @Size(min = 11, max = 11)
    @Column(name = "serie")
    private String serie;

    @NotNull
    @Column(name = "numero")
    private int numero;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaBaja")
    private Date fechaGeneracionBaja;

    @Column(name = "motivo_baja")
    private String motivoBaja;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoComprobantePago estado;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "invoice_id")
    private InvoiceEntity invoice;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "nota_id")
    private ValidacionEntity validacion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivo_baja) {
        this.motivoBaja = motivo_baja;
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

    public Date getFechaGeneracionBaja() {
        return fechaGeneracionBaja;
    }

    public void setFechaGeneracionBaja(Date fechaGeneracionBaja) {
        this.fechaGeneracionBaja = fechaGeneracionBaja;
    }

    public EstadoComprobantePago getEstado() {
        return estado;
    }

    public void setEstado(EstadoComprobantePago estado) {
        this.estado = estado;
    }

    public ValidacionEntity getValidacion() {
        return validacion;
    }

    public void setValidacion(ValidacionEntity validacion) {
        this.validacion = validacion;
    }
}
