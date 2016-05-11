package com.makarski.spec.datamodel;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TransferOrder.class)
public abstract class TransferOrder_ extends com.makarski.spec.datamodel.AbstractModel_ {

	public static volatile SingularAttribute<TransferOrder, Date> date;
	public static volatile SingularAttribute<TransferOrder, UserProfile> approver;
	public static volatile SingularAttribute<TransferOrder, Department> targetDepartmentFk;
	public static volatile ListAttribute<TransferOrder, ReserveOrder> reserveOrders;
	public static volatile SingularAttribute<TransferOrder, Department> stockDepartmentFk;
	public static volatile SingularAttribute<TransferOrder, Date> approveDate;
	public static volatile SingularAttribute<TransferOrder, UserProfile> author;
	public static volatile SingularAttribute<TransferOrder, String> comment;
	public static volatile SingularAttribute<TransferOrder, Date> completeDate;
	public static volatile SingularAttribute<TransferOrder, Status> status;

}

