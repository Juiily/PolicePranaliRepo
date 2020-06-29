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
	public List<PoliceEmployee> getRole_desc(int id) {
		
		return policeEmpDao.getRole_desc(id);
	}

	@Override
	public int getCount(int roleId, int psId) {
		
		return policeEmpDao.getCount(roleId, psId);
	}

	@Override
	public void setAdminNull(int roleId) {
		policeEmpDao.setAdminNull(roleId);
	}

	@Override
	public void setNewAdmin(int roleId, int empId) {
		policeEmpDao.setNewAdmin(roleId, empId);
	}

	@Override
	public int getRoleId(int psId) {
		return policeEmpDao.getRoleId(psId);
	}

	@Override
	public void setNullFeo(int roleId) {
		// TODO Auto-generated method stub
		policeEmpDao.setNullFeo(roleId);
	}

	@Override
	public void setNewFeo(int roleId, int empId) {
		// TODO Auto-generated method stub
		policeEmpDao.setNewFeo(roleId, empId);
	}

	@Override
	public int getRoleIdFeo(int psId) {
		// TODO Auto-generated method stub
		return policeEmpDao.getRoleIdFeo(psId);
	}
	
	
}
