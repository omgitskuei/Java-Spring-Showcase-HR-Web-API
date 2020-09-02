package com.ptsc.tcms.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

/**
 * The persistent class for the PROJECT_VIEW table of TCMS database.
 * @author Chris
 */
@Entity
@Data
@Table(name="PROJECT_VIEW")
@NamedQuery(name="ProjectView.findAll", query="SELECT p FROM ProjectView p")
public class ProjectView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private String prjno;
	@Column
	private String cusconpsnm;
	@Column
	private String custaddr;
	@Column
	private String custfax;
	@Column
	private String custid;
	@Column
	private String custnam;
	@Column
	private String custno;
	@Column
	private String custpost;
	@Column
	private String custtel;
	@Column
	private int prepjccst;
	@Column
	private int prepjcst;
	@Column
	private String prepjdte;
	@Column
	private String prepjdts;
	@Column
	private int prepjocst;
	@Column
	private int prepjps;
	@Column
	private int prepjtcst;
	@Column
	private String prjdeptnam;
	@Column
	private String prjdeptno;
	@Column
	private String prjend;
	@Column
	private String prjmanam;
	@Column
	private String prjmano;
	@Column
	private String prjnam;
	@Column
	private String prjtype;
	@Column
	private String psprjno;
	@Column
	private String saldeptnam;
	@Column
	private String saldeptno;
}