package com.spr.service;

import java.util.List;

import com.spr.dto.VictimFir;

public interface VictimFirService {
	void insertData(VictimFir vf);
	List<VictimFir> showVictFir();
	List<VictimFir> firAssignOfficer(int fId);
	void assignEmpFir(VictimFir v);
}
