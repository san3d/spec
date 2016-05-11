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

}
