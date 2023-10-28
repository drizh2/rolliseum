package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.SubclassDTO;
import com.drizh2.rolliseum.entity.Subclass;
import org.springframework.stereotype.Component;

@Component
public class SubclassFacade {
    public SubclassDTO subclassToDTO(Subclass subclass){
        SubclassDTO subclassDTO = new SubclassDTO();

        subclassDTO.setName(subclass.getName());
        subclassDTO.setSubclassFeatures(subclass.getSubclassFeatures());
        subclassDTO.setClas(subclass.getClas());

        return subclassDTO;
    }
}
