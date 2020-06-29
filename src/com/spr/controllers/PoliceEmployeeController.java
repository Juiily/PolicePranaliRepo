package com.spr.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spr.dto.PoliceEmployee;
import com.spr.service.PoliceEmployeeService;

@Controller
public class PoliceEmployeeController {

	@Autowired
	public PoliceEmployeeService policeEmpServ;

	public void setPoliceEmpServ(PoliceEmployeeService policeEmpServ) {
		this.policeEmpServ = policeEmpServ;
	}

	//PoliceStationList
	//--------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/poList",method = RequestMethod.POST)
	public ModelAndView listOfPoliceEmp(@RequestParam int  id) {

		//int id1=Integer.parseInt(id);

		ModelAndView model=new ModelAndView();
//
//		List<PoliceEmployee> poEmpList = policeEmpServ.policeList(id1);
//		model.addObject("poEmpList", poEmpList);
//		model.setViewName("m_admin_home");
//		
		
		List<PoliceEmployee> descList = policeEmpServ.getRole_desc(id);
		model.addObject("descList", descList);
		model.setViewName("m_admin_home");
		
		return model ;
	}

	//PoliceEmployeeList
	//---------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "assignAdmin", method = RequestMethod.POST)
	public ModelAndView assignSubAdmin(@RequestParam int empId,@RequestParam int psId,@RequestParam int roleId,HttpSession session)
	{
		ModelAndView model = new ModelAndView();
		
		int i = policeEmpServ.getRoleId(psId);
		
		if(i == 55 )
		{
			System.out.println("Inside IF ,if 55");
			policeEmpServ.setAdminNull(i);
			policeEmpServ.setNewAdmin(55,empId);
		}
		
		else if(i == 0) 
		{	
			//i = policeEmpServ.getCount(roleId, psId);
			System.out.println("INSIDE IF");	
			policeEmpServ.setNewAdmin(roleId,empId);
		}
			model.setViewName("m_admin_home");
		return model;

	}

	//Assign FEO
	//---------------------------------------------------------------------------------------------------------------	
	@RequestMapping(value = "assignAdmin1", method = RequestMethod.POST)
	public ModelAndView assignFEO1(@RequestParam int empId,@RequestParam int psId,@RequestParam int roleId,HttpSession session,@RequestParam String userEmail)
	{
		ModelAndView model = new ModelAndView();
		
		int i = policeEmpServ.getRoleIdFeo(psId);
		
		if(i == 66 )
		{
			System.out.println("Inside IF ,if 66");
			policeEmpServ.setNullFeo(i);
			policeEmpServ.setNewFeo(66, empId);
		}
		
		else if(i == 0) 
		{	
			//i = policeEmpServ.getCount(roleId, psId);
			System.out.println("INSIDE IF");	
			policeEmpServ.setNewFeo(roleId, empId);
		}
			model.setViewName("s_admin_home");
			
		return model;
		
		
		
		
		/*
		 * int id1 = Integer.parseInt(id); int roleId1 = Integer.parseInt(roleId);
		 * 
		 * int getRoleId = policeEmpServ.getRoleIdOfSubAdmin(userEmail);
		 * 
		 * 
		 * ModelAndView model = new ModelAndView();
		 * 
		 * if(getRoleId==55) { if(roleId1 == 0 ) { roleId1 = 66;
		 * policeEmpServ.setPsAdmin(id1, roleId1); }
		 * 
		 * else if(roleId1 == 66) { String roleId2 = null;
		 * policeEmpServ.removePsAdmin(id1,roleId2); } }
		 * model.setViewName("s_admin_home"); return model;
		 */	}
	
	//Police SubAdmin Role Assignment
	//---------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "deleteAdmin", method = RequestMethod.POST)
	public ModelAndView removeSubAdmin(@RequestParam String id,@RequestParam String roleId,HttpSession session)
	{
		int id1 = Integer.parseInt(id);
		int roleId1 = Integer.parseInt(roleId);
		
		ModelAndView model = new ModelAndView();

		if(roleId1 == 0)
		{
			roleId1 = 55;
			policeEmpServ.setPsAdmin(id1, roleId1);
		}

		else if(roleId1 == 55)
		{	
			String roleId2 = null;
			policeEmpServ.removePsAdmin(id1,roleId2);
		}
		model.setViewName("m_admin_home");
		return model;

	}	

	//Remove FEO
	//---------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "deleteAdmin1", method = RequestMethod.POST)
	public ModelAndView removeFEO1(@RequestParam String id,@RequestParam String roleId,HttpSession session)
	{
		int id1 = Integer.parseInt(id);
		int roleId1 = Integer.parseInt(roleId);
		
		ModelAndView model = new ModelAndView();

		if(roleId1 == 0 )
		{
			roleId1 = 66;
			policeEmpServ.setPsAdmin(id1, roleId1);
		}

		else if(roleId1 == 66)
		{	
			String roleId2 = null;
			policeEmpServ.removePsAdmin(id1,roleId2);
		}
		model.setViewName("s_admin_home");
		return model;

	}	

	//Employee's for Police SubAdmin
	//---------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "psEmpListForSubAdmin",method = RequestMethod.POST)
	public ModelAndView displayListToSubAdmin(ModelAndView model,@RequestParam String userEmail) {
		System.out.println("inside controller");
		int gotId = policeEmpServ.getSubAdminPsId(userEmail);

		List<PoliceEmployee> policeList = policeEmpServ.policeEmpList(gotId);
		System.out.println(policeList);
		model.addObject("policeList", policeList);
		model.setViewName("s_admin_home");

		
		
		return model;
	}

}

