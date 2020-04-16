package me.melondev.translator.translatable;

import me.melondev.translator.locale.Language;

/**
 * //
 *
 * @author MelonDev
 * @since 1.0.0
 */
public interface ILocatableStorageHelper {
    void setupFiles();
    void generateYaml(final Language language);
}
