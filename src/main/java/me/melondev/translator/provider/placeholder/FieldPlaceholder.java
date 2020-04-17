package me.melondev.translator.provider.placeholder;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * //
 *
 * @author MelonDev
 * @since 1.0.0
 */
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public final class FieldPlaceholder {

    @NonNull private String variable;
    @Getter @NonNull private String replacement;

    public String getVariable() {
        return "%%" + variable + "%%";
    }
}
