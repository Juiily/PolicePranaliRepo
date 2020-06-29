package com.spr.dao;

import java.util.List;


import com.spr.dto.PoliceEmployee;

public interface PoliceEmployeeDao {
	
	List<PoliceEmployee> policeList(int ps_id);
	
	void setPsAdmin(int emp_id,int role_id);
	
	void removePsAdmin(int emp_id,String role_id);
	
	List<PoliceEmployee> policeEmpList(int ps_id);
	
	int getSubAdminPsId(String userEmail);
	
	int getRoleIdOfSubAdmin(String userEmail); 
	
	List<PoliceEmployee> getRole_desc(int id);
	
	int getCount(int roleId,int psId);
	
	void setAdminNull(int roleId);
	
	void setNewAdmin(int roleId,int empId);
	
	int getRoleId(int psId);
	
	void setNullFeo(int roleId);
	
	void setNewFeo(int roleId,int empId);
	
	int getRoleIdFeo(int psId);
}
