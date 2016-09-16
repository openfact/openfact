package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class LotIdentificationModel {
    protected String LotNumberID;
    protected LocalDate ExpiryDate;
    protected List<ItemPropertyModel> AdditionalItemProperty;
    protected String Id;
}