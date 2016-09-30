package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.ConditionCatalogModel;
import org.openfact.models.catalog.ResponseCreditNoteCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.ConditionCatalogEntity;
import org.openfact.models.jpa.entities.catalog.ResponseCreditNoteCatalogEntity;

public class ResponseCreditNoteCatalogAdapter  implements ResponseCreditNoteCatalogModel, JpaModel<ResponseCreditNoteCatalogEntity>{
	protected static final Logger logger = Logger.getLogger(ResponseCreditNoteCatalogAdapter.class);
	protected ResponseCreditNoteCatalogEntity responseCreditNoteCatalog;
	protected EntityManager em;
	protected OpenfactSession session;
	public ResponseCreditNoteCatalogAdapter(ResponseCreditNoteCatalogEntity responseCreditNoteCatalog, EntityManager em,
			OpenfactSession session) {
		this.responseCreditNoteCatalog = responseCreditNoteCatalog;
		this.em = em;
		this.session = session;
	}
	@Override
	public ResponseCreditNoteCatalogEntity getEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCode(String code) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public BigDecimal getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setValue(BigDecimal value) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getLocale() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setLocale(String locale) {
		// TODO Auto-generated method stub
		
	}
	
}
