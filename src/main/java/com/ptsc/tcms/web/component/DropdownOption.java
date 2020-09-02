package com.ptsc.tcms.web.component;

import lombok.Data;

@Data
public class DropdownOption {
	
	String optionValue;
	String optionLabel;
	String selected;

	public DropdownOption() {
		optionValue = "";
		optionLabel = "";
		selected = "";
	}
}
