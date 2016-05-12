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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DepartmentPart> getDepartmentParts() {
		return departmentParts;
	}

	public void setDepartmentParts(List<DepartmentPart> departmentParts) {
		this.departmentParts = departmentParts;
	}

	public List<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public List<TransferOrder> getTransferOrdersTarget() {
		return transferOrdersTarget;
	}

	public void setTransferOrdersTarget(List<TransferOrder> transferOrdersTarget) {
		this.transferOrdersTarget = transferOrdersTarget;
	}

	public List<TransferOrder> getTransferOrdersStock() {
		return transferOrdersStock;
	}

	public void setTransferOrdersStock(List<TransferOrder> transferOrdersStock) {
		this.transferOrdersStock = transferOrdersStock;
	}

	public List<ReserveOrder> getReserveOrders() {
		return reserveOrders;
	}

	public void setReserveOrders(List<ReserveOrder> reserveOrders) {
		this.reserveOrders = reserveOrders;
	}

}
