package com.ptsc.tcms.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ptsc.tcms.persistence.entities.pk.TcdataPK;

import lombok.Data;

/**
 * The persistent class for the TCDataStaView table of TCMS database.
 * @author Chris
 */
@Entity
@Data
@Table(name="TCDataStaView")
@NamedQuery(name="TCDataStaView.findAll", query="SELECT t FROM TCDataStaView t")
public class TCDataStaView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private TcdataPK id;
	
	@Column
	private String deptno;
	@Column
	private String empcnam;
	@Column
	private String itemcnam;
	@Column
	private String itemno;
	@Column
	private String levno;
	@Column
	private BigDecimal overcost;
	@Column
	private BigDecimal overhr;
	@Column
	private String prjdeptnam;
	@Column
	private String prjnam;
	@Column
	private String prjno;
	@Column
	private String saldeptno;
	@Column
	private String secno;
	@Column
	private String syslevno;
	@Column
	private BigDecimal totalhr;
	@Column
	private String wkclass;
	@Column
	private String wkclassnam;
	@Column
	private BigDecimal wkcost;
	@Column
	private String wknote;
	@Column
	private String wktype;
	@Column
	private BigDecimal workhr;
}