package com.ptsc.tcms.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ptsc.tcms.persistence.entities.ProjectView;

public interface ProjectViewRepo extends CrudRepository<ProjectView, String>{
	
	/**
	 * RM004 InitData for Select PrjNo
	 * @return List
	 * @author Chris
	 */
	@Query(value = "SELECT A.* FROM PROJECT_VIEW A WITH (NOLOCK) "
			+ "ORDER BY PRJNO", nativeQuery = true)
	public List<ProjectView> prjNoInitDataRM004();
}
