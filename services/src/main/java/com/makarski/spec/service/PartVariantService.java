package com.makarski.spec.service;

import java.util.List;

import javax.transaction.Transactional;

import com.makarski.spec.dataaccess.filters.PartVariantFilter;
import com.makarski.spec.datamodel.PartVariant;

public interface PartVariantService {

    Long count(PartVariantFilter filter);

    List<PartVariant> find(PartVariantFilter filter);

    @Transactional
    void saveOrUpdate(PartVariant partVariant);

    PartVariant get(Long id);

}
