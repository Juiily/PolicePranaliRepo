package com.spr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.dao.PoliceEmployeeDao;
import com.spr.dto.PoliceEmployee;

@Service
public class PoliceEmployeeServiceImple implements PoliceEmployeeService {

	@Autowired
	PoliceEmployeeDao policeEmpDao; 
	public void setPoliceEmpDao(PoliceEmployeeDao policeEmpDao) {
		this.policeEmpDao = policeEmpDao;
	}

	@Override
	public List<PoliceEmployee> policeList(int ps_id) {
		return policeEmpDao.policeList(ps_id);
	}

	@Override
	public void setPsAdmin(int emp_id, int role_id) {
		policeEmpDao.setPsAdmin(emp_id, role_id);
	}

	@Override
	public void removePsAdmin(int emp_id,String role_id) {
		policeEmpDao.removePsAdmin(emp_id,role_id);
	}

	@Override
	public List<PoliceEmployee> policeEmpList(int ps_id) {
		return policeEmpDao.policeEmpList(ps_id);
	}

	@Override
	public int getSubAdminPsId(String userName) {
		return policeEmpDao.getSubAdminPsId(userName);
	}

	@Override
	public int getRoleIdOfSubAdmin(String userEmail) {
		return policeEmpDao.getRoleIdOfSubAdmin(userEmail);
	}

	@Override
	public String getRole_desc(int role_id) {
		return policeEmpDao.getRole_desc(role_id);
	}
	
	
}
