package com.drizh2.rolliseum.entity.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum Races {
    AARAKOCRA("Ааракокра"),
    AASIMAR("Аасімар"),
    AUTOGNOME("Автогном"),
    BUGBEAR("Багбір"),
    VEDALKEN("Ведалкен"),
    VERDAN("Вердан"),
    SIMIC_HYBRID("Гібрид Симиків"),
    GITH("Гіт"),
    GIFF("Гіфф"),
    GNOME("Гном"),
    GOBLIN("Гоблін"),
    GOLIATH("Голіаф"),
    GRUNG("Грунг"),
    DWARF("Дварф"),
    GENASI("Дженазі"),
    DRAGONBORN("Дракононароджений"),
    CHANGELING("Змінюючий"),
    KALASHTAR("Калаштар"),
    KENDER("Кендер"),
    KENKU("Кенку"),
    CENTAUR("Кентавр"),
    KOBOLD("Кобольд"),
    WARFORGED("Викований"),
    LEONIN("Леонін"),
    LOCATHAH("Локата"),
    LOXODON("Локсодон"),
    LIZARDFOLK("Людоящер"),
    MINOTAUR("Мінотавр"),
    ORC("Орк"),
    PLASMOID("Плазмоїд"),
    HALF_ORC("Напіворк"),
    HALFLING("Половинчик"),
    HALF_ELF("Напівельф"),
    SATYR("Сатир"),
    OWLIN("Совлін"),
    TABAXI("Табаксі"),
    TIEFLING("Тифлінґ"),
    TORTLE("Тортл"),
    THRI_KREEN("Трі-Крин"),
    TRITON("Тритон"),
    FIRBOLG("Фірболг"),
    FAIRY("Фейрі"),
    HADOZEE("Хадозі"),
    HARENGON("Харенгон"),
    HOBGOBLIN("Хобгоблін"),
    HUMAN("Людина"),
    SHIFTER("Шифтер"),
    ELF("Ельф"),
    ASTRAL_ELF("Астральний ельф"),
    YUAN_TI("Юань-ті"),
    GLITCHLING("Глючний"),
    GITHZERAI("Глітцераі"),
    GITHYANKI("Гіт'янкі"),
    DEEP_GNOME("Глубинний гном"),
    GENASI_WATER("Дженазі води"),
    GENASI_AIR("Дженазі повітря"),
    GENASI_EARTHR("Дженазі землі"),
    GENASI_FAIR("Дженазі вогню"),
    DUERGAR("Дуергар"),
    SEA_ELF("Морський ельф"),
    SHADAR_KAI("Шадар-кай"),
    ELADRIN("Еладрін");

    private static final Map<String, Races> names = new HashMap<>();

    static {
        for (Races race : values()) {
            names.put(race.getLocalName(), race);
        }
    }

    private final String localName;

    Races(String localName) {
        this.localName = localName;
    }
}
