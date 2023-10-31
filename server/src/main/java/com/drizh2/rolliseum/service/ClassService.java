package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.ClassDTO;
import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.exception.ClassNotFoundException;
import com.drizh2.rolliseum.repository.ClassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    public static final Logger LOG = LoggerFactory.getLogger(ClassService.class);

    private final ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public Class createClass(ClassDTO classDTO) {
        Class clas = new Class();

        clas.setName(classDTO.getName());
        clas.setHitDice(classDTO.getHitDice());
        clas.setFirstLevelHits(classDTO.getFirstLevelHits());
        clas.setNextLevelHits(classDTO.getNextLevelHits());
        clas.setSubclasses(classDTO.getSubclasses());
        clas.setFeatures(classDTO.getFeatures());
        clas.setArmor(classDTO.getArmor());
        clas.setWeapons(classDTO.getWeapons());
        clas.setTools(classDTO.getTools());
        clas.setSavingThrows(classDTO.getSavingThrows());
        clas.setStats(classDTO.getStats());
        clas.setSpellSavingThrow(classDTO.getSpellSavingThrow());

        LOG.info("Class {} is creating!", clas.getName());

        return classRepository.save(clas);
    }

    public Class getClassById(Long id) {
        return classRepository.findClassById(id)
                .orElseThrow(() -> new ClassNotFoundException("Class has not been found!"));
    }

}
