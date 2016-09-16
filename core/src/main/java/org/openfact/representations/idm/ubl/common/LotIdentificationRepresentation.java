package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class LotIdentificationRepresentation {
    private String lotNumberID;
    private LocalDate expiryDate;
    private List<ItemPropertyRepresentation> additionalItemProperty;
    private String id;
}
