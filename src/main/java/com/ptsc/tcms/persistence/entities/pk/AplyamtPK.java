package com.ptsc.tcms.persistence.entities.pk;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The primary key class for the APLYAMT table of TCMS database.
 */
@Embeddable
@Data
public class AplyamtPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column
	private int appdate;
	@Column
	private String empno;
	@Column
	private String appdno;

	public AplyamtPK() {
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AplyamtPK)) {
			return false;
		}
		AplyamtPK castOther = (AplyamtPK)other;
		return 
			(this.appdate == castOther.appdate)
			&& this.empno.equals(castOther.empno)
			&& this.appdno.equals(castOther.appdno);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.appdate;
		hash = hash * prime + this.empno.hashCode();
		hash = hash * prime + this.appdno.hashCode();
		return hash;
	}
}