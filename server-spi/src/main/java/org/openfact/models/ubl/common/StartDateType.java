package org.openfact.models.ubl.common;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

public interface StartDateType {

    XMLGregorianCalendar getValue();

    void setValue(XMLGregorianCalendar value);

    String getId();

    void setId(String value);

    Date getValueItem();

    void setValueItem(Date target);

}
