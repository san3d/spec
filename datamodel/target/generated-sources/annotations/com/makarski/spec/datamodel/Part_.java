package com.makarski.spec.datamodel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Part.class)
public abstract class Part_ extends com.makarski.spec.datamodel.AbstractModel_ {

	public static volatile SingularAttribute<Part, String> note;
	public static volatile ListAttribute<Part, ReservePart> reserveParts;
	public static volatile ListAttribute<Part, DepartmentPart> departmentParts;
	public static volatile SingularAttribute<Part, String> specification;
	public static volatile ListAttribute<Part, TransferPart> transferParts;
	public static volatile SingularAttribute<Part, Unit> unitFk;
	public static volatile ListAttribute<Part, Tag> tags;

}

