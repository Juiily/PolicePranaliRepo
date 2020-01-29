package com.spr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spr.dto.PoliceEmployee;
import com.spr.dto.User;

@Repository
public class PoliceEmployeeDaoImple implements PoliceEmployeeDao {
	
	@Autowired
	private JdbcTemplate jt;	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	
	public List<PoliceEmployee> policeList(int ps_id) {
		
		String sql = "select*from ps_emp where ps_id = ?"; 
		
//		POLICE EMPLOYEE LIST FOR MAIN ADMIN
		List<PoliceEmployee> poEmpList = 
				jt.query(sql, new Object[]{ps_id}, new RowMapper<PoliceEmployee>() 
				{

					@Override
					public PoliceEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						PoliceEmployee poEmp= new PoliceEmployee();
						
						 poEmp.setEmp_id(rs.getInt("emp_id"));
				            poEmp.setEmp_mob(rs.getLong("emp_mob"));
				            poEmp.setEmp_desig(rs.getString("emp_desig"));
				            poEmp.setEmp_name(rs.getString("emp_name"));
				            poEmp.setEmp_dob(rs.getDate("emp_dob"));
				            poEmp.setEmp_email(rs.getString("emp_email"));
				            poEmp.setPs_id(rs.getInt("ps_id"));
				            poEmp.setRole_id(rs.getInt("role_id"));
						
				           System.out.println(poEmp);
						return poEmp;
					}
					
				});
				
		return poEmpList;
	}

	@Override
	public void setPsAdmin(int emp_id,int role_id) {
		
		String sql = "update ps_emp set role_id = ? where emp_id = ?";
		jt.update(sql, role_id,emp_id);
	}

	@Override
	public void removePsAdmin(int emp_id,String role_id) {
		
		String sql = "update ps_emp set role_id = ? where emp_id = ?";
		jt.update(sql, role_id,emp_id);
	}

	@Override
	public List<PoliceEmployee> policeEmpList(int ps_id) {
		
		String sql = "select*from ps_emp where ps_id = ? ";
						
		List<PoliceEmployee> policeEmpList = jt.query(sql, new Object[] {ps_id}, new RowMapper<PoliceEmployee>()
				{

					@Override
					public PoliceEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
						PoliceEmployee psEmp = new PoliceEmployee();
						
							psEmp.setEmp_id(rs.getInt(1));
						
							psEmp.setEmp_id(rs.getInt("emp_id"));
							psEmp.setEmp_mob(rs.getLong("emp_mob"));
							psEmp.setEmp_desig(rs.getString("emp_desig"));
							psEmp.setEmp_name(rs.getString("emp_name"));
							psEmp.setEmp_dob(rs.getDate("emp_dob"));
							psEmp.setEmp_email(rs.getString("emp_email"));
							psEmp.setPs_id(rs.getInt("ps_id"));
							psEmp.setRole_id(rs.getInt("role_id"));
							
						return psEmp;
				}
			});
		
		return policeEmpList;
	}

	@Override
	public int getSubAdminPsId(String userEmail) {

		String sql = "select emp_id from user where user_email = ?";
		
		PoliceEmployee policeEmp = jt.queryForObject(sql, new Object[] {userEmail},new RowMapper<PoliceEmployee>() {

			@Override
			public PoliceEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				PoliceEmployee pemp = new PoliceEmployee();
				
				pemp.setEmp_id(rs.getInt("emp_id"));
				return pemp;
			}
		});
		
		String sql1 = "select ps_id from ps_emp where emp_id = ?";
		
		PoliceEmployee policeEmp1 = jt.queryForObject(sql1, new Object[] {policeEmp.getEmp_id()}, new RowMapper<PoliceEmployee>() {

			@Override
			public PoliceEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				PoliceEmployee polEmp = new PoliceEmployee();
				
				polEmp.setPs_id(rs.getInt("ps_id"));
				
				return polEmp;
			}
		});
				
		int psId = policeEmp1.getPs_id();
		System.out.println("PoliceStationId --> "+psId);
		
		return psId;
		
	}
	


	@Override
	public int getRoleIdOfSubAdmin(String userEmail) {
		
		String sql = "select role_id from user where user_email = ?";
		
		User user1 = jt.queryForObject(sql, new Object[] {userEmail},new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				User user = new User(); 
				
				user.setRole_id(rs.getInt("role_id"));
				
				return user;
			}
			
		});
		
		int roleIdOfAdmin = user1.getRole_id();
		
		return roleIdOfAdmin;
	}


	@Override
	public String getRole_desc(int role_id) {

		String sql = "select role_desc from m_role where role_id = ? ";
		
		PoliceEmployee policeEmp2 = jt.queryForObject(sql, new Object[] {role_id}, new RowMapper<PoliceEmployee>() {

			@Override
			public PoliceEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				PoliceEmployee policeEmp = new PoliceEmployee();
				policeEmp.setRole_desc(rs.getString("role_desc"));
				return policeEmp;
			}
		});
		
		String role_desc = policeEmp2.getRole_desc();
		
		return role_desc;
	}

	
}
