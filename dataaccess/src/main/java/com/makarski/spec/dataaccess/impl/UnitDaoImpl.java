package com.makarski.spec.dataaccess.impl;

import org.springframework.stereotype.Repository;

import com.makarski.spec.dataaccess.UnitDao;
import com.makarski.spec.datamodel.Unit;

@Repository
public class UnitDaoImpl extends AbstractDaoImpl<Unit, Long> implements UnitDao {

	protected UnitDaoImpl() {
		super(Unit.class);
	}

}
