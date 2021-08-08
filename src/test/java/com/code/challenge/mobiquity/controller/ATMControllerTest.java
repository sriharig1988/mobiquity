package com.code.challenge.mobiquity.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.code.challenge.mobiquity.model.ATMDetails;
import com.code.challenge.mobiquity.model.Address;
import com.code.challenge.mobiquity.model.Details;
import com.code.challenge.mobiquity.service.ATMService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RunWith(SpringRunner.class)
@SpringBootTest
class ATMControllerTest {

	@Autowired
	private ATMController atmController;

	@MockBean
	private ATMService atmService;

	@Test
	void testGetAllATMs() throws JsonMappingException, JsonProcessingException {

		Mockito.when(atmService.getAllATMDetails()).thenReturn(mockDetails());
		Details details = atmController.getAllATMs();
		assertNotNull(details);
		assertNotNull(details.getDetails());
		assertTrue(details.getDetails().size() > 0);
		assertEquals("GELDMAAT", details.getDetails().get(0).getType());
	}

	@Test
	void testGetATMsByCity() throws JsonMappingException, JsonProcessingException {
		Mockito.when(atmService.getAllATMDetails()).thenReturn(mockDetails());
		List<ATMDetails> atmDetails = atmController.getATMsByCity("MAASTRICHT");

		assertNotNull(atmDetails);
		assertTrue(atmDetails.size() > 0);
		assertNotNull(atmDetails.get(0).getAddress());
		assertEquals("MAASTRICHT", atmDetails.get(0).getAddress().getCity());
	}

	private Details mockDetails() {
		Details detailsMock = new Details();
		ATMDetails atmdetails = new ATMDetails();
		Address address = new Address();
		address.setCity("MAASTRICHT");
		address.setStreet("AMBYERSTRAAT NOORD");
		address.setHouseNumber("33");
		atmdetails.setAddress(address);
		atmdetails.setType("GELDMAAT");
		List<ATMDetails> atmDetailsList = new ArrayList<>();
		atmDetailsList.add(atmdetails);
		detailsMock.setDetails(atmDetailsList);
		return detailsMock;
	}

}
