package org.openfact.models.jpa.entities.ublType;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalTime;

/**
 * Created by lxpary on 08/09/16.
 */
public class TimeType {
    protected LocalTime value;

    public LocalTime getValue() {
        return value;
    }

    public void setValue(LocalTime value) {
        this.value = value;
    }
}
