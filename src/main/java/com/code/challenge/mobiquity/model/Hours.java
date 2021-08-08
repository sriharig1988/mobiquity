/**
 * 
 */
package com.code.challenge.mobiquity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author SRIHARI
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hours {

	private String hourFrom;
	private String hourTo;

	public String getHourFrom() {
		return hourFrom;
	}

	public void setHourFrom(String hourFrom) {
		this.hourFrom = hourFrom;
	}

	public String getHourTo() {
		return hourTo;
	}

	public void setHourTo(String hourTo) {
		this.hourTo = hourTo;
	}

}
