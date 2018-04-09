package org.openfact.pe.models.jpa.entities;

import org.openfact.core.models.jpa.entities.OrganizationEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "informacion_adicional_pe")
@NamedQueries(value = {

})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "graph.InformacionAdicionalOrganizacion", attributeNodes = {
                @NamedAttributeNode("id"),
                @NamedAttributeNode(value = "organizacion", subgraph = "organizacion")
        }, subgraphs = {
                @NamedSubgraph(name = "organizacion", attributeNodes = {
                        @NamedAttributeNode("id")
                })
        })
})
public class OrganizacionInformacionAdicionalEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "assigned_id")
    private String assignedId;

    @Column(name = "additional_assigned_id")
    private String additionalAssignedId;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "nombre_comercial")
    private String nombreComercial;

    @Column(name = "region")
    private String region;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "distrito")
    private String distrito;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Column(name = "codigo_pais")
    private String codigoPais;

    @Column(name = "direccion")
    private String direccion;

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

    public String getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(String assignedId) {
        this.assignedId = assignedId;
    }

    public String getAdditionalAssignedId() {
        return additionalAssignedId;
    }

    public void setAdditionalAssignedId(String additionalAssignedId) {
        this.additionalAssignedId = additionalAssignedId;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (id != null)
            result += "id: " + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrganizacionInformacionAdicionalEntity)) {
            return false;
        }
        OrganizacionInformacionAdicionalEntity other = (OrganizacionInformacionAdicionalEntity) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
