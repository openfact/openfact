package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.openfact.core.models.jpa.entities.OrganizationEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "organizacion_informacion_sunat")
@NamedQueries(value = {

})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "graph.InformacionSUNATOrganizacion", attributeNodes = {
                @NamedAttributeNode("id"),
                @NamedAttributeNode(value = "organizacion", subgraph = "organizacion")
        }, subgraphs = {
                @NamedSubgraph(name = "organizacion", attributeNodes = {
                        @NamedAttributeNode("id")
                })
        })
})
public class OrganizacionInformacionSunatEntity implements Serializable {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "id")
    private String id;

    @NotNull
    @Type(type = "org.hibernate.type.TrueFalseType")
    @Column(name = "use_custom_config")
    private boolean useCustomConfig;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "password")
    private String password;

    @Column(name = "boleta_factura_endpoint")
    private String boletaFacturaEndpoint;

    @Column(name = "guia_remision_enpoint")
    private String guiaRemisionEndpoint;

    @Column(name = "retencion_percepcion_endpoint")
    private String retencionPercepcionEndpoint;

    @Column(name = "consulta_factura_endpoint")
    private String consultaFacturaEndpoint;

    @Column(name = "consulta_cdr_endpoint")
    private String consultaCdrEndpoint;

    @OneToOne
    @MapsId
    private OrganizationEntity organizacion;

    @Version
    @Column(name = "version")
    private int version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isUseCustomConfig() {
        return useCustomConfig;
    }

    public void setUseCustomConfig(boolean useCustomConfig) {
        this.useCustomConfig = useCustomConfig;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBoletaFacturaEndpoint() {
        return boletaFacturaEndpoint;
    }

    public void setBoletaFacturaEndpoint(String boletaFacturaEndpoint) {
        this.boletaFacturaEndpoint = boletaFacturaEndpoint;
    }

    public String getGuiaRemisionEndpoint() {
        return guiaRemisionEndpoint;
    }

    public void setGuiaRemisionEndpoint(String guiaRemisionEndpoint) {
        this.guiaRemisionEndpoint = guiaRemisionEndpoint;
    }

    public String getRetencionPercepcionEndpoint() {
        return retencionPercepcionEndpoint;
    }

    public void setRetencionPercepcionEndpoint(String retencionPercepcionEndpoint) {
        this.retencionPercepcionEndpoint = retencionPercepcionEndpoint;
    }

    public String getConsultaFacturaEndpoint() {
        return consultaFacturaEndpoint;
    }

    public void setConsultaFacturaEndpoint(String consultaFacturaEndpoint) {
        this.consultaFacturaEndpoint = consultaFacturaEndpoint;
    }

    public String getConsultaCdrEndpoint() {
        return consultaCdrEndpoint;
    }

    public void setConsultaCdrEndpoint(String consultaCdrEndpoint) {
        this.consultaCdrEndpoint = consultaCdrEndpoint;
    }

    public OrganizationEntity getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizationEntity organizacion) {
        this.organizacion = organizacion;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
