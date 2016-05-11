package com.makarski.spec.datamodel;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DepartmentPart.class)
public abstract class DepartmentPart_ extends com.makarski.spec.datamodel.AbstractModel_ {

	public static volatile SingularAttribute<DepartmentPart, Part> partFk;
	public static volatile SingularAttribute<DepartmentPart, BigDecimal> quantity;
	public static volatile SingularAttribute<DepartmentPart, Date> dateChange;
	public static volatile SingularAttribute<DepartmentPart, Department> departmentFk;

}

