package com.ptsc.tcms.persistence.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ptsc.tcms.persistence.entities.TCDataStaView;

/**
 * Deptdata控制檔相關操作
 */
public interface TCDataStaViewRepo extends CrudRepository<TCDataStaView, Integer> {
	/**
	 * RM004 InitData for Select DeptNo
	 * @return List
	 * @author Chris
	 */
	@Query(value = "SELECT A.* FROM TCDataStaView A WITH (NOLOCK) " + 
			"WHERE EMPNO = ?1 AND (OPRDAT BETWEEN ?2 AND ?3 ) AND PRJNO = ?4 " + 
			"ORDER BY OPRDAT, EMPNO, PRJNO, DEPTNO, SALDEPTNO, ITEMNO", nativeQuery = true)
	public ArrayList<TCDataStaView> deptNoInitDataRM004(String empNo, int oprDatStart, int oprDatEnd, String prjNo);

	
	
}
