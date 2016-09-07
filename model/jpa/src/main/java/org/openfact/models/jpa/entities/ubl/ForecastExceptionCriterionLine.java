package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * Establishes the criterion for one of the three types of exceptions. This
 * class provides criteria for the kind of forecast exception, the
 * identification of the purpose of the forecast, the source of data and the
 * time basis criterion for the exception.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:18 a. m.
 */
public class ForecastExceptionCriterionLine {

    /**
     * If it is a forecast comparison exception, this value indicates the other
     * source of information.
     */
    private String comparisonDataSourceCode;
    /**
     * Indication of the partner who provides the information.
     */
    private String dataSourceCode;
    /**
     * A description of the purpose for the forecast that is assigned to each
     * forecast data item exception criterion.
     */
    private String forecastPurposeCode;
    /**
     * A description of a Forecast selected from a list.
     */
    private String forecastTypeCode;
    /**
     * Time basis in days for the Exception.
     */
    private BigDecimal TimeDeltaDaysQuantity;

    public ForecastExceptionCriterionLine() {

    }

    public void finalize() throws Throwable {

    }

    public String getComparisonDataSourceCode() {
        return comparisonDataSourceCode;
    }

    public void setComparisonDataSourceCode(String comparisonDataSourceCode) {
        this.comparisonDataSourceCode = comparisonDataSourceCode;
    }

    public String getDataSourceCode() {
        return dataSourceCode;
    }

    public void setDataSourceCode(String dataSourceCode) {
        this.dataSourceCode = dataSourceCode;
    }

    public String getForecastPurposeCode() {
        return forecastPurposeCode;
    }

    public void setForecastPurposeCode(String forecastPurposeCode) {
        this.forecastPurposeCode = forecastPurposeCode;
    }

    public String getForecastTypeCode() {
        return forecastTypeCode;
    }

    public void setForecastTypeCode(String forecastTypeCode) {
        this.forecastTypeCode = forecastTypeCode;
    }

    public BigDecimal getTimeDeltaDaysQuantity() {
        return TimeDeltaDaysQuantity;
    }

    public void setTimeDeltaDaysQuantity(BigDecimal timeDeltaDaysQuantity) {
        TimeDeltaDaysQuantity = timeDeltaDaysQuantity;
    }
}// end Forecast Exception Criterion Line