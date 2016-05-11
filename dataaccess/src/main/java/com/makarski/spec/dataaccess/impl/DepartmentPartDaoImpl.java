package com.makarski.spec.dataaccess.impl;

import org.springframework.stereotype.Repository;

import com.makarski.spec.dataaccess.DepartmentPartDao;
import com.makarski.spec.datamodel.DepartmentPart;

@Repository
public class DepartmentPartDaoImpl extends AbstractDaoImpl<DepartmentPart, Long> implements DepartmentPartDao {

	protected DepartmentPartDaoImpl() {
		super(DepartmentPart.class);
	}

}
