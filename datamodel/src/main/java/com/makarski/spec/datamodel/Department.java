package com.makarski.spec.datamodel;

import java.util.List;
import javax.persistence.*;

@Entity
public class Department extends AbstractModel {

	@Column
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departmentFk")
	private List<DepartmentPart> departmentParts;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departmentFk")
	private List<UserProfile> userProfiles;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "targetDepartmentFk")
	private List<TransferOrder> transferOrdersTarget;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stockDepartmentFk")
	private List<TransferOrder> transferOrdersStock;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stockDepartmentFk")
	private List<ReserveOrder> reserveOrders;

}
