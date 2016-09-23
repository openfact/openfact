package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PeriodEntity;
import org.openfact.models.jpa.entities.ubl.common.PriceListEntity;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.PriceListModel;

public class PriceListAdapter implements PriceListModel, JpaModel<PriceListEntity> {

    protected static final Logger logger = Logger.getLogger(PriceListAdapter.class);
    protected PriceListEntity priceList;
    protected EntityManager em;
    protected OpenfactSession session;

    public PriceListAdapter(OpenfactSession session, EntityManager em, PriceListEntity priceList) {
        this.session = session;
        this.em = em;
        this.priceList = priceList;
    }

    @Override
    public String getID() {
        return this.priceList.getID();
    }

    @Override
    public void setID(String value) {
        this.priceList.setID(value);
    }

    @Override
    public String getStatusCode() {
        return this.priceList.getStatusCode();
    }

    @Override
    public void setStatusCode(String value) {
        this.priceList.setStatusCode(value);
    }

    @Override
    public List<PeriodModel> getValidityPeriod() {
        return priceList.getValidityPeriod().stream().map(f -> new PeriodAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setValidityPeriod(List<PeriodModel> validityPeriod) {
        List<PeriodEntity> entities = validityPeriod.stream().map(f -> PeriodAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        this.priceList.setValidityPeriod(entities);
    }

    @Override
    public PriceListModel getPreviousPriceList() {
        return new PriceListAdapter(session, em, priceList.getPreviousPriceList());
    }

    @Override
    public void setPreviousPriceList(PriceListModel value) {
        this.priceList.setPreviousPriceList(PriceListAdapter.toEntity(value, em));
    }

    public static PriceListEntity toEntity(PriceListModel model, EntityManager em) {
        if (model instanceof PriceListModel) {
            return ((PriceListAdapter) model).getEntity();
        }
        return em.getReference(PriceListEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return this.priceList.getId();
    }

    @Override
    public void setId(String value) {
        this.priceList.setId(value);
    }

    @Override
    public PriceListEntity getEntity() {
        // TODO Auto-generated method stub
        return priceList;
    }

}
