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
public class Details {

	List<ATMDetails> details;

	public List<ATMDetails> getDetails() {
		return details;
	}

	public void setDetails(List<ATMDetails> details) {
		this.details = details;
	}

}
