package com.ptsc.tcms.web.model;

import lombok.Data;

@Data
public class RM004OptionPrjNoModel {
	private String prjNo;
	private String prjNam;
	
	public RM004OptionPrjNoModel() {
		prjNo = "";
		prjNam = "";
	}
}
