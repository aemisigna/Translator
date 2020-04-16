package me.melondev.translator;

import lombok.Getter;
import me.melondev.translator.listener.TestListener;
import me.melondev.translator.provider.ITranslatedFieldProvider;
import me.melondev.translator.provider.TranslatedFieldProvider;
import me.melondev.translator.translatable.ILocatableStorageHelper;
import me.melondev.translator.translatable.LocatableField;
import me.melondev.translator.translatable.LocatableStorageHelper;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import java.util.logging.Level;

/**
 * Main class for Translator plugin.
 *
 * @author MelonDev
 * @since 1.0.0
 */
public final class TranslatorPlugin extends JavaPlugin {
    @Getter private static TranslatorPlugin translatorPlugin;

    @Getter private ILocatableStorageHelper locatableStorageHelper;
    @Getter private LocatableField locatableField;
    @Getter private ITranslatedFieldProvider translatedFieldProvider;

    // TODO 16/04/2020: Document all the project.
    @Override
    public void onEnable() {
        translatorPlugin = this;

        this.getLogger().log(Level.INFO, "Que pasa con loh pibeh ñeriiiii");

        this.locatableStorageHelper = new LocatableStorageHelper(this);
        this.locatableField = new LocatableField(this, new Yaml());
        this.translatedFieldProvider = new TranslatedFieldProvider(this);

        getServer().getPluginManager().registerEvents(new TestListener(), this);
    }

    @Override
    public void onDisable() {
        translatorPlugin = null;
    }
}
