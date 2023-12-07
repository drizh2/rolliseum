package com.drizh2.rolliseum.entity.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum SavingThrows {
    STRENGTH("Сила"),
    DEXTERITY("Вправність"),
    CONSTITUTION("Статура"),
    INTELLIGENCE("Інтелект"),
    WISDOM("Мудрість"),
    CHARISMA("Харизма");

    private static final Map<String, SavingThrows> names = new HashMap<>();

    static {
        for (SavingThrows st : values()) {
            names.put(st.getLocalName(), st);
        }
    }

    private final String localName;

    SavingThrows(String localName) {
        this.localName = localName;
    }
}
