package com.makarski.spec.datamodel;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReserveOrder.class)
public abstract class ReserveOrder_ extends com.makarski.spec.datamodel.AbstractModel_ {

	public static volatile SingularAttribute<ReserveOrder, Date> date;
	public static volatile ListAttribute<ReserveOrder, ReserveOrder> reserveOrders;
	public static volatile SingularAttribute<ReserveOrder, Department> stockDepartmentFk;
	public static volatile SingularAttribute<ReserveOrder, UserProfile> author;
	public static volatile SingularAttribute<ReserveOrder, String> comment;
	public static volatile SingularAttribute<ReserveOrder, Status> status;

}

