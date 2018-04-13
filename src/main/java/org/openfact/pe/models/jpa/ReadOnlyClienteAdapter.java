package org.openfact.pe.models.jpa;

import org.openfact.pe.models.jpa.entities.ClienteEntity;
import org.openfact.pe.models.types.TipoDocumentoEntidad;

public class ReadOnlyClienteAdapter extends ClienteAdapter {

    public ReadOnlyClienteAdapter(ClienteEntity cliente) {
        super(cliente);
    }

    @Override
    public void setNombre(String nombre) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setNumeroDocumento(String numeroDocumento) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setTipoDocumento(TipoDocumentoEntidad tipoDocumento) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setDireccion(String direccion) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setEmail(String email) {
        ReadOnlyUtils.throwException();
    }

}
