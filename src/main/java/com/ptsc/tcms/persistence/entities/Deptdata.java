package com.ptsc.tcms.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

/**
 * The persistent class for the DEPTDATA table of TCMS database.
 * @author Chris
 */
@Entity
@Data
@Table(name="DEPTDATA")
@NamedQuery(name="Deptdata.findAll", query="SELECT a FROM Deptdata a")
public class Deptdata implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="DEPTID")
	private int deptid;
	@Column(name="LAYER")
	private String layer;
	@Column(name="ITEMNO")
	private String itemno;
	@Column(name="ITEMNAM")
	private String itemnam;
	@Column(name="UPITEMNO")
	private String upitemno;
	@Column(name="UPITEMNAM")
	private String upitemnam;
}