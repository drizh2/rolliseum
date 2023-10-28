package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.SubclassDTO;
import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Subclass;
import com.drizh2.rolliseum.repository.SubclassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubclassService {

    public static final Logger LOG = LoggerFactory.getLogger(SubclassService.class);

    private final SubclassRepository subclassRepository;

    @Autowired
    public SubclassService(SubclassRepository subclassRepository) {
        this.subclassRepository = subclassRepository;
    }

    public Subclass createSubclass(SubclassDTO subclassDTO, Class clas) {
        Subclass subclass = new Subclass();

        subclass.setName(subclassDTO.getName());
        subclass.setSubclassFeatures(subclassDTO.getSubclassFeatures());
        subclass.setClas(clas);

        LOG.info("Subclass {}({}) is creating", subclass.getName(), clas.getName());

        return subclassRepository.save(subclass);
    }
}
