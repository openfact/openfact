package org.openfact.models.ubl.common.pe;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.openfact.models.ubl.common.ExchangeRateModel;

public interface PerceptionInformationModel {
	String getId();

	BigDecimal getSunatPerceptionAmount();

	void setSunatPerceptionAmount(BigDecimal sunatPerceptionAmount);

	LocalDateTime getSunatPerceptionDate();

	void setSunatPerceptionDate(LocalDateTime sunatPerceptionDate);

	BigDecimal getSunatNetTotalPaid();

	void setSunatNetTotalPaid(BigDecimal sunatNetTotalPaid);

	ExchangeRateModel getExchangeRate();

	void setExchangeRate(ExchangeRateModel exchangeRate);
}
