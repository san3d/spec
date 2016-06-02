package com.makarski.spec.service;

import java.util.List;

import javax.transaction.Transactional;

import com.makarski.spec.dataaccess.filters.PartFilter;
import com.makarski.spec.datamodel.Part;

public interface PartService {

    Long count(PartFilter filter);

    List<Part> find(PartFilter filter);

    @Transactional
    void saveOrUpdate(Part part);

    @Transactional
    void delete(Part part);
}
