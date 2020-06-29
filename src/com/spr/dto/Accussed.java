package com.spr.dto;

public class Accussed {

	private int accId;
	private String accName;
	private String accSex;
	private String accDob;
	private String accAdd;
	private int crimeType;
	private String crimeDate;
	private int status;
	public int getAccId() {
		
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getAccSex() {
		return accSex;
	}
	public void setAccSex(String accSex) {
		this.accSex = accSex;
	}
	public String getAccDob() {
		return accDob;
	}
	public void setAccDob(String accDob) {
		this.accDob = accDob;
	}
	public String getAccAdd() {
		return accAdd;
	}
	public void setAccAdd(String accAdd) {
		this.accAdd = accAdd;
	}
	public int getCrimeType() {
		return crimeType;
	}
	public void setCrimeType(int crimeType) {
		this.crimeType = crimeType;
	}
	public String getCrimeDate() {
		return crimeDate;
	}
	public void setCrimeDate(String crimeDate) {
		this.crimeDate = crimeDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String remark;
}
