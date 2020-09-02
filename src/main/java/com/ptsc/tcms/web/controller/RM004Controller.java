package com.ptsc.tcms.web.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ptsc.tcms.util.StringsUtil;
import com.ptsc.tcms.web.component.DropdownOption;
import com.ptsc.tcms.web.component.DropdownSelect;
import com.ptsc.tcms.web.component.Selected;
import com.ptsc.tcms.web.model.RM004Model;
import com.ptsc.tcms.web.model.RM004QueryResultsTableModel;
import com.ptsc.tcms.web.service.RM004Service;

@Controller
@RequestMapping("/RM004")
public class RM004Controller {
	
	/**
	 * Log
	 */
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private RM004Service rm004Service;
	
	private RM004Model rm004model;
	
	@Autowired
	private HttpServletRequest request;

	
	@Autowired
	public RM004Controller(RM004Service rm004Service) {
		this.rm004Service = rm004Service;
		rm004model = new RM004Model();
	}
	
	@GetMapping("/initData")
	public ModelAndView initDataSelectDeptNoAndPrjNo(ModelAndView model) {
		
		log.debug("> /initData");
		
		DropdownSelect deptNoSelect = rm004Service.initDataSelectDeptNo();
		deptNoSelect.setDisabled("");
		rm004model.setDeptNoSelect(deptNoSelect);
		
		DropdownSelect prjNoSelect = rm004Service.initDataSelectPrjNo();
		prjNoSelect.setDisabled("");
		rm004model.setPrjNoSelect(prjNoSelect);

		log.debug("< /initData");
		model = new ModelAndView("RM004", "rm004model", rm004model);
		return model;
	}
	
	@RequestMapping(path = "/InitDataSecNo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DropdownSelect initDataSelectSecNo(
			@RequestBody DropdownOption deptNoSelected,
			Model model) {
		
		String deptNoVal = deptNoSelected.getOptionValue();
		deptNoVal = StringsUtil.nullEmptyToTrimString(deptNoVal);
		
		log.debug("> /InitDataSecNo["+deptNoVal+"]");

		DropdownSelect secNoSelect = rm004Service.initDataSelectSecNo(deptNoVal);
		
		secNoSelect.setDisabled("");
		
		rm004model.setSecNoSelect(secNoSelect);
		
		model.addAttribute("secNoSelect", secNoSelect);
		
		log.debug("< /InitDataSecNo");
		return secNoSelect;
	}
	
	@RequestMapping(path = "/InitDataEmpNo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DropdownSelect initDataSelectEmpNo(
			@RequestBody ArrayList<DropdownOption> selectedOptions,
			Model model) {
		String deptNoVal = selectedOptions.get(0).getOptionValue();
		deptNoVal = StringsUtil.nullEmptyToTrimString(deptNoVal);
		
		String secNoVal = selectedOptions.get(1).getOptionValue();
		secNoVal = StringsUtil.nullEmptyToTrimString(secNoVal);
			
		log.debug("> /InitDataEmpNo["+deptNoVal+", "+secNoVal+"]");

		DropdownSelect empNoSelect = rm004Service.initDataSelectEmpNo(deptNoVal, secNoVal);
		
		empNoSelect.setDisabled("");
		
		rm004model.setEmpNoSelect(empNoSelect);
		
		model.addAttribute("empNoSelect", empNoSelect);
		
		log.debug("< /InitDataEmpNo");
		return empNoSelect;
	}
	
	// Incomplete;
	@RequestMapping(value = "/QueryResults", method = RequestMethod.GET)
	public ModelAndView rm004QueryResults(
			@RequestParam(name = "empNo", required = false, defaultValue = "10904002") String empNo,
			@RequestParam(name = "oprStartDt", required = false, defaultValue = "1") int oprStartDt,
			@RequestParam(name = "oprEndDt", required = false, defaultValue = "9999999") int oprEndDt,
			@RequestParam(name = "prjNo", required = false, defaultValue = "TDU-S-0707-5") String prjNo
			) throws Exception {
		log.debug("RM004Controller > rm004QueryResults > params: ["+empNo+", "+oprStartDt+", "+oprEndDt+", "+prjNo+"]");
		String empNoValue = StringsUtil.nullEmptyToTrimString(empNo);
		String prjNoValue = StringsUtil.nullEmptyToTrimString(prjNo);
		
		HashMap<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("empNo", empNoValue);
		queryParams.put("oprStartDt", oprStartDt);
		queryParams.put("oprEndDt", oprEndDt);
		queryParams.put("prjNo", prjNoValue);
		
		RM004QueryResultsTableModel queryResults = rm004Service.queryBtnQryTcDataStaView(queryParams);
		log.debug("Table queryResults has X rows = " + queryResults.getTableRows().size());
		
		// To-Do make queryResults safe
		
		rm004model.setTable(queryResults);
		
		ModelAndView model = new ModelAndView("RM004", "rm004model", rm004model);
		
		model.addObject("table", queryResults);
		log.debug("RM004Controller > rm004QueryResults > return: ModelAndView" + "RM004");
		
		return model;
	}
}