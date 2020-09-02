package com.ptsc.tcms.web.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptsc.tcms.persistence.entities.Deptdata;
import com.ptsc.tcms.persistence.entities.EmployeeView;
import com.ptsc.tcms.persistence.entities.ProjectView;
import com.ptsc.tcms.persistence.entities.TCDataStaView;
import com.ptsc.tcms.persistence.repositories.DeptDataRepo;
import com.ptsc.tcms.persistence.repositories.EmployeeViewRepo;
import com.ptsc.tcms.persistence.repositories.ProjectViewRepo;
import com.ptsc.tcms.persistence.repositories.TCDataStaViewRepo;
import com.ptsc.tcms.util.StringsUtil;
import com.ptsc.tcms.web.component.DropdownOption;
import com.ptsc.tcms.web.component.DropdownSelect;
import com.ptsc.tcms.web.model.RM004Model;
import com.ptsc.tcms.web.model.RM004OptionDeptNoModel;
import com.ptsc.tcms.web.model.RM004OptionEmpNoModel;
import com.ptsc.tcms.web.model.RM004OptionPrjNoModel;
import com.ptsc.tcms.web.model.RM004OptionSecNoModel;
import com.ptsc.tcms.web.model.RM004QueryResultsTableModel;
import com.ptsc.tcms.web.model.RM004TableRowModel;
import com.ptsc.tcms.web.service.RM004Service;

@Service
public class RM004ServiceImpl implements RM004Service{

	private DeptDataRepo deptDataRepo;
	private EmployeeViewRepo employeeViewRepo;
	private ProjectViewRepo projectViewRepo;
	private TCDataStaViewRepo tcDataStaViewRepo;
	
	@Autowired
	RM004ServiceImpl(
			DeptDataRepo deptDataRepo, 
			EmployeeViewRepo employeeViewRepo, 
			ProjectViewRepo projectViewRepo,
			TCDataStaViewRepo tcDataStaViewRepo,
			
			RM004Model model) {
		this.deptDataRepo = deptDataRepo;
		this.employeeViewRepo = employeeViewRepo;
		this.projectViewRepo = projectViewRepo;
		this.tcDataStaViewRepo = tcDataStaViewRepo;
	}
	
	/**
	 * Log
	 */
	private final static Logger log = LoggerFactory.getLogger(RM004ServiceImpl.class);
	
	/**
	 * @param n/a
	 * @author Chris
	 * @return DropdownSelect
	 */
	@Override
	public DropdownSelect initDataSelectDeptNo() {
		log.debug("RM004ServiceImpl > initDataSelectDeptNo > param: " + "void");
		
		List<Deptdata> queryResults = deptDataRepo.deptNoInitDataRM004();
		// Map DeptData entity to model (gives default values)
		List<RM004OptionDeptNoModel> allOptionModels = new ArrayList<>();
		
		String itemNo = "";
		String itemNam = "";
		for (Deptdata eachResult : queryResults) {
			RM004OptionDeptNoModel eachOptionModel = new RM004OptionDeptNoModel();
			itemNo = StringsUtil.nullEmptyToTrimString(eachResult.getItemno());
			itemNam = StringsUtil.nullEmptyToTrimString(eachResult.getItemnam());			
			eachOptionModel.setItemNo(itemNo);
			eachOptionModel.setItemNam(itemNam);
			allOptionModels.add(eachOptionModel);
		}
		// Map model to dropdownOptions (bundled together in DropdownSelect)
		DropdownSelect deptNoSelect = new DropdownSelect();
		
		
		for(RM004OptionDeptNoModel eachOptModel : allOptionModels) {
			DropdownOption deptNoOption = new DropdownOption();
			deptNoOption.setOptionValue(eachOptModel.getItemNo());
			deptNoOption.setOptionLabel(eachOptModel.getItemNam());
			deptNoSelect.getDropdownList().add(deptNoOption);
		}
		return deptNoSelect;
	}
	

	/**
	 * @param String
	 * @author Chris
	 * @return DropdownSelect
	 */
	@Override
	public DropdownSelect initDataSelectSecNo(String deptNoParam) {
		
		List<Deptdata> secNoResults = deptDataRepo.secNoInitDataRM004(deptNoParam);
		log.debug("initDataSelectSecNo > secNoResults.size() [" + secNoResults.size() + "]");
		
		List<RM004OptionSecNoModel> allOptionModels = new ArrayList<>();
		String itemNo = "";
		String itemNam = "";
		for (Deptdata eachElement : secNoResults) {
			RM004OptionSecNoModel eachOptionModel = new RM004OptionSecNoModel();
			itemNo = StringsUtil.nullEmptyToTrimString(eachElement.getItemno());
			itemNam = StringsUtil.nullEmptyToTrimString(eachElement.getItemnam());
			eachOptionModel.setItemNo(itemNo);
			eachOptionModel.setItemNam(itemNam);
			allOptionModels.add(eachOptionModel);
		}
		
		DropdownSelect secNoSelect = new DropdownSelect();
		for (RM004OptionSecNoModel eachOption : allOptionModels) {
			DropdownOption secNoOption = new DropdownOption();
			secNoOption.setOptionValue(eachOption.getItemNo());
			secNoOption.setOptionLabel(eachOption.getItemNam());
			secNoSelect.getDropdownList().add(secNoOption);
		}
		return secNoSelect;
	}
	
	
	/**
	 * @param String, String
	 * @author Chris
	 * @return DropdownSelect
	 */
	@Override
	public DropdownSelect initDataSelectEmpNo(String deptNoParam, String secNoParam) {
		
		List<EmployeeView> queryResults = employeeViewRepo.empNoInitDataRM004(deptNoParam, secNoParam);
		log.debug("initDataSelectEmpNo > empNoResults.size() [" + queryResults.size() + "]");

		
		// Map ProjectView entity to model (gives default values)
		List<RM004OptionEmpNoModel> allOptionModels = new ArrayList<>();
		String empCNam = "";
		String empStat = "";
		String empNo = "";
				
		for (EmployeeView eachResult : queryResults) {
			RM004OptionEmpNoModel eachOptionModel = new RM004OptionEmpNoModel();
			empCNam = StringsUtil.nullEmptyToTrimString(eachResult.getEmpcnam());
			empNo = StringsUtil.nullEmptyToTrimString(eachResult.getEmpno());
			empStat = StringsUtil.nullEmptyToTrimString(eachResult.getEmpstat());			
			eachOptionModel.setEmpCNam(empCNam);
			eachOptionModel.setEmpStat(empStat);
			eachOptionModel.setEmpNo(empNo);
			allOptionModels.add(eachOptionModel);
		}
		// Map model to DropdownOption (then bundled together in DropdownSelect)
		DropdownSelect empNoSelect = new DropdownSelect();
		for(RM004OptionEmpNoModel eachOptModel : allOptionModels) {
			DropdownOption eachOption = new DropdownOption();
			// Modify Label to show "EMPCNAM (離職)" if EMPSTAT=1
			if ("1".equals(eachOptModel.getEmpStat())) {
				StringBuilder sb = new StringBuilder();
				sb.append(empCNam);
				sb.append("(離職)");
				eachOptModel.setEmpCNam(sb.toString());
			}
			eachOption.setOptionValue(eachOptModel.getEmpNo());
			eachOption.setOptionLabel(eachOptModel.getEmpCNam());
			empNoSelect.getDropdownList().add(eachOption);
		}
		return empNoSelect;
	}

	/**
	 * @param n/a
	 * @author Chris
	 * @return DropdownSelect
	 */
	@Override
	public DropdownSelect initDataSelectPrjNo() {
		log.debug("initDataSelectPrjNo > param: void");

		List<ProjectView> queryResults = projectViewRepo.prjNoInitDataRM004();
		// Map ProjectView entity to model (gives default values)
		List<RM004OptionPrjNoModel> allOptionModels = new ArrayList<>();
		for (ProjectView eachResult : queryResults) {
			RM004OptionPrjNoModel eachOptionModel = new RM004OptionPrjNoModel();
			String prjNam = StringsUtil.nullEmptyToTrimString(eachResult.getPrjnam());
			String prjNo = StringsUtil.nullEmptyToTrimString(eachResult.getPrjno());			
			eachOptionModel.setPrjNam(prjNam);
			eachOptionModel.setPrjNo(prjNo);
			allOptionModels.add(eachOptionModel);
		}
		// Map model to DropdownOption (then bundled together in DropdownSelect)
		DropdownSelect prjNoSelect = new DropdownSelect();
		DropdownOption prjNoOption;
		// Add default option
		prjNoOption = new DropdownOption();
		prjNoOption.setOptionLabel("不指定");
		prjNoOption.setOptionValue("");
		prjNoOption.setSelected("selected");
		prjNoSelect.getDropdownList().add(prjNoOption);
		for(RM004OptionPrjNoModel eachOptModel : allOptionModels) {
			prjNoOption = new DropdownOption();
			prjNoOption.setOptionValue(eachOptModel.getPrjNo());
			prjNoOption.setOptionLabel(eachOptModel.getPrjNam());
			prjNoSelect.getDropdownList().add(prjNoOption);
		}
		return prjNoSelect;
	}


	@Override
	public RM004QueryResultsTableModel queryBtnQryTcDataStaView( HashMap<String, Object> queryParams) {
		
		String empNo = (String) queryParams.get("empNo");
		int oprDatStart = (int) queryParams.get("oprStartDt");
		int oprDatEnd = (int) queryParams.get("oprEndDt");
		String prjNo = (String) queryParams.get("prjNo");
		log.debug("queryBtnQryTcDataStaView > deptNoInitDataRM004 params: ["+empNo+", "+oprDatStart+", "+oprDatEnd+", "+prjNo+"]");
		List<TCDataStaView> queryResults = tcDataStaViewRepo.deptNoInitDataRM004(empNo, oprDatStart, oprDatEnd, prjNo);
		if(queryResults!=null && queryResults.size()>0) {
			log.debug("RM004ServiceImpl > initDataSelectPrjNo > prjNoInitDataRM004 result: " + queryResults.toString());
		}
		
		RM004QueryResultsTableModel table = new RM004QueryResultsTableModel();
		RM004TableRowModel tableRow;
		ArrayList<RM004TableRowModel> tableRows = new ArrayList<RM004TableRowModel>();
		if(queryResults.size()!=0) {
			table.setTableRows(new ArrayList<RM004TableRowModel>());
			for (TCDataStaView eachRow : queryResults) {
				tableRow = new RM004TableRowModel();
				tableRow.setOprDat(Integer.toString(eachRow.getId().getOprdat())); // TO-DO null-safety
				tableRow.setPrjNam(eachRow.getPrjnam());
				tableRow.setSalDeptNo(eachRow.getSaldeptno());
				tableRow.setWkClass(eachRow.getWkclass());
				tableRow.setItemCName(eachRow.getItemcnam());
				tableRow.setWorkHr(eachRow.getWorkhr().toString());
				tableRow.setOverHr(eachRow.getOverhr().toString());
				tableRow.setTotalHr(eachRow.getTotalhr().toString());
				tableRow.setWkNote(eachRow.getWknote());
				tableRow.setWkType(eachRow.getWktype());
				tableRows.add(tableRow);
			}
		}
		
		table.setTableRows(tableRows);
		
		log.debug("RM004ServiceImpl > initDataSelectPrjNo > tableResults return: " + table.toString());
		return table;
	}


	
	
	
}
