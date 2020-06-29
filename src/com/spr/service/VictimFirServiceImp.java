package com.spr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.dao.VictimFirDao;
import com.spr.dto.VictimFir;
@Service
public class VictimFirServiceImp implements VictimFirService {

	@Autowired
	private VictimFirDao vd ;
	
	
	public void setVd(VictimFirDao vd) {
		this.vd = vd;
	}



	@Override
	public void insertData(VictimFir vf) {
		// TODO Auto-generated method stub
	
		vd.insertData(vf);
	}



	@Override
	public List<VictimFir> showVictFir() {
		
		return vd.showVictFir();
	}



	@Override
	public List<VictimFir> firAssignOfficer(int fId) {
		
		List<VictimFir> firDetails=vd.firAssignOfficer(fId);
		
		return firDetails;
	}



	@Override
	public void assignEmpFir(VictimFir v) {
		// TODO Auto-generated method stub
		vd.assignEmpFir(v);
	}


}

	

