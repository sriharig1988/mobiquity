/**
 * 
 */
package com.code.challenge.mobiquity.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.challenge.mobiquity.model.ATMDetails;
import com.code.challenge.mobiquity.model.Details;
import com.code.challenge.mobiquity.service.ATMService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author SRIHARI
 *
 */

@RestController
@RequestMapping(path = "/atm")
public class ATMController {

	private static final Logger log = LoggerFactory.getLogger(ATMController.class);

	@Autowired
	private ATMService atmService;

	@GetMapping(path = "/allAtms", produces = "application/json")
	public Details getAllATMs() throws JsonMappingException, JsonProcessingException {
		log.info("inside the ATMController ");
		return atmService.getAllATMDetails();

	}

	@GetMapping(path = "/findBy", produces = "application/json")
	public List<ATMDetails> getATMsByCity(@RequestParam("city") String city)
			throws JsonMappingException, JsonProcessingException {
		log.info("inside the ATMController search city:{}", city);
		Details atmDetails = atmService.getAllATMDetails();
		List<ATMDetails> filterList = atmDetails.getDetails().stream()
				.filter(x -> x.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
		log.debug(" filterList size :{}", filterList.size());
		return filterList;
	}

}
