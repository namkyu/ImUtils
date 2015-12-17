/*
 * @(#)Row.java	2015. 12. 17
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

public class Row {

    @JsonProperty("APPLC_DT")
    private String APPLCDT;
    @JsonProperty("FA_ON")
    private String FAON;
    @JsonProperty("POLLUTANT")
    private String POLLUTANT;
    @JsonProperty("CAISTEP")
    private String CAISTEP;
    @JsonProperty("ALARM_CNDT")
    private String ALARMCNDT;
    @JsonProperty("ALERTSTEP")
    private String ALERTSTEP;
    @JsonProperty("CNDT1")
    private String CNDT1;
	/**
	 * @return the aPPLCDT
	 */
	public String getAPPLCDT() {
		return APPLCDT;
	}
	/**
	 * @param aPPLCDT the aPPLCDT to set
	 */
	public void setAPPLCDT(String aPPLCDT) {
		APPLCDT = aPPLCDT;
	}
	/**
	 * @return the fAON
	 */
	public String getFAON() {
		return FAON;
	}
	/**
	 * @param fAON the fAON to set
	 */
	public void setFAON(String fAON) {
		FAON = fAON;
	}
	/**
	 * @return the pOLLUTANT
	 */
	public String getPOLLUTANT() {
		return POLLUTANT;
	}
	/**
	 * @param pOLLUTANT the pOLLUTANT to set
	 */
	public void setPOLLUTANT(String pOLLUTANT) {
		POLLUTANT = pOLLUTANT;
	}
	/**
	 * @return the cAISTEP
	 */
	public String getCAISTEP() {
		return CAISTEP;
	}
	/**
	 * @param cAISTEP the cAISTEP to set
	 */
	public void setCAISTEP(String cAISTEP) {
		CAISTEP = cAISTEP;
	}
	/**
	 * @return the aLARMCNDT
	 */
	public String getALARMCNDT() {
		return ALARMCNDT;
	}
	/**
	 * @param aLARMCNDT the aLARMCNDT to set
	 */
	public void setALARMCNDT(String aLARMCNDT) {
		ALARMCNDT = aLARMCNDT;
	}
	/**
	 * @return the aLERTSTEP
	 */
	public String getALERTSTEP() {
		return ALERTSTEP;
	}
	/**
	 * @param aLERTSTEP the aLERTSTEP to set
	 */
	public void setALERTSTEP(String aLERTSTEP) {
		ALERTSTEP = aLERTSTEP;
	}
	/**
	 * @return the cNDT1
	 */
	public String getCNDT1() {
		return CNDT1;
	}
	/**
	 * @param cNDT1 the cNDT1 to set
	 */
	public void setCNDT1(String cNDT1) {
		CNDT1 = cNDT1;
	}


}
