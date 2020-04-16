package me.melondev.translator.provider;

import me.melondev.translator.locale.Language;
import org.bukkit.entity.Player;

public interface ITranslatedFieldProvider {
    String getField(Language language, String string);
    String getPlayerField(Player player, Language language, String string);
}
