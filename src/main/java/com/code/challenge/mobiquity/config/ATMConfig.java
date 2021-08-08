/**
 * 
 */
package com.code.challenge.mobiquity.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.code.challenge.mobiquity.service.ATMService;
import com.code.challenge.mobiquity.service.ATMServiceImpl;

/**
 * @author SRIHARI
 *
 */

@Configuration
public class ATMConfig {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public ATMService atmService() {
		return new ATMServiceImpl() ;
	}

}
