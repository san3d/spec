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

}
