package com.ptsc.tcms.persistence.entities.pk;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The primary key class for the APLYAMTDT table of TCMS database.
 */
@Embeddable
@Data
public class AplyamtdtPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column
	private String appdno;
	@Column
	private int seqno;

	public AplyamtdtPK() {
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AplyamtdtPK)) {
			return false;
		}
		AplyamtdtPK castOther = (AplyamtdtPK)other;
		return 
			this.appdno.equals(castOther.appdno)
			&& (this.seqno == castOther.seqno);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.appdno.hashCode();
		hash = hash * prime + this.seqno;
		return hash;
	}
}