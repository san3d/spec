package com.makarski.spec.dataaccess.impl;

import org.springframework.stereotype.Repository;

import com.makarski.spec.dataaccess.TransferPartDao;
import com.makarski.spec.datamodel.TransferPart;

@Repository
public class TransferPartDaoImpl extends AbstractDaoImpl<TransferPart, Long> implements TransferPartDao {

    protected TransferPartDaoImpl() {
		super(TransferPart.class);
    }

}
