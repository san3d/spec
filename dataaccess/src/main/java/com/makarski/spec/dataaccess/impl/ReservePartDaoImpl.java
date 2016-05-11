package com.makarski.spec.dataaccess.impl;

import org.springframework.stereotype.Repository;

import com.makarski.spec.dataaccess.ReservePartDao;
import com.makarski.spec.datamodel.ReservePart;

@Repository
public class ReservePartDaoImpl extends AbstractDaoImpl<ReservePart, Long> implements ReservePartDao {

    protected ReservePartDaoImpl() {
		super(ReservePart.class);
    }

}
