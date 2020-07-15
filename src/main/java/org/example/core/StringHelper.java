package org.example.core;

import com.google.common.base.CaseFormat;

public final class StringHelper {

    public static String convertToUpperUnderscore(final String string) {
        return string.replaceAll("-", "_")
                .replaceAll("/", "_")
                .replaceAll(" ", "_").toUpperCase();
    }
}
