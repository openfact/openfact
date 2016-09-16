package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class DespatchModel {
    protected String ID;
    protected LocalDate RequestedDespatchDate;
    protected LocalTime RequestedDespatchTime;
    protected LocalDate EstimatedDespatchDate;
    protected LocalTime EstimatedDespatchTime;
    protected LocalDate ActualDespatchDate;
    protected LocalTime ActualDespatchTime;
    protected AddressModel DespatchAddress;
    protected PartyModel DespatchParty;
    protected ContactModel Contact;
    protected String Id;
}