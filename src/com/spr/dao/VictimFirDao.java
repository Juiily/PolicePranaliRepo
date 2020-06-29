package com.spr.dao;

import java.util.List;

import com.spr.dto.VictimFir;

public interface VictimFirDao {

	void insertData(VictimFir vf);
	List<VictimFir> showVictFir();
	
	List<VictimFir> firAssignOfficer(int fId);
	
	void assignEmpFir(VictimFir v);
}
