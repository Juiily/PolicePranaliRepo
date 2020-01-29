package com.spr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spr.dto.PoliceEmployee;
import com.spr.dto.User;

@Repository
public class UserDaoImple implements UserDao{

	@Autowired
	public JdbcTemplate jt ;
	
	@Override
	public User Login(User user) {
		
		String sql1 = "select emp_id from ps_emp where emp_email = ?";
		
		User user1 = jt.queryForObject(sql1, new Object[] {user.getUserEmail()},new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				User user = new User();
				
				user.setEmpId(rs.getInt(1));
				
				return user; 
			}
			
		});
		System.out.println("Email->> " +user.getUserEmail());
		String sql2 = "select role_id from user_role where emp_id = ?";
		
		User user2 = jt.queryForObject(sql2, new Object[] {user1.getEmpId()}, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				User user = new User();
				user.setRole_id(rs.getInt(1));
				
				return user;
			}
		});
		System.out.println("EMP ID ->> " +user1.getEmpId());
		System.out.println("USERNAME ->> " +user.getUserPassword());
		System.out.println("EMAIL ->> " +user.getUserEmail());
		String sql3 = "select*from user where user_password = ? and user_email = ? ";
		
		try {				
				int i = user2.getRole_id();
				User user3 = jt.queryForObject(sql3,new Object[] { user.getUserPassword(),user.getUserEmail()}, new RowMapper<User>(){
	
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						
					User user = new User();
					user.setUserPassword(rs.getString("user_password"));
					user.setUserEmail(rs.getString("user_email"));	
					
					return user;
					}			
				});
				
				user3.setRole_id(i);
				
				System.out.println(user3.getRole_id()+" "+user3.getUserEmail()+" "+user3.getUserPassword());
				
				if(user3 != null)
				{
					return user3;
				}
			
			} 
		
		catch (Exception e) 
			{
				return null;
			}
		return null;
	}

	@Override
	public PoliceEmployee getUserName(String userEmail) {
		System.out.println("getUserName -- >> "+userEmail);
		
		String sql4 = "select emp_id from user where user_email = ?";
		
		User user3 = jt.queryForObject(sql4, new Object[] {userEmail}, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setEmpId(rs.getInt("emp_id"));
				return user;
			}
			
		});
		
		String sql5 = "select emp_name from ps_emp where emp_id=?";
		
		PoliceEmployee policeEmp = jt.queryForObject(sql5, new Object[] {user3.getEmpId()},new RowMapper<PoliceEmployee>() {

			@Override
			public PoliceEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {

				PoliceEmployee policeEmpName = new PoliceEmployee();
				
				policeEmpName.setEmp_name(rs.getString("emp_name"));
				
				return policeEmpName;
			}
			
		});
		
		return policeEmp;
	}

	
}
