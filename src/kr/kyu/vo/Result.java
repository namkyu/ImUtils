/*
 * @(#)Result.java	2015. 12. 23
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

public class Result {

    @JsonProperty("CODE")
    private String CODE;
    @JsonProperty("MESSAGE")
    private String MESSAGE;
	/**
	 * @return the cODE
	 */
	public String getCODE() {
		return CODE;
	}
	/**
	 * @param cODE the cODE to set
	 */
	public void setCODE(String cODE) {
		CODE = cODE;
	}
	/**
	 * @return the mESSAGE
	 */
	public String getMESSAGE() {
		return MESSAGE;
	}
	/**
	 * @param mESSAGE the mESSAGE to set
	 */
	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}


}
