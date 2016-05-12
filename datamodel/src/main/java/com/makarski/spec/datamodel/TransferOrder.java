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

	public List<ReserveOrder> getReserveOrders() {
		return reserveOrders;
	}

	public void setReserveOrders(List<ReserveOrder> reserveOrders) {
		this.reserveOrders = reserveOrders;
	}

	public Department getTargetDepartmentFk() {
		return targetDepartmentFk;
	}

	public void setTargetDepartmentFk(Department targetDepartmentFk) {
		this.targetDepartmentFk = targetDepartmentFk;
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

	public UserProfile getApprover() {
		return approver;
	}

	public void setApprover(UserProfile approver) {
		this.approver = approver;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


}
