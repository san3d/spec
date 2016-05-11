package com.makarski.spec.dataaccess.impl;

import org.springframework.stereotype.Repository;

import com.makarski.spec.dataaccess.PartDao;
import com.makarski.spec.datamodel.Part;

@Repository
public class PartDaoImpl extends AbstractDaoImpl<Part, Long> implements PartDao {

    protected PartDaoImpl() {
        super(Part.class);
    }

}
