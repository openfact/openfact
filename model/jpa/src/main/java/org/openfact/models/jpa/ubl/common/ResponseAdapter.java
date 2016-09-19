package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class ResponseAdapter implements ResponseModel, JpaModel<ResponseEntity> {

    protected static final Logger logger = Logger.getLogger(ResponseAdapter.class);
    protected ResponseEntity response;
    protected EntityManager em;
    protected OpenfactSession session;

    public ResponseAdapter(OpenfactSession session, EntityManager em, ResponseEntity response) {
        this.session = session;
        this.em = em;
        this.response = response;
    }

    String getReferenceID() {
        return this.response.getReferenceID();
    }

    void setReferenceID(String value) {
        this.response.setReferenceID(value);
    }

    String getResponseCode() {
        return this.response.getResponseCode();
    }

    void setResponseCode(String value) {
        this.response.setResponseCode(value);
    }

    List<String> getDescription() {
        return this.response.getDescription();
    }

    void setDescription(List<String> description) {
        this.response.setDescription(description);
    }

    String getId() {
        return this.response.getId();
    }

    void setId(String value) {
        this.response.setId(value);
    }

}
