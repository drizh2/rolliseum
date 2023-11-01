package com.drizh2.rolliseum.controller;

import com.drizh2.rolliseum.dto.ClassDTO;
import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.facade.ClassFacade;
import com.drizh2.rolliseum.service.ClassService;
import com.drizh2.rolliseum.validator.ResponseErrorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/class")
public class ClassController {
    private final ClassService classService;
    private final ClassFacade classFacade;
    private final ResponseErrorValidator responseErrorValidator;

    @Autowired
    public ClassController(ClassService classService, ClassFacade classFacade, ResponseErrorValidator responseErrorValidator) {
        this.classService = classService;
        this.classFacade = classFacade;
        this.responseErrorValidator = responseErrorValidator;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createClass(@RequestBody ClassDTO classDTO,
                                              BindingResult bindingResult) {
        ResponseEntity<Object> errorMap = responseErrorValidator.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errorMap)) {
            return errorMap;
        }

        Class clas = classService.createClass(classDTO);
        ClassDTO finalClass = classFacade.classToClassDTO(clas);

        return ResponseEntity.ok(finalClass);
    }

    @GetMapping("/{classId}")
    public ResponseEntity<ClassDTO> getClassById(@PathVariable("classId") String classId) {
        Class clas = classService.getClassById(Long.parseLong(classId));
        ClassDTO classDTO = classFacade.classToClassDTO(clas);

        return ResponseEntity.ok(classDTO);
    }
}
