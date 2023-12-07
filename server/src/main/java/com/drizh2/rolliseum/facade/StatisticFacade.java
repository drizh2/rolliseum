package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.StatisticDTO;
import com.drizh2.rolliseum.entity.Statistic;

public class StatisticFacade {

    private StatisticFacade() {}

    public static StatisticDTO statisticToStatisticDTO(Statistic statistic) {
        return StatisticDTO.builder()
                .name(statistic.getName())
                .modificator(statistic.getModificator())
                .savingThrow(statistic.isSavingThrow())
                .skills(statistic.getSkills())
                .build();
    }

    public static Statistic statisticDTOToStatistic(StatisticDTO statisticDTO) {
        return Statistic.builder()
                .name(statisticDTO.getName())
                .modificator(statisticDTO.getModificator())
                .savingThrow(statisticDTO.isSavingThrow())
                .skills(statisticDTO.getSkills())
                .build();
    }
}
