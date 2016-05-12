package com.makarski.spec.datamodel;

import java.util.*;
import javax.persistence.*;

@Entity
public class Part extends AbstractModel {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "partFk")
	private List<DepartmentPart> departmentParts;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "partFk")
	private List<ReservePart> reserveParts;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "partFk")
	private List<TransferPart> transferParts;
	
	@Column
	private String specification;

	@ManyToOne(targetEntity = Unit.class, fetch = FetchType.LAZY)
	private Unit unitFk;

	@ManyToMany(targetEntity = Tag.class, cascade = CascadeType.ALL)
	@JoinTable(name = "part_tag", joinColumns = { @JoinColumn(name = "part_fk") }, inverseJoinColumns = {
			@JoinColumn(name = "tag_fk") })
	private List<Tag> tags;

	@Column
	private String note;

	public List<DepartmentPart> getDepartmentParts() {
		return departmentParts;
	}

	public void setDepartmentParts(List<DepartmentPart> departmentParts) {
		this.departmentParts = departmentParts;
	}

	public List<ReservePart> getReserveParts() {
		return reserveParts;
	}

	public void setReserveParts(List<ReservePart> reserveParts) {
		this.reserveParts = reserveParts;
	}

	public List<TransferPart> getTransferParts() {
		return transferParts;
	}

	public void setTransferParts(List<TransferPart> transferParts) {
		this.transferParts = transferParts;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Unit getUnitFk() {
		return unitFk;
	}

	public void setUnitFk(Unit unitFk) {
		this.unitFk = unitFk;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
