package com.spr.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spr.dto.PoliceEmployee;
import com.spr.dto.User;
import com.spr.service.UserService;

@Controller
public class LoginController {

	@Autowired
	public UserService userServ;

	@GetMapping
	public String dispLogin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginSuccess(@RequestParam("userEmail") String userEmail,
			@RequestParam("userPassword") String userPassword, HttpSession session) {
		ModelAndView model = new ModelAndView();

		User user1 = new User();

		user1.setUserPassword(userPassword);
		user1.setUserEmail(userEmail);

		try {
			
				User user2 = userServ.Login(user1);
				
				PoliceEmployee policeUsername = userServ.getUserName(userEmail);
				String userName = policeUsername.getEmp_name();
				
				if(user2!=null)
				{
					if(user2.getUserEmail()!=null || user2.getUserPassword() != null)
					{	
						
							if(user2.getRole_id()==44)
							{
								System.out.println("INSSIDE IF LOOOOP");
								session.setAttribute("userName",userName);
								session.setAttribute("userEmail", user2.getUserEmail());
								System.out.println("Inside m_role");
								System.out.println(session.getAttribute("userName"));
								model.setViewName("m_admin_home");
							}
							else if(user2.getRole_id()==55)
							{
								model.setViewName("s_admin_home");
								session.setAttribute("userEmail", user2.getUserEmail());
								session.setAttribute("userName",userName);
							}
							else
							{
								model.setViewName("fir_userHome");
								session.setAttribute("userName",userName);
								session.setAttribute("userEmail", user2.getUserEmail());
								System.out.println("Inside normal user");
								System.out.println(session.getAttribute("userName"));
							}
					}
					
				}
				
				

			} catch (Exception e) {
				
				if (userPassword == null | userEmail == null) {
					model.addObject("msg", "Invalid User Entry");
					model.setViewName("login");
				}
			}

			return model;

		}

	}
