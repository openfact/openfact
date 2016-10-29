package org.openfact.models.ubl.common.pe;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.openfact.models.ubl.common.ExchangeRateModel;

public interface RetentionInformationModel {
	String getId();

	BigDecimal getSunatRetentionAmount();

	void setSunatRetentionAmount(BigDecimal sunatRetentionAmount);

	LocalDateTime getSunatRetentionDate();

	void setSunatRetentionDate(LocalDateTime sunatRetentionDate);

	BigDecimal getSunatNetTotalPaid();

	void setSunatNetTotalPaid(BigDecimal sunatNetTotalPaid);

	ExchangeRateModel getExchangeRate();

	void setExchangeRate(ExchangeRateModel exchangeRate);

}
