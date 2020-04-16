package me.melondev.translator;

import me.melondev.translator.locale.Language;
import org.bukkit.entity.Player;

/**
 * //
 *
 * @author MelonDev
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public final class TranslatorAPI {

    //TODO: Add placeholder support
    public static String getTranslatedField(final Language language, final String field) {
        return TranslatorPlugin.getTranslatorPlugin().getTranslatedFieldProvider().getField(language, field);
    }

    public static String getPlayerTranslatedField(final Player player, final Language language, final String field) {
        return TranslatorPlugin.getTranslatorPlugin().getTranslatedFieldProvider().getPlayerField(player, language, field);
    }
}
