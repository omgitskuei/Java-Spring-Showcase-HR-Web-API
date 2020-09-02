package com.ptsc.tcms.web.model;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ptsc.tcms.web.component.DropdownSelect;

import lombok.Data;

@Component
@Data
public class RM004Model {
	
	private DropdownSelect deptNoSelect;
	private DropdownSelect secNoSelect;
	private DropdownSelect empNoSelect;
	private boolean retiredEmp;
	private String oprStartDt;
	private String oprEndDt;
	private DropdownSelect prjNoSelect;
	private RM004QueryResultsTableModel table;
	
	public RM004Model() {
		deptNoSelect = new DropdownSelect();
		secNoSelect = new DropdownSelect();
		empNoSelect = new DropdownSelect();
		retiredEmp = true;
		oprStartDt = "";
		oprEndDt = "";
		prjNoSelect = new DropdownSelect();
		table = new RM004QueryResultsTableModel();
	}
}
