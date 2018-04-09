package org.openfact.pe.models.jpa;

import org.openfact.pe.models.ClienteModel;
import org.openfact.pe.models.jpa.entities.ClienteEntity;
import org.openfact.pe.models.types.TipoDocumentoEntidad;

public class ClienteAdapter implements ClienteModel {

    private final ClienteEntity cliente;

    public ClienteAdapter(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    @Override
    public TipoDocumentoEntidad getTipoDocumento() {
        return cliente.getTipoDocumento();
    }

    @Override
    public void setTipoDocumento(TipoDocumentoEntidad tipoDocumento) {
        cliente.setTipoDocumento(tipoDocumento);
    }

    @Override
    public String getNumeroDocumento() {
        return cliente.getNumeroDocumento();
    }

    @Override
    public void setNumeroDocumento(String numeroDocumento) {
        cliente.setNumeroDocumento(numeroDocumento);
    }

    @Override
    public String getNombre() {
        return cliente.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        cliente.setNombre(nombre);
    }

    @Override
    public String getEmail() {
        return cliente.getEmail();
    }

    @Override
    public void setEmail(String email) {
        cliente.setEmail(email);
    }

    @Override
    public String getDireccion() {
        return cliente.getDireccion();
    }

    @Override
    public void setDireccion(String direccion) {
        cliente.setDireccion(direccion);
    }

}
