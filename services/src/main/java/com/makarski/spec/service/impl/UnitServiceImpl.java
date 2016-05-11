package com.makarski.spec.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.makarski.spec.dataaccess.UnitDao;
import com.makarski.spec.datamodel.Unit;
import com.makarski.spec.service.UnitService;

@Service
public class UnitServiceImpl implements UnitService{
	
	private UnitDao unitDao;

	@Transactional
	@Override
	public List<Unit> getAll() {
		return unitDao.getAll();
	}

}
