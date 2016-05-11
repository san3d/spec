package com.makarski.spec.datamodel;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class UserProfile extends AbstractModel {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
	private List<TransferOrder> transferOrdersStock;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "approver")
	private List<TransferOrder> transferOrdersTarget;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
	private List<ReserveOrder> reserveOrders;

	@Column(updatable = false)
	private String email;

	@Column
	private String password;

	@ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY)
	private Department departmentFk;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	@Enumerated(value = EnumType.ORDINAL)
	private UserRole role;

	@Column
	private Date logIn;

	//getters and setters
	
	public List<TransferOrder> getTransferOrdersStock() {
		return transferOrdersStock;
	}

	public void setTransferOrdersStock(List<TransferOrder> transferOrdersStock) {
		this.transferOrdersStock = transferOrdersStock;
	}

	public List<TransferOrder> getTransferOrdersTarget() {
		return transferOrdersTarget;
	}

	public void setTransferOrdersTarget(List<TransferOrder> transferOrdersTarget) {
		this.transferOrdersTarget = transferOrdersTarget;
	}

	public List<ReserveOrder> getReserveOrders() {
		return reserveOrders;
	}

	public void setReserveOrders(List<ReserveOrder> reserveOrders) {
		this.reserveOrders = reserveOrders;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartmentFk() {
		return departmentFk;
	}

	public void setDepartmentFk(Department departmentFk) {
		this.departmentFk = departmentFk;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Date getLogIn() {
		return logIn;
	}

	public void setLogIn(Date logIn) {
		this.logIn = logIn;
	}


}
