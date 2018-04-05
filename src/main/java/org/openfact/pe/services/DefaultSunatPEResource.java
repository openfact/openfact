package org.openfact.pe.services;

import org.openfact.pe.SunatPEResource;
import org.openfact.pe.idm.SUNATGenericTypeRepresentation;
import org.openfact.pe.models.types.TipoAfectacionIgv;
import org.openfact.pe.models.types.TipoDocumentoEntidad;
import org.openfact.pe.models.types.TipoInvoice;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DefaultSunatPEResource implements SunatPEResource {

    @Override
    public List<SUNATGenericTypeRepresentation> getTiposInvoice() {
        List<SUNATGenericTypeRepresentation> result = new ArrayList<>();
        for (TipoInvoice type : TipoInvoice.values()) {
            SUNATGenericTypeRepresentation rep = new SUNATGenericTypeRepresentation();
            rep.setCodigo(type.getCodigo());
            rep.setDenominacion(type.getDenominacion());
            rep.setAbreviatura(type.getAbreviatura());

            result.add(rep);
        }
        return result;
    }

    @Override
    public List<SUNATGenericTypeRepresentation> getTiposDocumentoIdentidad() {
        List<SUNATGenericTypeRepresentation> result = new ArrayList<>();
        for (TipoDocumentoEntidad type : TipoDocumentoEntidad.values()) {
            SUNATGenericTypeRepresentation rep = new SUNATGenericTypeRepresentation();
            rep.setCodigo(type.getCodigo());
            rep.setAbreviatura(type.getAbreviatura());
            rep.setDenominacion(type.getDenominacion());
            rep.setLength(type.getLength());

            result.add(rep);
        }
        return result;
    }

    @Override
    public List<SUNATGenericTypeRepresentation> getTipoAfectacionIgv() {
        List<SUNATGenericTypeRepresentation> result = new ArrayList<>();
        for (TipoAfectacionIgv type : TipoAfectacionIgv.values()) {
            SUNATGenericTypeRepresentation rep = new SUNATGenericTypeRepresentation();
            rep.setCodigo(type.getCodigo());
            rep.setDenominacion(type.getDenominacion());
            rep.setAfectaIGV(type.getAfectaIgv());
            rep.setGrupo(type.getGrupo().getDenominacion());

            result.add(rep);
        }
        return result;
    }

    @Override
    public SUNATGenericTypeRepresentation getIgv() {
        SUNATGenericTypeRepresentation rep = new SUNATGenericTypeRepresentation();
        rep.setDenominacion("Impuesto General a las Ventas");
        rep.setAbreviatura("igv");
        rep.setValor(new Double("0.18"));
        return rep;
    }

}
