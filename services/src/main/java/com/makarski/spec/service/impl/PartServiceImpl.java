package com.makarski.spec.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.makarski.spec.dataaccess.partDao;
import com.makarski.spec.dataaccess.filters.partFilter;
import com.makarski.spec.datamodel.Part;
import com.makarski.spec.service.partService;

@Service
public class PartServiceImpl implements PartService {

    @Inject
    private PartDao dao;

    @Override
    public Long count(PartFilter filter) {
        return dao.count(filter);
    }

    @Override
    public List<Part> find(PartFilter filter) {
        return dao.find(filter);
    }

    @Override
    public void saveOrUpdate(Part part) {
        if (part.getId() == null) {
            dao.insert(part);
        } else {
            dao.update(part);
        }

    }

    @Override
    public void delete(Part part) {

        dao.delete(part.getId());

    }

}
