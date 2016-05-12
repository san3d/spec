package com.makarski.spec.datamodel;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
public class DepartmentPart extends AbstractModel {

	@ManyToOne(targetEntity = Part.class, fetch = FetchType.LAZY)
	private Part partFk;

    @ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY)
    private Department departmentFk;
	
	@Column
	private BigDecimal quantity;

	@Column
	private Date dateChange;

	public Part getPartFk() {
		return partFk;
	}

	public void setPartFk(Part partFk) {
		this.partFk = partFk;
	}

	public Department getDepartmentFk() {
		return departmentFk;
	}

	public void setDepartmentFk(Department departmentFk) {
		this.departmentFk = departmentFk;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Date getDateChange() {
		return dateChange;
	}

	public void setDateChange(Date dateChange) {
		this.dateChange = dateChange;
	}

}
