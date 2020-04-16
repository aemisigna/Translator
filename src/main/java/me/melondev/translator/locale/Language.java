package me.melondev.translator.locale;

import lombok.Getter;

/**
 * Enum for language.
 *
 * @author MelonDev
 * @since 1.0.0
 */
public enum Language {
    SPANISH("es_ES"),
    ENGLISH("en_EN");

    @Getter private String display;

    Language(final String display) {
        this.display = display;
    }
}
