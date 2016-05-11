package com.makarski.spec.datamodel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Department.class)
public abstract class Department_ extends com.makarski.spec.datamodel.AbstractModel_ {

	public static volatile ListAttribute<Department, TransferOrder> transferOrdersStock;
	public static volatile ListAttribute<Department, ReserveOrder> reserveOrders;
	public static volatile ListAttribute<Department, TransferOrder> transferOrdersTarget;
	public static volatile SingularAttribute<Department, String> name;
	public static volatile ListAttribute<Department, DepartmentPart> departmentParts;
	public static volatile ListAttribute<Department, UserProfile> userProfiles;

}

