package com.ptsc.tcms.persistence.entities.custom;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ptsc.tcms.persistence.entities.pk.AplyamtPK;
//import com.ptsc.tcms.persistence.entities.pk.AplyamtdtPK;

import lombok.Data;

/**
 * 自訂義Entity Aplyamt & Aplyamtdt
 * @author Chris
 */
@Entity
@Data
public class AplyamtAndAplyamtdt implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// Table Aplyamt
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SERIAL_NO")
	@EmbeddedId
	private AplyamtPK id;
	@Column
	private String deptnam;
	@Column
	private String deptno;
	@Column
	private String empcnam;
	@Column
	private short levdays;
	@Column
	private int levetm;
	@Column
	private int levstm;
	@Column
	private String title;
	
	// Table Aplyamtdt
	@Column
	private int expenses;
	@Column
	private int feedate;
	@Column
	private String feenote;
	@Column
	private String prjno;
	@Column
	private String saldeptno;
	@Column
	private String sideend;
	@Column
	private String sidest;
	@Column
	private int stayexp;
	@Column
	private int talamt;
	@Column
	private int trfexp;
	@Column
	private int trfexpamt;
	@Column
	private int trfexpk;
	@Column
	private int trfexpkm;
	@Column
	private int trfexpln;
}
