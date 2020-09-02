package com.ptsc.tcms.web.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class RM004QueryResultsTableModel {

	private ArrayList<RM004TableRowModel> tableRows;
	
	public RM004QueryResultsTableModel() {
		tableRows = new ArrayList<RM004TableRowModel>();
	}
}
