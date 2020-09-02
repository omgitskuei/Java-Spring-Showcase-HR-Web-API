package com.ptsc.tcms.web.model;

import lombok.Data;

@Data
public class RM004OptionSecNoModel {
	private String itemNo;
	private String itemNam;
	
	public RM004OptionSecNoModel() {
		itemNo = "";
		itemNam = "";
	}
}
