package com.spr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.spr.dto.PoliceEmployee;
import com.spr.dto.User;

@Repository
public class PoliceEmployeeDaoImple implements PoliceEmployeeDao {
	
	@Autowired
	private JdbcTemplate jt;	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
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
		
		String sql = "select emp_id,emp_name,emp_desig,emp_mob,emp_email,emp_dob,ps_id, ps_emp.role_id,m_role.role_desc from ps_emp left join m_role on ps_emp.role_id = m_role.role_id where ps_id = ?";
						
		List<PoliceEmployee> policeEmpList = jt.query(sql, new Object[] {ps_id}, new RowMapper<PoliceEmployee>()
				{

					@Override
					public PoliceEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {				
						PoliceEmployee ps = new PoliceEmployee();
						ps.setEmp_id(rs.getInt("emp_id"));
						ps.setEmp_mob(rs.getLong("emp_mob"));
						ps.setEmp_desig(rs.getString("emp_desig"));
						ps.setEmp_name(rs.getString("emp_name"));
						ps.setEmp_dob(rs.getDate("emp_dob"));
						ps.setEmp_email(rs.getString("emp_email"));
						ps.setPs_id(rs.getInt("ps_id"));
						ps.setRole_id(rs.getInt("role_id"));
						ps.setRole_desc(rs.getString("role_desc"));
						return ps;
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
	public List<PoliceEmployee> getRole_desc(int id) {
		
		String sql = "select emp_id,emp_name,emp_desig,emp_mob,emp_email,emp_dob,ps_id, ps_emp.role_id,m_role.role_desc from ps_emp left join m_role on ps_emp.role_id = m_role.role_id where ps_id = ?";
		
		List<PoliceEmployee> descList = jt.query(sql,new Object[] {id}, new RowMapper<PoliceEmployee>() {

			@Override
			public PoliceEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
				PoliceEmployee ps = new PoliceEmployee();
				ps.setEmp_id(rs.getInt("emp_id"));
				ps.setEmp_mob(rs.getLong("emp_mob"));
				ps.setEmp_desig(rs.getString("emp_desig"));
				ps.setEmp_name(rs.getString("emp_name"));
				ps.setEmp_dob(rs.getDate("emp_dob"));
				ps.setEmp_email(rs.getString("emp_email"));
				ps.setPs_id(rs.getInt("ps_id"));
				ps.setRole_id(rs.getInt("role_id"));
				ps.setRole_desc(rs.getString("role_desc"));
				return ps;
			}
		});
		
		return descList;
	}

//	ADMIN DOWNWARD
	@Override
	public int getCount(int roleId, int psId) {
		
		System.out.println("ROLE ID AND PSID -->>"+roleId +" "+ psId);
		
		String sql = "select count(role_id) from ps_emp where ps_id = ? and role_id = ?";
		
		int rolePresent = jt.queryForObject(sql, new Object[] {psId ,roleId},new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				int i = rs.getInt("count(role_id)");
				System.out.println("COUNT IS -->> " + i);
				return i;
			}
		});

		if(rolePresent == 1)
		{
			System.out.println("Returning True");
			return 1;
		}
		else if(rolePresent == 0)
		{	
			System.out.println("Returning ELSE");
			return 0;
		}
		
		return 0;
		
	}

	@Override
	public void setAdminNull(int roleId) {
		String s = null;
		String sql = "update ps_emp set role_id = ? where role_id = ?" ;
		int i = jt.update(sql,s,roleId);
		System.out.println("QUERY -- >> ?? " + i);
		
	}

	@Override
	public void setNewAdmin(int roleId, int empId) {
		
		int i = 55;
		String sql = "update ps_emp set role_id = ? where emp_id = ?";
		
		int update = jt.update(sql,i,empId);
		
	}

	@Override
	public int getRoleId(int psId) {
		
		String sql = "select role_id from ps_emp where ps_id = ? and role_id = ?"; 
		int i = 55;
		int rolePresent;
		try {
			rolePresent = jt.queryForObject(sql, new Object[] {psId,i},new RowMapper<Integer>() {

				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					int i = rs.getInt("role_id");
					System.out.println("ROLE ID -->> "+i);
					return i;
				}
			}); 

		} catch (Exception e) {
			rolePresent = 0;
		}
				
		return rolePresent;
	}


	
//	FEO DOWNWARD
	
	@Override
	public void setNullFeo(int roleId) {
		String s = null;
		String sql = "update ps_emp set role_id = ? where role_id = ?" ;
		int i = jt.update(sql,s,roleId);
		System.out.println("QUERY -- >> ?? " + i);
		
	}


	@Override
	public void setNewFeo(int roleId, int empId) {
		// TODO Auto-generated method stub
		int i = 66;
		String sql = "update ps_emp set role_id = ? where emp_id = ?";
		
		int update = jt.update(sql,i,empId);
	}


	@Override
	public int getRoleIdFeo(int psId) {
		String sql = "select role_id from ps_emp where ps_id = ? and role_id = ?"; 
		int i = 66;
		int rolePresent;
		try {
			rolePresent = jt.queryForObject(sql, new Object[] {psId,i},new RowMapper<Integer>() {

				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					int i = rs.getInt("role_id");
					System.out.println("ROLE ID -->> "+i);
					return i;
				}
			}); 

		} catch (Exception e) {
			rolePresent = 0;
		}
				
		return rolePresent;
	}
	
	
	
}
