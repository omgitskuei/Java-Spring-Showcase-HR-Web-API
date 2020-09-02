package com.ptsc.tcms.persistence.entities.pk;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The primary key class for the TCDATA table of TCMS database.
 */
@Embeddable
@Data
public class TcdataPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column
	private int oprdat;
	@Column
	private String empno;
	@Column
	private String seqno;

	public TcdataPK() {
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TcdataPK)) {
			return false;
		}
		TcdataPK castOther = (TcdataPK)other;
		return 
			(this.oprdat == castOther.oprdat)
			&& this.empno.equals(castOther.empno)
			&& this.seqno.equals(castOther.seqno);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.oprdat;
		hash = hash * prime + this.empno.hashCode();
		hash = hash * prime + this.seqno.hashCode();
		return hash;
	}
}