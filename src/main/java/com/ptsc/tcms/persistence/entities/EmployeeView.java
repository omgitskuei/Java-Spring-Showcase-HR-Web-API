package com.ptsc.tcms.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

/**
 * The persistent class for the EMPLOYEE_VIEW table of TCMS database.
 * @author Chris
 */
@Entity
@Data
@Table(name="EMPLOYEE_VIEW")
@NamedQuery(name="EmployeeView.findAll", query="SELECT e FROM EmployeeView e")
public class EmployeeView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column
	private String arrdate;
	@Column
	private String contaddr;
	@Column
	private String contbda;
	@Column
	private String contid;
	@Column
	private String conttel;
	@Column
	private String deptno;
	@Column
	private String empcnam;
	@Column
	private String empenam;
	@Id
	@Column(name="EMPNO")
	private String empno;
	@Column
	private String emppwd;
	@Column
	private String empstat;
	@Column
	private String emptype;
	@Column
	private String leavdate;
	@Column
	private String mail;
	@Column
	private Integer personcost;
	@Column
	private String itemnam;
	@Column
	private String secno;
	@Column
	private String title;
}