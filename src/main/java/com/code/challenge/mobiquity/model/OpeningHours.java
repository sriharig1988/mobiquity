/**
 * 
 */
package com.code.challenge.mobiquity.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author SRIHARI
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpeningHours {

	private int dayOfWeek;
	private List<Hours> hours;

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<Hours> getHours() {
		return hours;
	}

	public void setHours(List<Hours> hours) {
		this.hours = hours;
	}

}
