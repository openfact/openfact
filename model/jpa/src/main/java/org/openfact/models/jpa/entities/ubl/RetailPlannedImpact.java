package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a planned effect of a retail event (e.g., a promotion or
 * a change in inventory policy) upon supply or demand.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:35 a. m.
 */
public class RetailPlannedImpact {

    /**
     * Estimated monetary value of the planned event as an impact
     */
    private BigDecimal Amount;
    /**
     * It will have impact on either Sales forecast or Order Forecast
     */
    private String ForecastPurposeCode;
    /**
     * A code signifying the type of forecast. Examples of values are: BASE
     * PROMOTIONAL SEASONAL TOTAL
     */
    private String ForecastTypeCode;
    private List<Period> periods = new ArrayList<>();

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return Amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    /**
     * @return the forecastPurposeCode
     */
    public String getForecastPurposeCode() {
        return ForecastPurposeCode;
    }

    /**
     * @param forecastPurposeCode
     *            the forecastPurposeCode to set
     */
    public void setForecastPurposeCode(String forecastPurposeCode) {
        ForecastPurposeCode = forecastPurposeCode;
    }

    /**
     * @return the forecastTypeCode
     */
    public String getForecastTypeCode() {
        return ForecastTypeCode;
    }

    /**
     * @param forecastTypeCode
     *            the forecastTypeCode to set
     */
    public void setForecastTypeCode(String forecastTypeCode) {
        ForecastTypeCode = forecastTypeCode;
    }

    /**
     * @return the periods
     */
    public List<Period> getPeriods() {
        return periods;
    }

    /**
     * @param periods
     *            the periods to set
     */
    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

}// end Retail Planned Impact