package com.spr.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spr.dto.Accussed;
import com.spr.dto.VictimFir;
import com.spr.service.AccussedService;
import com.spr.service.VictimFirService;

@Controller
public class VictimFirController {

	@Autowired
	private VictimFirService vfs ;

	public void setVfs(VictimFirService vfs) {
		this.vfs = vfs;
	}
	
	@RequestMapping(value = "/FirForm" , method = RequestMethod.POST)
	public String saveRecord(@ModelAttribute("FirForm") VictimFir f)
	{
		new ModelAndView();
		 vfs.insertData(f);
		return "FirRegistrationForm";
	}
	
	/**************FIR DETAILS LIST WITH STATUS 0 ****************/
	@RequestMapping(value = "/newFirForm",method = RequestMethod.POST)
	public ModelAndView showFirList()
	{
		
		List<VictimFir> vf = vfs.showVictFir();
		ModelAndView model =  new ModelAndView();
		model.addObject("newFir", vf);
		model.setViewName("FirNewForm");
		return model ;
	}
	
	
	/****************Fir Officer Assign Display********************/
	
	@RequestMapping(value = "/FirPoliceAssign",method=RequestMethod.POST)
	public ModelAndView firAssignOfficer(@RequestParam("firId") int fId)
	{
		//int fId=Integer.parseInt(firId);
		ModelAndView model=new ModelAndView();
		List<VictimFir> firv = vfs.firAssignOfficer(fId);
		System.out.println("HELLO CHEATINYA I WANT FUCK ");
		System.out.println("CONTROLLER DATA"+firv);
		model.getModelMap().addAttribute("listVicF",firv);
		model.setViewName("FirPoliceAssignForm");
		
		
		return model;
		
	}
	
	@RequestMapping(value = "/assignedEmp",method =RequestMethod.POST)
	public String firUpdateEmp(@ModelAttribute("aEmp") VictimFir vf)
	{
		 vfs.assignEmpFir(vf); 
		return "FirNewForm";
		
	}
	
	
	/****************Accussed Form Entrty********************/
	
	
	@Autowired
	private AccussedService accService;
	public void setAccService(AccussedService accService) {
		this.accService = accService;
	}

	//accussed form----------------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping(value ="/Acc-form", method = RequestMethod.POST)
	public String accForm(@ModelAttribute("accForm") Accussed acc)
	{
		System.out.println("kirveeeeeeeeeeeeeee");
		accService.accForm(acc);
		return "AccusedForm";
	}
	
	
	
}
