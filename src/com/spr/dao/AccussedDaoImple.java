package com.spr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spr.dto.Accussed;

@Repository
public class AccussedDaoImple implements AccussedDao {

	@Autowired
	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public void accForm(Accussed accussed) {
		
		String sql="insert into accussed values(?,?,?,?,?,?,?,?,?)";
		
		int i=jt.update(sql, new Object[] {0,accussed.getAccName(),accussed.getAccSex(),accussed.getAccDob(),accussed.getAccAdd(),accussed.getCrimeType(),accussed.getCrimeDate(),accussed.getStatus(),accussed.getRemark()});
		
		

	}

}
