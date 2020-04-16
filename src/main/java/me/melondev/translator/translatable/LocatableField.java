package me.melondev.translator.translatable;

import me.melondev.translator.TranslatorPlugin;
import me.melondev.translator.locale.Language;

import me.melondev.translator.translatable.exception.LanguageFileNotFoundException;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public final class LocatableField {

    private TranslatorPlugin translatorPlugin;
    private Yaml yaml;

    private final static String ERROR_FILE_NOT_FOUND = "Can't find translation file for %1$s language.";

    public LocatableField(final TranslatorPlugin translatorPlugin, final Yaml yaml) {
        this.translatorPlugin = translatorPlugin;
        this.yaml = yaml;
    }

    public String getFieldFromFile(final Language language, final String field) throws LanguageFileNotFoundException {
        InputStream is;

        try {
            is = Files.newInputStream( Paths.get(translatorPlugin.getDataFolder() + "/" + language + ".yml"));
        } catch (IOException e) {
            throw new LanguageFileNotFoundException(String.format(ERROR_FILE_NOT_FOUND, language.getDisplay()));
        }

        final Map<String, Object> hashMap = (Map<String, Object>) yaml.load(is);
        final String response = String.valueOf(hashMap.get(field));

        if (!fieldExists(response)) return field;

        return response;
    }

    private boolean fieldExists(final String languageField) {
        return !languageField.equalsIgnoreCase("null");
    }
}
