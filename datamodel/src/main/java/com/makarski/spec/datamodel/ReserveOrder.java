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

	public List<ReserveOrder> getReserveOrders() {
		return reserveOrders;
	}

	public void setReserveOrders(List<ReserveOrder> reserveOrders) {
		this.reserveOrders = reserveOrders;
	}

	public Department getStockDepartmentFk() {
		return stockDepartmentFk;
	}

	public void setStockDepartmentFk(Department stockDepartmentFk) {
		this.stockDepartmentFk = stockDepartmentFk;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserProfile getAuthor() {
		return author;
	}

	public void setAuthor(UserProfile author) {
		this.author = author;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
