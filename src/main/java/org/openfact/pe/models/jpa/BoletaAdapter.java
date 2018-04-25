package org.openfact.pe.models.jpa;

import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.DatosVentaModel;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.ResumenDiarioModel;
import org.openfact.pe.models.jpa.entities.BoletaEntity;
import org.openfact.pe.models.jpa.entities.InvoiceEntity;
import org.openfact.pe.models.jpa.entities.ResumenDiarioEntity;

import javax.persistence.EntityManager;
import java.util.Optional;

public class BoletaAdapter extends AbstractInvoiceAdapter implements BoletaModel {

    private final BoletaEntity boleta;

    public BoletaAdapter(EntityManager em, BoletaEntity boleta) {
        super(em, boleta);
        this.boleta = boleta;
    }

    @Override
    public Optional<ResumenDiarioModel> getResumenDiario() {
        ResumenDiarioEntity resumenDiario = boleta.getResumenDiario();
        if (resumenDiario == null) return Optional.empty();
        return Optional.of(new ResumenDiarioAdapter(resumenDiario));
    }

    @Override
    public InvoiceEntity getEntity() {
        return boleta;
    }

}
