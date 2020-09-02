package com.ptsc.tcms.web.model;

import lombok.Data;

@Data
public class RM004TableRowModel{
	
	private String oprDat;
	private String prjNam;
	private String salDeptNo;
	private String wkClass;
	private String itemCName;
	private String workHr;
	private String overHr;
	private String totalHr;
	private String wkNote;
	private String wkType;
	
	public RM004TableRowModel() {
		oprDat = "";
		prjNam = "";
		salDeptNo = "";
		wkClass = "";
		itemCName = "";
		workHr = "";
		overHr = "";
		totalHr = "";
		wkNote = "";
		wkType = "";
	}
	
}
