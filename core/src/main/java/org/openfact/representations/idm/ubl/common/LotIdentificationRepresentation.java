package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class LotIdentificationRepresentation {
    private String LotNumberID;
    private LocalDate ExpiryDate;
    private List<ItemPropertyRepresentation> AdditionalItemProperty;
    private String Id;
}