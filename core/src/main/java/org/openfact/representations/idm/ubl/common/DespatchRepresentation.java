package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class DespatchRepresentation {
    private String ID;
    private LocalDate RequestedDespatchDate;
    private LocalTime RequestedDespatchTime;
    private LocalDate EstimatedDespatchDate;
    private LocalTime EstimatedDespatchTime;
    private LocalDate ActualDespatchDate;
    private LocalTime ActualDespatchTime;
    private AddressRepresentation DespatchAddress;
    private PartyRepresentation DespatchParty;
    private ContactRepresentation Contact;
    private String Id;
}