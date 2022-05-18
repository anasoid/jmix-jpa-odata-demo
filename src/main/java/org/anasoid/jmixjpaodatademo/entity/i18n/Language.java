package org.anasoid.jmixjpaodatademo.entity.i18n;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum Language implements EnumClass<String> {

    ENGLISH("en"),
    GERMAN("de"),
    FRENCH("fr");

    private String id;

    Language(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Language fromId(String id) {
        for (Language at : Language.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}