/**
 * 
 */
package com.code.challenge.mobiquity.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.code.challenge.mobiquity.dao.ATMDetailsDao;
import com.code.challenge.mobiquity.model.Details;

/**
 * @author SRIHARI
 *
 */
public class ATMServiceImpl implements ATMService {

	@Autowired
	private ATMDetailsDao atmDetailsDao;

	@Override
	public Details getAllATMDetails() {
		return atmDetailsDao.findAll();
	}

}
