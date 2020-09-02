package com.ptsc.tcms.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ptsc.tcms.persistence.entities.EmployeeView;

/**
 * EmployeeView控制檔相關操作
 */
public interface EmployeeViewRepo extends CrudRepository<EmployeeView, Integer> {
	
	/**
	 * RM004 InitData for Select EmpNo
	 * @return List
	 * @author Chris
	 */
	@Query(value = "SELECT A.* FROM EMPLOYEE_VIEW A WITH (NOLOCK) " 
			+ "WHERE DEPTNO = ?1 AND SECNO = ?2 " 
			+ "ORDER BY DEPTNO, SECNO, EMPCNAM", nativeQuery = true)
	public List<EmployeeView> empNoInitDataRM004(String deptNo, String secNo);

	
	
}
