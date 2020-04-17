package me.melondev.translator.provider;

import me.melondev.translator.locale.Language;
import me.melondev.translator.provider.placeholder.FieldPlaceholder;
import org.bukkit.entity.Player;

public interface ITranslatedFieldProvider {
    String getField(Language language, String string);
    String getPlayerField(Player player, Language language, String string);
    String getPlaceholderField(Language language, FieldPlaceholder fieldPlaceholder, String string);
}
