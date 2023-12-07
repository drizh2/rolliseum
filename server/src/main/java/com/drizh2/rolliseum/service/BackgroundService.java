package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.BackgroundDTO;
import com.drizh2.rolliseum.entity.Background;
import com.drizh2.rolliseum.facade.BackgroundFacade;
import com.drizh2.rolliseum.repository.BackgroundRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackgroundService {

    public static final Logger LOG = LoggerFactory.getLogger(BackgroundService.class);

    private final BackgroundRepository backgroundRepository;

    @Autowired
    public BackgroundService(BackgroundRepository backgroundRepository) {
        this.backgroundRepository = backgroundRepository;
    }

    public Background createBackground(BackgroundDTO backgroundDTO) {
        Background background = BackgroundFacade.DTOToBackground(backgroundDTO);

        LOG.info("Creating {} Background", background.getName());

        return backgroundRepository.save(background);
    }


}
