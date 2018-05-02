package org.openfact.pe.models.utils;

import org.openfact.pe.models.*;
import org.openfact.pe.representations.idm.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

public class RepresentationToModel {

    private RepresentationToModel() {
        // just
    }

    public static void modelToRepresentation(OrganizacionInformacionAdicionalModel model, OrganizacionInformacionAdicionalRepresentation rep) {
        if (rep.getAssignedId() != null) {
            model.setAssignedId(rep.getAssignedId());
        }
        if (rep.getAdditionalAssignedId() != null) {
            model.setAdditionalAssignedId(rep.getAdditionalAssignedId());
        }
        if (rep.getRazonSocial() != null) {
            model.setRazonSocial(rep.getRazonSocial());
        }
        if (rep.getNombreComercial() != null) {
            model.setNombreComercial(rep.getNombreComercial());
        }
        if (rep.getRegion() != null) {
            model.setRegion(rep.getRegion());
        }
        if (rep.getProvincia() != null) {
            model.setProvincia(rep.getProvincia());
        }
        if (rep.getDistrito() != null) {
            model.setDistrito(rep.getDistrito());
        }
        if (rep.getCodigoPostal() != null) {
            model.setCodigoPostal(rep.getCodigoPostal());
        }
        if (rep.getDireccion() != null) {
            model.setDireccion(rep.getDireccion());
        }
    }

    public static void modelToRepresentation(OrganizacionInformacionSunatModel model, OrganizacionInformacionSunatRepresentation rep) {
        if (rep.getUseCustomConfig() != null) {
            model.setUseCustomConfig(rep.getUseCustomConfig());
        }
        if (rep.getUsuario() != null) {
            model.setUsuario(rep.getUsuario());
        }
        if (rep.getPassword() != null) {
            model.setPassword(rep.getPassword());
        }
        if (rep.getBoletaFacturaEndpoint() != null) {
            model.setBoletaFacturaEndpoint(rep.getBoletaFacturaEndpoint());
        }
        if (rep.getGuiaRemisionEndpoint() != null) {
            model.setGuiaRemisionEndpoint(rep.getGuiaRemisionEndpoint());
        }
        if (rep.getRetencionPercepcionEndpoint() != null) {
            model.setRetencionPercepcionEndpoint(rep.getRetencionPercepcionEndpoint());
        }
        if (rep.getConsultaFacturaEndpoint() != null) {
            model.setConsultaFacturaEndpoint(rep.getConsultaFacturaEndpoint());
        }
        if (rep.getConsultaCdrEndpoint() != null) {
            model.setConsultaCdrEndpoint(rep.getConsultaCdrEndpoint());
        }
    }

    public static void modelToRepresentation(InvoiceModel model, InvoiceRepresentation rep) {
        if (rep.getEnviarSunat() != null) {
            model.setEnviarSunat(rep.getEnviarSunat());
        }
        if (rep.getEnviarCliente() != null) {
            model.setEnviarCliente(rep.getEnviarCliente());
        }

        toModel(model.getDatosVenta(), rep);
    }

    public static void modelToRepresentation(NotaModel model, NotaRepresentation rep) {
        if (rep.getEnviarSunat() != null) {
            model.setEnviarSunat(rep.getEnviarSunat());
        }
        if (rep.getEnviarCliente() != null) {
            model.setEnviarCliente(rep.getEnviarCliente());
        }

        toModel(model.getDatosVenta(), rep);
    }

    public static void modelToRepresentation(BajaModel model, BajaRepresentation rep) {
        model.setMotivoBaja(rep.getMotivoBaja());

    }

    private static void toModel(DatosVentaModel model, DocumentoBaseRepresentation rep) {
        toModel(model.getFecha(), rep.getFecha());
        toModel(model.getCliente(), rep.getCliente());
        toModel(model.getTotal(), rep.getTotal());
        toModel(model.getMoneda(), rep.getMoneda());
        toModel(model.getImpuestos(), rep.getTotalImpuestos());
        toModel(model.getTotalInformacionAdicional(), rep.getTotalInformacionAdicional());

        model.setDetalle(toBean(rep.getDetalle()));
    }

    private static void toModel(FechaModel model, FechaRepresentation rep) {
        if (rep != null) {
            if (rep.getEmision() != null) {
                model.setEmision(rep.getEmision());
            }
            if (rep.getVencimiento() != null) {
                model.setVencimiento(rep.getVencimiento());
            }
        }
    }

    private static void toModel(ClienteModel model, ClienteRepresentation rep) {
        if (rep != null) {
            if (rep.getNumeroDocumento() != null) {
                model.setNumeroDocumento(rep.getNumeroDocumento());
            }
            if (rep.getTipoDocumento() != null) {
                model.setTipoDocumento(rep.getTipoDocumento());
            }
            if (rep.getNombre() != null) {
                model.setNombre(rep.getNombre());
            }
            if (rep.getEmail() != null) {
                model.setEmail(rep.getEmail());
            }
            if (rep.getDireccion() != null) {
                model.setDireccion(rep.getDireccion());
            }
        }
    }

    private static void toModel(TotalModel model, TotalRepresentation rep) {
        if (rep != null) {
            if (rep.getPagar() != null) {
                model.setTotalPagar(rep.getPagar());
            }
            if (rep.getDescuentoGlobal() != null) {
                model.setDescuentoGlobal(rep.getDescuentoGlobal());
            }
            if (rep.getOtrosCargos() != null) {
                model.setOtrosCargos(rep.getOtrosCargos());
            }
        }
    }

    private static void toModel(MonedaModel model, MonedaRepresentation rep) {
        if (rep != null) {
            if (rep.getCodigo() != null) {
                model.setMoneda(rep.getCodigo());
            }
            if (rep.getTipoCambio() != null) {
                model.setTipoCambio(rep.getTipoCambio());
            }
        }
    }

    private static void toModel(ImpuestosModel model, TotalImpuestosRepresentation rep) {
        if (rep != null) {
            if (rep.getIgv() != null) {
                model.setIgv(rep.getIgv());
            }
            if (rep.getIsc() != null) {
                model.setIsc(rep.getIsc());
            }
        }
    }

    private static void toModel(TotalInformacionAdicionalModel model, TotalInformacionAdicionalRepresentation rep) {
        if (rep != null) {
            if (rep.getTotalExonerado() != null) {
                model.setTotalExonerado(rep.getTotalExonerado());
            }
            if (rep.getTotalGratuito() != null) {
                model.setTotalGratuito(rep.getTotalGratuito());
            }
            if (rep.getTotalGravado() != null) {
                model.setTotalGravado(rep.getTotalGravado());
            }
            if (rep.getTotalInafecto() != null) {
                model.setTotalInafecto(rep.getTotalInafecto());
            }
        }
    }

    private static List<DatosVentaDetalleBean> toBean(List<ComprobanteDetalleRepresentation> detalle) {
        return detalle
                .stream()
                .map(r -> new DatosVentaDetalleBean.Builder()
                        .unidadMedida(r.getUnidadMedida())
                        .descripcion(r.getDescripcion())
                        .tipoIgv(r.getTipoIgv())
                        .cantidad(r.getCantidad())
                        .valorUnitario(r.getValorUnitario())
                        .precioUnitario(r.getPrecioUnitario())
                        .subtotal(r.getSubtotal())
                        .total(r.getTotal())
                        .totalIgv(r.getTotalIgv())
                        .totalIsc(r.getTotalIsc())
                        .build())
                .collect(Collectors.toList());
    }

}
