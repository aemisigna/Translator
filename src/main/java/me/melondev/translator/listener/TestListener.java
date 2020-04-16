package me.melondev.translator.listener;

import me.melondev.translator.TranslatorAPI;
import me.melondev.translator.locale.Language;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * //
 *
 * @author MelonDev
 * @since 1.0.0
 */
public final class TestListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onJoin(final PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Espanich: " +
                TranslatorAPI.getPlayerTranslatedField(event.getPlayer(), Language.SPANISH, "test"));
        event.getPlayer().sendMessage("Inglich: " +
                TranslatorAPI.getPlayerTranslatedField(event.getPlayer(), Language.ENGLISH, "test"));
    }
}
