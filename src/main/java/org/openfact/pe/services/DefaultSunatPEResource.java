package org.openfact.pe.services;

import org.openfact.pe.idm.SunatGenericTypePERepresentation;
import org.openfact.core.types.TipoAfectacionIgv;
import org.openfact.core.types.TipoDocumentoEntidad;
import org.openfact.core.types.TipoInvoice;
import org.openfact.pe.SunatPEResource;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DefaultSunatPEResource implements SunatPEResource {

    @Override
    public List<SunatGenericTypePERepresentation> getTiposInvoice() {
        List<SunatGenericTypePERepresentation> result = new ArrayList<>();
        for (TipoInvoice type : TipoInvoice.values()) {
            SunatGenericTypePERepresentation rep = new SunatGenericTypePERepresentation();
            rep.setCodigo(type.getCodigo());
            rep.setDenominacion(type.getDenominacion());
            rep.setAbreviatura(type.getAbreviatura());

            result.add(rep);
        }
        return result;
    }

    @Override
    public List<SunatGenericTypePERepresentation> getTiposDocumentoIdentidad() {
        List<SunatGenericTypePERepresentation> result = new ArrayList<>();
        for (TipoDocumentoEntidad type : TipoDocumentoEntidad.values()) {
            SunatGenericTypePERepresentation rep = new SunatGenericTypePERepresentation();
            rep.setCodigo(type.getCodigo());
            rep.setAbreviatura(type.getAbreviatura());
            rep.setDenominacion(type.getDenominacion());
            rep.setLength(type.getLength());

            result.add(rep);
        }
        return result;
    }

    @Override
    public List<SunatGenericTypePERepresentation> getTipoAfectacionIgv() {
        List<SunatGenericTypePERepresentation> result = new ArrayList<>();
        for (TipoAfectacionIgv type : TipoAfectacionIgv.values()) {
            SunatGenericTypePERepresentation rep = new SunatGenericTypePERepresentation();
            rep.setCodigo(type.getCodigo());
            rep.setDenominacion(type.getDenominacion());
            rep.setAfectaIGV(type.getAfectaIgv());
            rep.setGrupo(type.getGrupo().getDenominacion());

            result.add(rep);
        }
        return result;
    }

    @Override
    public SunatGenericTypePERepresentation getIgv() {
        SunatGenericTypePERepresentation rep = new SunatGenericTypePERepresentation();
        rep.setDenominacion("Impuesto General a las Ventas");
        rep.setAbreviatura("igv");
        rep.setValor(new Double("0.18"));
        return rep;
    }

}
