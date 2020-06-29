package com.spr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.dao.AccussedDao;
import com.spr.dto.Accussed;

@Service
public class AccussedServiceImple implements AccussedService {

	@Autowired
	private AccussedDao accussedDao;
	
	public void setAccussedDao(AccussedDao accussedDao) {
		this.accussedDao = accussedDao;
	}

	@Override
	public void accForm(Accussed accussed) {
		
		accussedDao.accForm(accussed);
		

	}

}
