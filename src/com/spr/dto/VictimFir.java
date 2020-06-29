package com.spr.dto;

import java.util.Date;

public class VictimFir {

	private int vId;
	private String vName;
	private String vGender;
	private String vAdd;
	private Long vMob ;
	private String vEmail ;
	private int firId;
	private int crimeType;
	private String crimeDate ;
	private String crimeLoc;
	private String remark;
	
	
	@Override
	public String toString() {
		return "VictimFir [vId=" + vId + ", vName=" + vName + ", vGender=" + vGender + ", vAdd=" + vAdd + ", vMob="
				+ vMob + ", vEmail=" + vEmail + ", firId=" + firId + ", crimeType=" + crimeType + ", crimeDate="
				+ crimeDate + ", crimeLoc=" + crimeLoc + ", remark=" + remark + ", status=" + status + ", empId="
				+ empId + ", crimeDesc=" + crimeDesc + ", psId=" + psId + "]";
	}
	private int status;
	private int empId;
	private String crimeDesc;
	private int psId;
	
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getvId() {
		return vId;
	}
	public String getCrimeDesc() {
		return crimeDesc;
	}
	public void setCrimeDesc(String crimeDesc) {
		this.crimeDesc = crimeDesc;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvGender() {
		return vGender;
	}
	public void setvGender(String vGender) {
		this.vGender = vGender;
	}
	public String getvAdd() {
		return vAdd;
	}
	public void setvAdd(String vAdd) {
		this.vAdd = vAdd;
	}
	public Long getvMob() {
		return vMob;
	}
	public void setvMob(Long vMob) {
		this.vMob = vMob;
	}
	public String getvEmail() {
		return vEmail;
	}
	public void setvEmail(String vEmail) {
		this.vEmail = vEmail;
	}
	public int getFirId() {
		return firId;
	}
	public void setFirId(int firId) {
		this.firId = firId;
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
	public String getCrimeLoc() {
		return crimeLoc;
	}
	public void setCrimeLoc(String crimeLoc) {
		this.crimeLoc = crimeLoc;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getPsId() {
		return psId;
	}
	public void setPsId(int psId) {
		this.psId = psId;
	}
	
	
	
	
}
