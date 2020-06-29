package com.spr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spr.dto.VictimFir;

@Repository
public class VictimFirDaoImp implements VictimFirDao {

	@Autowired
	private JdbcTemplate jt;
	
	
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}



	@Override
	public void insertData(VictimFir vf) {
		
		//String default1="default";
		
		System.out.println("victm recorded");
		
		String sql = "insert into victim values(?,?,?,?,?,?)";
		
		int i = jt.update(sql,new Object[] {0,vf.getvName(),vf.getvGender(),vf.getvAdd(),vf.getvMob(),vf.getvEmail()});
		
		
		String sql1 = "insert into ps_fir values(?,?,?,?,?,?,?,?)";
		int j = jt.update(sql1, new Object[] {0,vf.getCrimeType(),vf.getCrimeDate(),vf.getCrimeLoc(),vf.getRemark(),0,null,null});
		System.out.println("fir recorded");
		
		String sql2 = "select * from victim where vEmail=?";
		
		VictimFir f = jt.queryForObject(sql2, new Object[] {vf.getvEmail()},new RowMapper<VictimFir> () {

			@Override
			public VictimFir mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				VictimFir v = new VictimFir();
				v.setvId(rs.getInt(1));
				System.out.println("get vict id");
				
				return v;
			}
			
		});
		System.out.println("get vict id"+f.getvId());
		
		String sql3 = "select * from ps_fir order by firId desc limit 1";
		
		
		VictimFir v = jt.queryForObject(sql3, new Object[] {},new RowMapper<VictimFir> () {

			@Override
			public VictimFir mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				VictimFir v = new VictimFir();
				v.setFirId(rs.getInt(1));
				
		
				System.out.println("get vict id");
				return v;
			}
			
		});	
		System.out.println("get fir id"+v.getFirId());
		System.out.println("PRASHIK");
		String sql4= "insert into firvictim values(?,?)";
		int k= jt.update(sql4, new Object[] {v.getFirId(),f.getvId()});
		
		System.out.println("get fir vict ");
		
	}


//Fir and victim list with 0 status ---------------------------------------------------------------------------------------------------
	@Override
	public List<VictimFir> showVictFir() {
		
	/*	String sql = "SELECT firvictim.firId,victim.vName,victim.vMobile "
				+ " FROM victim INNER JOIN firvictim ON firvictim.vId = victim.vId";
		*/
		
		String sql="select * from ps_fir where status=0";
		
		
		List<VictimFir>  vicf = jt.query(sql,new RowMapper<VictimFir>() {

			@Override
			public VictimFir mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				VictimFir vf = new VictimFir();
				vf.setFirId(rs.getInt("firId"));
				if(rs.getInt("crimeType")==111)
				{
					vf.setCrimeDesc("murder");
				}
				else if(rs.getInt("crimeType")==222)
				{
					vf.setCrimeDesc("rape");
				}
				else if(rs.getInt("crimeType")==333)
				{
					vf.setCrimeDesc("robbery");
				}
				vf.setCrimeType(rs.getInt("crimeType"));
				vf.setCrimeLoc(rs.getString("crimeLoc"));
				vf.setCrimeDate(rs.getString("crimeDate"));
				return vf;
			}});
		
		return vicf;
	}
	
	//perticular fir detail list***********************************************************************
	
	public List<VictimFir> firAssignOfficer(int fId)
	{
		
		List<VictimFir> vicfList=new ArrayList<VictimFir>();
		
		System.out.println("FIR ID TEST == "+fId);
		String sql="select * from ps_fir where firId=?";
		
		//List<VictimFir> firDetail
		VictimFir vicf= jt.queryForObject(sql, new Object[] {fId}, new RowMapper<VictimFir>() {

		
			@Override
			public VictimFir mapRow(ResultSet rs, int arg1) throws SQLException {
				
				
				VictimFir vf = new VictimFir();
				vf.setFirId(rs.getInt("firId"));
				vf.setCrimeType(rs.getInt("crimeType"));
				vf.setCrimeDate(rs.getString("crimeDate"));
				vf.setCrimeLoc(rs.getString("crimeLoc"));
				vf.setRemark(rs.getString("remark"));
				vf.setStatus(rs.getInt("status"));
				vf.setEmpId(rs.getInt("empId"));
				vf.setPsId(rs.getInt("ps_id"));
				
				return vf;
				
				
			}
			
			
		});
		
		vicfList.add(vicf);
	System.out.println(vicfList);
		
		String sql2="select * from firvictim where firId=?";
		
		VictimFir vFir=jt.queryForObject(sql2,new Object[] {fId},new RowMapper<VictimFir>() {

			@Override
			public VictimFir mapRow(ResultSet rs, int arg1) throws SQLException {
				System.out.println("FIR VICTIM");
				VictimFir vf2=new VictimFir();
				vf2.setvId(rs.getInt("vId"));
				
				return vf2;
			}
			
			
		});
		
		int vId=vFir.getvId();
		
		System.out.println("VICTIM ID =================="+vId);
		
		
		String sql3="select * from victim where vId=?";
		
		VictimFir victimDetails = jt.queryForObject(sql3, new Object[] {vId},new RowMapper<VictimFir>() {

			@Override
			public VictimFir mapRow(ResultSet rs, int arg1) throws SQLException {
				
				VictimFir vf = new VictimFir();
				vf.setvId(rs.getInt("vId"));
				vf.setvName(rs.getString("vName"));
				vf.setvGender(rs.getString("vGender"));
				vf.setvAdd(rs.getString("vAddress"));
				vf.setvMob(rs.getLong("vMobile"));
				vf.setvEmail(rs.getString("vEmail"));
				
				return vf;
			}
			
		});
		
		vicfList.add(victimDetails);
		System.out.println("COMPLETE DATA =================\n"+vicfList);
		
		return vicfList;
		
		
	}



	@Override
	public void assignEmpFir(VictimFir v) {
		
		String sql = "update ps_fir set empId=? where firId=?";
		
		int vic = jt.update(sql,new Object[] {v.getEmpId(),v.getFirId()});
		
	}





}
