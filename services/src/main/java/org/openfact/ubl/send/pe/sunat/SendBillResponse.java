
package org.openfact.ubl.send.pe.sunat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Clase Java para sendBillResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="sendBillResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applicationResponse" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendBillResponse", propOrder = {
    "applicationResponse"
})
public class SendBillResponse
    implements Equals, ToString
{

    protected byte[] applicationResponse;

    /**
     * Obtiene el valor de la propiedad applicationResponse.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getApplicationResponse() {
        return applicationResponse;
    }

    /**
     * Define el valor de la propiedad applicationResponse.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setApplicationResponse(byte[] value) {
        this.applicationResponse = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SendBillResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SendBillResponse that = ((SendBillResponse) object);
        {
            byte[] lhsApplicationResponse;
            lhsApplicationResponse = this.getApplicationResponse();
            byte[] rhsApplicationResponse;
            rhsApplicationResponse = that.getApplicationResponse();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "applicationResponse", lhsApplicationResponse), LocatorUtils.property(thatLocator, "applicationResponse", rhsApplicationResponse), lhsApplicationResponse, rhsApplicationResponse)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            byte[] theApplicationResponse;
            theApplicationResponse = this.getApplicationResponse();
            strategy.appendField(locator, this, "applicationResponse", buffer, theApplicationResponse);
        }
        return buffer;
    }

}
