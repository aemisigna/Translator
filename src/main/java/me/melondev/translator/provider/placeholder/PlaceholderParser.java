package me.melondev.translator.provider.placeholder;

import org.bukkit.entity.Player;

/**
 * //
 *
 * @author MelonDev
 * @since 1.0.0
 */
public final class PlaceholderParser {

    public static String transformField(final Player player, final String field) {
        return field.replace("%%new%%", "")
                .replace("%%player_name%%", player.getName());
    }
}
