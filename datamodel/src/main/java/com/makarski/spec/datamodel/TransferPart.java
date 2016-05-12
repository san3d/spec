package com.makarski.spec.datamodel;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
public class TransferPart{

	@ManyToOne(targetEntity = Part.class, fetch = FetchType.LAZY)
	private Part partFk;

	@ManyToOne(targetEntity = TransferOrder.class, fetch = FetchType.LAZY)
	private TransferOrder transferFk;
	
	@Column
	private BigDecimal quantity;

	public Part getPartFk() {
		return partFk;
	}

	public void setPartFk(Part partFk) {
		this.partFk = partFk;
	}

	public TransferOrder getTransferFk() {
		return transferFk;
	}

	public void setTransferFk(TransferOrder transferFk) {
		this.transferFk = transferFk;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
