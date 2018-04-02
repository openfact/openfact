package org.openfact.services;

import org.openfact.PESunatResource;
import org.openfact.representations.idm.PESunatGenericTypeRepresentation;
import org.openfact.ubl.types.TipoAfectacionIgv;
import org.openfact.ubl.types.TipoDocumentoEntidad;
import org.openfact.ubl.types.TipoInvoice;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DefaultPESunatResource implements PESunatResource {

    @Override
    public List<PESunatGenericTypeRepresentation> getTiposInvoice() {
        List<PESunatGenericTypeRepresentation> result = new ArrayList<>();
        for (TipoInvoice type : TipoInvoice.values()) {
            PESunatGenericTypeRepresentation rep = new PESunatGenericTypeRepresentation();
            rep.setCodigo(type.getCodigo());
            rep.setDenominacion(type.getDenominacion());
            rep.setAbreviatura(type.getAbreviatura());

            result.add(rep);
        }
        return result;
    }

    @Override
    public List<PESunatGenericTypeRepresentation> getTiposDocumentoIdentidad() {
        List<PESunatGenericTypeRepresentation> result = new ArrayList<>();
        for (TipoDocumentoEntidad type : TipoDocumentoEntidad.values()) {
            PESunatGenericTypeRepresentation rep = new PESunatGenericTypeRepresentation();
            rep.setCodigo(type.getCodigo());
            rep.setAbreviatura(type.getAbreviatura());
            rep.setDenominacion(type.getDenominacion());
            rep.setLength(type.getLength());

            result.add(rep);
        }
        return result;
    }

    @Override
    public List<PESunatGenericTypeRepresentation> getTipoAfectacionIgv() {
        List<PESunatGenericTypeRepresentation> result = new ArrayList<>();
        for (TipoAfectacionIgv type : TipoAfectacionIgv.values()) {
            PESunatGenericTypeRepresentation rep = new PESunatGenericTypeRepresentation();
            rep.setCodigo(type.getCodigo());
            rep.setDenominacion(type.getDenominacion());
            rep.setAfectaIgv(type.getAfectaIgv());
            rep.setGrupo(type.getGrupo().getDenominacion());

            result.add(rep);
        }
        return result;
    }

    @Override
    public PESunatGenericTypeRepresentation getIgv() {
        PESunatGenericTypeRepresentation rep = new PESunatGenericTypeRepresentation();
        rep.setDenominacion("Impuesto General a las Ventas");
        rep.setAbreviatura("igv");
        rep.setValor(new Double("0.18"));
        return rep;
    }

}
