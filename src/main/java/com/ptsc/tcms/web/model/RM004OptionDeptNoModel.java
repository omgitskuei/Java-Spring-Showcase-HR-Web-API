package com.ptsc.tcms.web.model;

import lombok.Data;

@Data
public class RM004OptionDeptNoModel {
	private String itemNo;
	private String itemNam;
	
	public RM004OptionDeptNoModel() {
		itemNo = "";
		itemNam = "";
	}
}
