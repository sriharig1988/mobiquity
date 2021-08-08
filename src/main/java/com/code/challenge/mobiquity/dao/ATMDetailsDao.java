/**
 * 
 */
package com.code.challenge.mobiquity.dao;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.code.challenge.mobiquity.model.Details;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author SRIHARI
 *
 */

@Component
public class ATMDetailsDao {

	private static final Logger log = LoggerFactory.getLogger(ATMDetailsDao.class);

	@Autowired
	RestTemplate restTemplate;

	public Details findAll() {
		try {
			log.info("inside the ATMDetailsDao -> findAll() ");
			ResponseEntity<String> response = restTemplate.getForEntity("https://www.ing.nl/api/locator/atms/",
					String.class);
			String fmtStr=response.getBody().replace(")]}',", "{\"details\":");
			String formattedResponse = fmtStr.substring(0,
					fmtStr.lastIndexOf("]")) + "]}";
			ObjectMapper objectMapper = new ObjectMapper();
			log.debug("formattedResponse:{} ", formattedResponse);
			Details details= objectMapper.readValue(formattedResponse, Details.class);
			log.debug("Details  :{}", details);
			return details;
		} catch (IOException e) {
			log.error("Failed to fetch records  :{}", e.getMessage());
		}
		return null;
	}

}
