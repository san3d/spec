package com.makarski.spec.dataaccess.impl;

import org.springframework.stereotype.Repository;

import com.makarski.spec.dataaccess.TransferOrderDao;
import com.makarski.spec.datamodel.TransferOrder;

@Repository
public class TransferOrderDaoImpl extends AbstractDaoImpl<TransferOrder, Long> implements TransferOrderDao {

    protected TransferOrderDaoImpl() {
		super(TransferOrder.class);
    }

}
