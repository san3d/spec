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

	public Part getPartFk() {
		return partFk;
	}

	public void setPartFk(Part partFk) {
		this.partFk = partFk;
	}

	public ReserveOrder getReserveFk() {
		return reserveFk;
	}

	public void setReserveFk(ReserveOrder reserveFk) {
		this.reserveFk = reserveFk;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
