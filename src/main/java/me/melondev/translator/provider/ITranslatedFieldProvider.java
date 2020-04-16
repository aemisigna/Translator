package me.melondev.translator.provider;

import me.melondev.translator.locale.Language;

public interface ITranslatedFieldProvider {
    String getField(Language language, String string);
}
