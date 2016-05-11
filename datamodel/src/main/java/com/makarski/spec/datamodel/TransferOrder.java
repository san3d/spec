package com.makarski.spec.datamodel;

import java.util.*;
import javax.persistence.*;

@Entity
public class TransferOrder extends AbstractModel {
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transferFk")
	private List<ReserveOrder> reserveOrders;

	@ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY)
	private Department targetDepartmentFk;
	
	@ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY)
	private Department stockDepartmentFk;

	@Column
	private Date date;

	@ManyToOne(targetEntity = UserProfile.class, fetch = FetchType.LAZY)
	private UserProfile author;
	
	@ManyToOne(targetEntity = UserProfile.class, fetch = FetchType.LAZY)
	private UserProfile approver;
	
	@Column
	private Date approveDate;
	
	@Column
	private Date completeDate;
	
	@Column
	private String comment;

	@Column
	@Enumerated(value = EnumType.ORDINAL)
	private Status status;


}
