package com.ptsc.tcms.persistence.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ptsc.tcms.persistence.entities.Deptdata;

/**
 * Deptdata控制檔相關操作
 */
public interface DeptDataRepo extends CrudRepository<Deptdata, Integer> {
	/**
	 * RM004 InitData for Select DeptNo
	 * @return List
	 * @author Chris
	 */
	@Query(value = "SELECT A.* FROM DEPTDATA A "
			+ "WITH (NOLOCK) "
			+ "WHERE A.LAYER<=3 "
			+ "ORDER BY LAYER, ITEMNO", nativeQuery = true)
	public ArrayList<Deptdata> deptNoInitDataRM004();

	@Query(value = "SELECT A.* FROM DEPTDATA A "
			+ "WITH (NOLOCK) "
			+ "WHERE A.UPITEMNO = ?1 AND LAYER = 4 "
			+ "ORDER BY LAYER, ITEMNO ", nativeQuery = true)
	public ArrayList<Deptdata> secNoInitDataRM004(String upitemno);
}
