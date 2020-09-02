package com.ptsc.tcms.web.component;

import java.util.ArrayList;

import lombok.Data;

@Data
public class DropdownSelect {
	
	private ArrayList<DropdownOption> dropdownList;
	private String disabled;
	
	public DropdownSelect() {
		dropdownList = new ArrayList<DropdownOption>();
		disabled = "disabled";
	}
}
