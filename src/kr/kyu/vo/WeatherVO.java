
package kr.kyu.vo;

import org.codehaus.jackson.annotate.JsonProperty;

public class WeatherVO {

	@JsonProperty("ForecastWarningUltrafineParticleOfDustService")
    private ForecastWarningUltrafineParticleOfDustService ForecastWarningUltrafineParticleOfDustService;

	/**
	 * @return the forecastWarningUltrafineParticleOfDustService
	 */
	public ForecastWarningUltrafineParticleOfDustService getForecastWarningUltrafineParticleOfDustService() {
		return ForecastWarningUltrafineParticleOfDustService;
	}

	/**
	 * @param forecastWarningUltrafineParticleOfDustService the forecastWarningUltrafineParticleOfDustService to set
	 */
	public void setForecastWarningUltrafineParticleOfDustService(ForecastWarningUltrafineParticleOfDustService forecastWarningUltrafineParticleOfDustService) {
		ForecastWarningUltrafineParticleOfDustService = forecastWarningUltrafineParticleOfDustService;
	}
}
