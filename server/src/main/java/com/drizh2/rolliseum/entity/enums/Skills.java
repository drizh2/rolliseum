package com.drizh2.rolliseum.entity.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum Skills {
    ACROBATICS(SavingThrows.DEXTERITY, "Акробатика"),
    ANIMAL_HANDLING(SavingThrows.WISDOM, "Догляд тварин"),
    ARCANA(SavingThrows.INTELLIGENCE, "Містицизм"),
    ATHLETICS(SavingThrows.STRENGTH, "Атлетика"),
    DECEPTION(SavingThrows.CHARISMA, "Обман"),
    HISTORY(SavingThrows.INTELLIGENCE, "Історія"),
    INSIGHT(SavingThrows.WISDOM, "Аналіз поведінки"),
    INTIMIDATION(SavingThrows.CHARISMA, "Залякування"),
    INVESTIGATION(SavingThrows.INTELLIGENCE, "Обстеження"),
    MEDICINE(SavingThrows.WISDOM, "Медицина"),
    NATURE(SavingThrows.INTELLIGENCE, "Природа"),
    PERCEPTION(SavingThrows.WISDOM, "Уважність"),
    PERFORMANCE(SavingThrows.CHARISMA, "Артистичність"),
    PERSUASION(SavingThrows.CHARISMA, "Переконливість"),
    RELIGION(SavingThrows.INTELLIGENCE, "Релігія"),
    SLEIGHT_OF_HAND(SavingThrows.DEXTERITY, "Спритність рук"),
    STEALTH(SavingThrows.DEXTERITY, "Cкритність"),
    SURVIVAL(SavingThrows.WISDOM, "Виживання");

    private static final Map<SavingThrows, Skills> savingThrows = new HashMap<>();
    private static final Map<String, Skills> names = new HashMap<>();

    static {
        for (Skills skill : values()) {
            savingThrows.put(skill.getSavingThrow(), skill);
            names.put(skill.getLocalName(), skill);
        }
    }

    private final SavingThrows savingThrow;
    private final String localName;

    Skills(SavingThrows savingThrow, String localName) {
        this.savingThrow = savingThrow;
        this.localName = localName;
    }
}
