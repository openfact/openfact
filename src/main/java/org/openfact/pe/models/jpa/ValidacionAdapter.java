package org.openfact.pe.models.jpa;

import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.ErrorModel;
import org.openfact.pe.models.ErrorType;
import org.openfact.pe.models.ValidacionModel;
import org.openfact.pe.models.jpa.entities.ErrorEntity;
import org.openfact.pe.models.jpa.entities.ValidacionEntity;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class ValidacionAdapter implements ValidacionModel {

    private final EntityManager em;
    private final ValidacionEntity validacion;

    public ValidacionAdapter(EntityManager em, ValidacionEntity validacion) {
        this.em = em;
        this.validacion = validacion;
    }

    @Override
    public String getId() {
        return validacion.getId();
    }

    @Override
    public boolean getEstado() {
        return validacion.isEstado();
    }

    @Override
    public void setEstado(boolean estado) {
        validacion.setEstado(estado);
        em.merge(validacion); // Si no se hace merge, el estado nunca se actualiza
    }

    @Override
    public List<ErrorModel> getErrores() {
        return validacion.getErrores().stream()
                .map(ErrorAdapter::new)
                .collect(Collectors.toList());
    }

    @Override
    public ErrorModel addError(ErrorType tipo, String descripcion) {
        ErrorEntity entity = new ErrorEntity();
        entity.setId(ModelUtils.generateId());
        entity.setTipo(tipo);
        entity.setDescripcion(descripcion);
        entity.setValidacion(validacion);

        em.persist(entity);

        return new ErrorAdapter(entity);
    }
}
