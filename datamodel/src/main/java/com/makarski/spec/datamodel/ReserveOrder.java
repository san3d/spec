package com.makarski.spec.datamodel;

import java.util.*;
import javax.persistence.*;

@Entity
public class ReserveOrder extends AbstractModel {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reserveFk")
	private List<ReserveOrder> reserveOrders;

	@ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY)
	private Department stockDepartmentFk;

	@Column
	private Date date;

	@ManyToOne(targetEntity = UserProfile.class, fetch = FetchType.LAZY)
	private UserProfile author;

	@Column
	@Enumerated(value = EnumType.ORDINAL)
	private Status status;

	@Column
	private String comment;

}
