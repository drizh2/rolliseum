package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.StatisticDTO;
import com.drizh2.rolliseum.entity.Statistic;
import org.springframework.stereotype.Component;

@Component
public class StatisticFacade {
    public StatisticDTO statisticToStatisticDTO(Statistic statistic) {
        StatisticDTO statisticDTO = new StatisticDTO();

        statisticDTO.setName(statistic.getName());
        statisticDTO.setModificator(statistic.getModificator());
        statisticDTO.setSavingThrow(statistic.isSavingThrow());
        statisticDTO.setSkills(statistic.getSkills());

        return statisticDTO;
    }
}
