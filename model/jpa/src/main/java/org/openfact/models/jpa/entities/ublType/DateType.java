package org.openfact.models.jpa.entities.ublType;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by lxpary on 08/09/16.
 */
public class DateType {
    protected XMLGregorianCalendar value;

    public XMLGregorianCalendar getValue() {
        return value;
    }

    public void setValue(XMLGregorianCalendar value) {
        this.value = value;
    }
}
