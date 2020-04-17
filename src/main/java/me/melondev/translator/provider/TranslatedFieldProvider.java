package me.melondev.translator.provider;

import me.melondev.translator.TranslatorPlugin;
import me.melondev.translator.locale.Language;
import me.melondev.translator.provider.placeholder.FieldPlaceholder;
import me.melondev.translator.provider.placeholder.PlaceholderParser;
import me.melondev.translator.translatable.exception.LanguageFileNotFoundException;
import org.bukkit.entity.Player;

import java.util.logging.Level;

/**
 *
 *
 * @author MelonDev
 * @since 1.0.0
 */
public final class TranslatedFieldProvider implements ITranslatedFieldProvider {
    private TranslatorPlugin translatorPlugin;

    public TranslatedFieldProvider(final TranslatorPlugin translatorPlugin) {
        this.translatorPlugin = translatorPlugin;
    }

    @Override
    public String getField(final Language language, final String string) {
        try {
            return translatorPlugin.getLocatableField().getFieldFromFile(language, string);
        } catch (LanguageFileNotFoundException e) {
            translatorPlugin.getLogger().log(Level.SEVERE, "An error has ocurred while getting field " + string + " for language " + language.getDisplay());
            return string + " (#getField | File not found: " + language.getDisplay() + ")";
        }
    }

    @Override
    public String getPlayerField(final Player player, final Language language, final String field) {
        try {
            return PlaceholderParser.transformField(player, translatorPlugin.getLocatableField().getFieldFromFile(language, field));
        } catch (LanguageFileNotFoundException e) {
            translatorPlugin.getLogger().log(Level.SEVERE, "An error has ocurred while getting field " + field + " for language " + language.getDisplay());
            return field + " (#getPlayerField | File not found: " + language.getDisplay() + ")";
        }
    }

    @Override
    public String getPlaceholderField(final Language language, final FieldPlaceholder fieldPlaceholder, final String field) {
        try {
            return PlaceholderParser.transformVariables(translatorPlugin.getLocatableField().getFieldFromFile(language, field), fieldPlaceholder);
        } catch (LanguageFileNotFoundException e) {
            translatorPlugin.getLogger().log(Level.SEVERE, "An error has ocurred while getting field " + field + " for language " + language.getDisplay());
            return field + " (#getPlaceholderField | File not found: " + language.getDisplay() + ")";
        }
    }
}
