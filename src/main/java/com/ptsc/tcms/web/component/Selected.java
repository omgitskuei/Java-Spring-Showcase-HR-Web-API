package com.ptsc.tcms.web.component;

import lombok.Data;

@Data
public class Selected {
	String deptNo;
//	private String secNo;
//	private String empNo;
//	private String prjNo;
	
	public Selected() {
		this.deptNo = "";
//		this.secNo = "";
//		this.empNo = "";
//		this.prjNo = "";
	}
}
