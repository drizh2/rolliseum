package com.drizh2.rolliseum.entity.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum Classes {
    BARD("Бард"),
    BARBARIAN("Варвар"),
    FIGHTER("Воїн"),
    WIZARD("Чарівник"),
    DRUID("Друїд"),
    CLERIC("Жрець"),
    ARTIFICER("Винахідник"),
    WARLOCK("Чаклун"),
    MONK("Монах"),
    PALADIN("Паладин"),
    ROGUE("Злодій"),
    RANGER("Слідопит"),
    SORCERER("Чародій");

    private static final Map<String, Classes> names = new HashMap<>();

    static {
        for (Classes cl : values()) {
            names.put(cl.getLocalName(), cl);
        }
    }

    private final String localName;

    Classes(String localName) {
        this.localName = localName;
    }
}
