package com.ptsc.tcms.web.service;

import java.util.HashMap;

import org.springframework.ui.Model;

import com.ptsc.tcms.web.component.DropdownSelect;
import com.ptsc.tcms.web.model.RM004QueryResultsTableModel;

public interface RM004Service {
	
	public DropdownSelect initDataSelectDeptNo();
	
	public DropdownSelect initDataSelectSecNo(String deptNo);

	public DropdownSelect initDataSelectEmpNo(String deptNoParam, String secNoParam);
	
	public DropdownSelect initDataSelectPrjNo();
	
	public RM004QueryResultsTableModel queryBtnQryTcDataStaView(HashMap<String, Object> queryParams);

	
}
