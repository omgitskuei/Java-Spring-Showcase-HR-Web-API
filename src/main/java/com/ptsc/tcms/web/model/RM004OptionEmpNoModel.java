package com.ptsc.tcms.web.model;

import lombok.Data;

@Data
public class RM004OptionEmpNoModel {
	private String empCNam;
	private String empStat;
	private String empNo;
	
	public RM004OptionEmpNoModel() {
		empCNam = "";
		empStat = "";
		empNo = "";
	}
}
