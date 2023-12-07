package com.drizh2.rolliseum.entity.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum WeaponTypes {
    SIMPLE("Просте"),
    HAND_TO_HAND("Рукопашне"),
    LONG_RANGE("Далекобійне"),
    WARRIORS("Воїнське"),
    EXOTIC("Екзотичне"),
    BOWS("Луки"),
    CROSSBOWS("Арбалети"),
    GUNS("Стрілкова"),
    THROWN("Метальна"),
    AXES("Сокири"),
    SWORDS("Мечі"),
    MACES("Булави"),
    POLEARMS("Коп'я"),
    STAVES("Пали"),
    DAGGERS("Кинджали"),
    FIST("Кулаки"),
    WARGLAIVES("Бойові клинки"),
    WANDS("Жезли"),
    OFF_HAND("Безручна"),
    RELICS("Реліквія");

    private static final Map<String, WeaponTypes> names = new HashMap<>();

    static {
        for (WeaponTypes wt : values()) {
            names.put(wt.getLocalName(), wt);
        }
    }

    private final String localName;

    WeaponTypes(String localName) {
        this.localName = localName;
    }
}
