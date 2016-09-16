package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class DespatchRepresentation {
    private String ID;
    private LocalDate requestedDespatchDate;
    private LocalTime requestedDespatchTime;
    private LocalDate estimatedDespatchDate;
    private LocalTime estimatedDespatchTime;
    private LocalDate actualDespatchDate;
    private LocalTime actualDespatchTime;
    private AddressRepresentation despatchAddress;
    private PartyRepresentation despatchParty;
    private ContactRepresentation contact;
    private String id;
}
