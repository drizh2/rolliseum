package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.StatisticDTO;
import com.drizh2.rolliseum.entity.Statistic;
import com.drizh2.rolliseum.repository.StatisticRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    public static final Logger LOG = LoggerFactory.getLogger(StatisticService.class);

    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public Statistic createStatistic(StatisticDTO statisticDTO) {
        Statistic statistic = new Statistic();

        statistic.setName(statisticDTO.getName());
        statistic.setModificator(statisticDTO.getModificator());
        statistic.setSavingThrow(statisticDTO.isSavingThrow());
        statistic.setSkills(statisticDTO.getSkills());

        LOG.info("Creating {} statistic with {} modificator", statistic.getName(), statistic.getModificator());

        return statisticRepository.save(statistic);
    }

}
