package com.makarski.spec.datamodel;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserProfile.class)
public abstract class UserProfile_ extends com.makarski.spec.datamodel.AbstractModel_ {

	public static volatile ListAttribute<UserProfile, TransferOrder> transferOrdersStock;
	public static volatile SingularAttribute<UserProfile, String> firstName;
	public static volatile SingularAttribute<UserProfile, String> lastName;
	public static volatile SingularAttribute<UserProfile, String> password;
	public static volatile ListAttribute<UserProfile, ReserveOrder> reserveOrders;
	public static volatile SingularAttribute<UserProfile, UserRole> role;
	public static volatile ListAttribute<UserProfile, TransferOrder> transferOrdersTarget;
	public static volatile SingularAttribute<UserProfile, Date> logIn;
	public static volatile SingularAttribute<UserProfile, Department> departmentFk;
	public static volatile SingularAttribute<UserProfile, String> email;

}

