/*
 * @(#)WeatherVO.java	2015. 12. 17
 *
 * Copyright(c) 2009 namkyu.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by namkyu.
 */

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
