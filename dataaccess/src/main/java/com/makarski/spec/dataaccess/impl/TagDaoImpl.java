package com.makarski.spec.dataaccess.impl;

import org.springframework.stereotype.Repository;

import com.makarski.spec.dataaccess.TagDao;
import com.makarski.spec.datamodel.Tag;

@Repository
public class TagDaoImpl extends AbstractDaoImpl<Tag, Long> implements TagDao {

	protected TagDaoImpl() {
		super(Tag.class);
	}

}
