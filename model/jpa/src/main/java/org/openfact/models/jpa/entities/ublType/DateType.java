package org.openfact.models.jpa.entities.ublType;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

/**
 * Created by lxpary on 08/09/16.
 */
public class DateType {
    protected LocalDate value;

    public LocalDate getValue() {
        return value;
    }

    public void setValue(LocalDate value) {
        this.value = value;
    }
}
