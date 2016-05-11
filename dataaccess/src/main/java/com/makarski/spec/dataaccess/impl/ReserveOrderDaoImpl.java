package com.makarski.spec.dataaccess.impl;

import org.springframework.stereotype.Repository;

import com.makarski.spec.dataaccess.ReserveOrderDao;
import com.makarski.spec.datamodel.ReserveOrder;

@Repository
public class ReserveOrderDaoImpl extends AbstractDaoImpl<ReserveOrder, Long> implements ReserveOrderDao {

    protected ReserveOrderDaoImpl() {
		super(ReserveOrder.class);
    }

}
