package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.openfact.pe.models.EstadoComprobantePago;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "cdr_id")
    private CdrEntity cdr;

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
    @JoinColumn(foreignKey = @ForeignKey, name = "estado_sunat_id")
    private EstadoSunatEntity estadoSunat;

    @ElementCollection
    @Column(name = "value")
    @CollectionTable(name = "baja_labels", joinColumns = {@JoinColumn(name = "baja_id")})
    private Set<String> labels = new HashSet<>();

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

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    public EstadoComprobantePago getEstado() {
        return estado;
    }

    public void setEstado(EstadoComprobantePago estado) {
        this.estado = estado;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public CdrEntity getCdr() {
        return cdr;
    }

    public void setCdr(CdrEntity cdr) {
        this.cdr = cdr;
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

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }

    public EstadoSunatEntity getEstadoSunat() {
        return estadoSunat;
    }

    public void setEstadoSunat(EstadoSunatEntity estadoSunat) {
        this.estadoSunat = estadoSunat;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }
}
