package com.drizh2.rolliseum.entity.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum ArmorTypes {
    ALL("Вся"),
    LIGHT("Легка"),
    MEDIUM("Середня"),
    HEAVY("Важка"),
    SHIELDS("Щит"),
    NONE("Немає");

    private static final Map<String, ArmorTypes> names = new HashMap<>();

    static {
        for (ArmorTypes at : values()) {
            names.put(at.getLocalName(), at);
        }
    }

    private final String localName;

    ArmorTypes(String localName) {
        this.localName = localName;
    }
}
