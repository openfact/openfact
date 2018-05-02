package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.openfact.pe.models.EstadoComprobantePago;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "bajas")
@NamedQueries(value = {
        @NamedQuery(name = "getBajasEmpezandoPorLasMasRecientes", query = "select b from BajaEntity b inner join b.invoice i inner join i.organization o where o.id=:organizationId and b.fechaEmision=:fechaGeneracionBaja order by b.numero"),
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
    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @Column(name = "motivo_baja")
    private String motivoBaja;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoComprobantePago estado;

    @Column(name = "file_id")
    private String fileId;

    @Column(name = "cdr_file_id")
    private String cdrFileId;

    @NotNull
    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "enviar_sunat")
    private boolean enviarSunat;

    @NotNull
    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "enviar_cliente")
    private boolean enviarCliente;

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

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaGeneracionBaja) {
        this.fechaEmision = fechaGeneracionBaja;
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

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getCdrFileId() {
        return cdrFileId;
    }

    public void setCdrFileId(String cdrFileId) {
        this.cdrFileId = cdrFileId;
    }

    public boolean isEnviarSunat() {
        return enviarSunat;
    }

    public void setEnviarSunat(boolean enviarSunat) {
        this.enviarSunat = enviarSunat;
    }

    public boolean isEnviarCliente() {
        return enviarCliente;
    }

    public void setEnviarCliente(boolean enviarCliente) {
        this.enviarCliente = enviarCliente;
    }
}
