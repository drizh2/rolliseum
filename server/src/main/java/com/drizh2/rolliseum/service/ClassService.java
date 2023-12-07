package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.ClassDTO;
import com.drizh2.rolliseum.dto.FeatureDTO;
import com.drizh2.rolliseum.dto.SubclassDTO;
import com.drizh2.rolliseum.dto.ToolDTO;
import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Feature;
import com.drizh2.rolliseum.entity.Subclass;
import com.drizh2.rolliseum.entity.Tool;
import com.drizh2.rolliseum.exception.ClassNotFoundException;
import com.drizh2.rolliseum.facade.ClassFacade;
import com.drizh2.rolliseum.facade.FeatureFacade;
import com.drizh2.rolliseum.facade.SubclassFacade;
import com.drizh2.rolliseum.facade.ToolFacade;
import com.drizh2.rolliseum.repository.ClassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    public static final Logger LOG = LoggerFactory.getLogger(ClassService.class);

    private final ClassRepository classRepository;
    private final SubclassService subclassService;
    private final FeatureService featureService;
    private final ToolService toolService;

    @Autowired
    public ClassService(ClassRepository classRepository, SubclassService subclassService, FeatureService featureService, ToolService toolService) {
        this.classRepository = classRepository;
        this.subclassService = subclassService;
        this.featureService = featureService;
        this.toolService = toolService;
    }

    public Class createClass(ClassDTO classDTO) {
        Class clas = ClassFacade.classDTOToClass(classDTO);

        for (ToolDTO toolDTO : classDTO.getTools()) {
            Tool tempTool = toolService.createTool(toolDTO);
            clas.getTools().add(tempTool);
        }

        clas = classRepository.save(clas);

        for (SubclassDTO subclassDTO : classDTO.getSubclasses()) {
            Subclass subclass = SubclassFacade.subclassDTOToSubclass(subclassDTO);

            for (FeatureDTO featureDTO : subclassDTO.getSubclassFeatures()) {
                Feature feature = FeatureFacade.featureDTOToFeature(featureDTO);
                subclass.getSubclassFeatures().add(feature);
            }
            
            subclass.setClas(clas);
            SubclassDTO newDtoSubclass = SubclassFacade.subclassToDTO(subclass);
            Subclass tempSubclass = subclassService.createSubclass(newDtoSubclass);
            clas.getSubclasses().add(tempSubclass);
        }

        for (FeatureDTO featureDTO : classDTO.getFeatures()) {
            Feature feature = FeatureFacade.featureDTOToFeature(featureDTO);
            feature.setClas(clas);
            Feature tempFeature = featureService.createFeatureForClass(FeatureFacade.featureToDTO(feature));
            clas.getFeatures().add(tempFeature);
        }

        LOG.info("Class {} is creating!", clas.getName());

        return classRepository.save(clas);
    }

    public Class getClassById(Long id) {
        return classRepository.findClassById(id)
                .orElseThrow(() -> new ClassNotFoundException("Class has not been found!"));
    }

}
