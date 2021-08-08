/**
 * 
 */
package com.code.challenge.mobiquity.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.code.challenge.mobiquity.model.Details;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ATMDetailsDaoTest {

	@Autowired
	ATMDetailsDao atmDetailsDao;

	@MockBean
	private RestTemplate restTemplate;

	@Test
	public void findAllTest() {
		String formatted = ")]}',[{\"address\":{\"street\":\"Dr. Plesmanlaan\",\"housenumber\":\"162A\",\"postalcode\":\"3601 DE\",\"city\":\"Maarssen\",\"geoLocation\":{\"lat\":\"52.143335\",\"lng\":\"5.045388\"}},\"distance\":0,\"openingHours\":[{\"dayOfWeek\":2,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":3,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":4,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":5,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":6,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":7,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":1,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]}],\"functionality\":\"Geldautomaat\",\"type\":\"GELDMAAT\"},{\"address\":{\"street\":\"Dalipassage\",\"housenumber\":\"59\",\"postalcode\":\"7811 DA\",\"city\":\"Emmen\",\"geoLocation\":{\"lat\":\"52.78185\",\"lng\":\"6.894098\"}},\"distance\":0,\"openingHours\":[{\"dayOfWeek\":2,\"hours\":[]},{\"dayOfWeek\":3,\"hours\":[]},{\"dayOfWeek\":4,\"hours\":[]},{\"dayOfWeek\":5,\"hours\":[]},{\"dayOfWeek\":6,\"hours\":[]},{\"dayOfWeek\":7,\"hours\":[]},{\"dayOfWeek\":1,\"hours\":[]}],\"functionality\":\"Geld storten en opnemen\",\"type\":\"GELDMAAT\"}]}";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<?> responseEntity = new ResponseEntity<>(formatted, header, HttpStatus.OK);
		Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.any()))
				.thenReturn((ResponseEntity<Object>) responseEntity);
		Details details = atmDetailsDao.findAll();
		assertNotNull(details);
		assertNotNull(details.getDetails());
		assertTrue(details.getDetails().size() > 0);

	}

}
