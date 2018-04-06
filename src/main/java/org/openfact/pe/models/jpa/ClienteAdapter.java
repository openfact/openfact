package org.openfact.pe.models.jpa;

import org.openfact.pe.models.ClienteModel;
import org.openfact.pe.models.jpa.entities.ClienteEntity;
import org.openfact.pe.models.types.TipoDocumentoEntidad;

public class ClienteAdapter implements ClienteModel {

    private final ClienteEntity entity;

    public ClienteAdapter(ClienteEntity entity) {
        this.entity = entity;
    }

    @Override
    public TipoDocumentoEntidad getTipoDocumento() {
        return entity.getTipoDocumento();
    }

    @Override
    public void setTipoDocumento(TipoDocumentoEntidad tipoDocumento) {
        entity.setTipoDocumento(tipoDocumento);
    }

    @Override
    public String getNumeroDocumento() {
        return entity.getNumeroDocumento();
    }

    @Override
    public void setNumeroDocumento(String numeroDocumento) {
        entity.setNumeroDocumento(numeroDocumento);
    }

    @Override
    public String getNombre() {
        return entity.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        entity.setNombre(nombre);
    }

    @Override
    public String getEmail() {
        return entity.getEmail();
    }

    @Override
    public void setEmail(String email) {
        entity.setEmail(email);
    }

    @Override
    public String getDireccion() {
        return entity.getDireccion();
    }

    @Override
    public void setDireccion(String direccion) {
        entity.setDireccion(direccion);
    }
}
