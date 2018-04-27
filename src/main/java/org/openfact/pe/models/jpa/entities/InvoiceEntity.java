package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.openfact.core.models.jpa.entities.OrganizationEntity;
import org.openfact.pe.models.EstadoComprobantePago;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "invoice", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"serie", "numero", "organization_id"})
})
@NamedQueries(value = {
        @NamedQuery(name = "getInvoicesEmpezandoPorLasMasRecientes", query = "select i from InvoiceEntity i  inner join i.organization o where o.id=:organizationId and i.codigoTipoComprobante=:codigo order by i.createdAt"),
        @NamedQuery(name = "getInvoicesConSerieEmpezandoPorLasMasRecientes", query = "select i from InvoiceEntity i inner join i.organization o where o.id=:organizationId and i.codigoTipoComprobante=:codigo and i.serie=:serie order by i.createdAt"),
        @NamedQuery(name = "getInvoicesPorSerieYNumero", query = "select i from InvoiceEntity i inner join i.organization o where o.id=:organizationId and i.serie=:serie and i.numero=:numero"),
        @NamedQuery(name = "countInvoices", query = "select count(i) from InvoiceEntity i inner join i.organization o where o.id=:organizationId"),
        @NamedQuery(name = "getInvoicesPorId", query = "select i from InvoiceEntity i inner join i.organization o where o.id=:organizationId and i.id=:invoiceId"),
        @NamedQuery(name = "filterDistinctInvoices", query = "select distinct i from InvoiceEntity i inner join i.organization o where o.id=:organizationId and lower(i.serie) like :filterText"),
})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "graph.ListInvoices", attributeNodes = {
                @NamedAttributeNode(value = "id"),
                @NamedAttributeNode(value = "datosVenta", subgraph = "datosVenta"),
                @NamedAttributeNode(value = "validacion", subgraph = "validacion"),
                @NamedAttributeNode(value = "organization", subgraph = "organization"),
        }, subgraphs = {
                @NamedSubgraph(name = "datosVenta", attributeNodes = {
                        @NamedAttributeNode(value = "id")
                }),
                @NamedSubgraph(name = "validacion", attributeNodes = {
                        @NamedAttributeNode(value = "id")
                }),
                @NamedSubgraph(name = "organization", attributeNodes = {
                        @NamedAttributeNode(value = "id")
                }),
                @NamedSubgraph(name = "resumenDiario", attributeNodes = {
                        @NamedAttributeNode(value = "id")
                })
        })
})
public class InvoiceEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "id")
    private String id;

    @NotNull
    @Size(min = 4, max = 4)
    @Column(name = "serie")
    private String serie;

    @NotNull
    @Column(name = "numero")
    private int numero;

    @NotNull
    @Column(name = "codigo_tipo_comprobante")
    private String codigoTipoComprobante;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoComprobantePago estado;

    @Column(name = "estado_descripcion")
    private String estadoDescripcion;

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
    @JoinColumn(foreignKey = @ForeignKey, name = "datos_venta_id")
    private DatosVentaEntity datosVenta;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "nota_id")
    private ValidacionEntity validacion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "organization_id")
    private OrganizationEntity organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "resumen_diario_id")
    private ResumenDiarioEntity resumenDiario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Version
    @Column(name = "version")
    private int version;

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

    public EstadoComprobantePago getEstado() {
        return estado;
    }

    public void setEstado(EstadoComprobantePago estado) {
        this.estado = estado;
    }

    public String getEstadoDescripcion() {
        return estadoDescripcion;
    }

    public void setEstadoDescripcion(String estadoDescripcion) {
        this.estadoDescripcion = estadoDescripcion;
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

    public DatosVentaEntity getDatosVenta() {
        return datosVenta;
    }

    public void setDatosVenta(DatosVentaEntity datosVenta) {
        this.datosVenta = datosVenta;
    }

    public ValidacionEntity getValidacion() {
        return validacion;
    }

    public void setValidacion(ValidacionEntity validacion) {
        this.validacion = validacion;
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

    public ResumenDiarioEntity getResumenDiario() {
        return resumenDiario;
    }

    public void setResumenDiario(ResumenDiarioEntity resumenDiario) {
        this.resumenDiario = resumenDiario;
    }

    public String getCodigoTipoComprobante() {
        return codigoTipoComprobante;
    }

    public void setCodigoTipoComprobante(String codigo) {
        this.codigoTipoComprobante = codigo;
    }
}
