package com.makarski.spec.dataaccess.impl;

import org.springframework.stereotype.Repository;

import com.makarski.spec.dataaccess.DepartmentDao;
import com.makarski.spec.datamodel.Department;

@Repository
public class DepartmentDaoImpl extends AbstractDaoImpl<Department, Long> implements DepartmentDao {

	protected DepartmentDaoImpl() {
		super(Department.class);
	}

}
