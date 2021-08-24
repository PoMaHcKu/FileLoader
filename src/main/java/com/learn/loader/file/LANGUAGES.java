package com.learn.loader.file;

public enum LANGUAGES {

    EN_US("en-US"), EN_GB("en-GB");

    LANGUAGES(String value) {
        this.value = value;
    }

    String value;

    String getValue() {
        return value;
    }
}
