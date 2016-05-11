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

}
