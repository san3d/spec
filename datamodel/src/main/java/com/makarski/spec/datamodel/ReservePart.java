package com.makarski.spec.datamodel;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
public class ReservePart {

	@ManyToOne(targetEntity = Part.class, fetch = FetchType.LAZY)
	private Part partFk;

	@ManyToOne(targetEntity = ReserveOrder.class, fetch = FetchType.LAZY)
	private ReserveOrder reserveFk;
	
	@Column
	private BigDecimal quantity;

}
