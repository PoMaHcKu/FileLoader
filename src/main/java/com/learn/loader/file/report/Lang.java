package com.learn.loader.file.report;

/**
 * Language
 */
public class Lang {

    private String name;
    private String code;
    private DetectLang detectedLanguage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DetectLang getDetectedLanguage() {
        return detectedLanguage;
    }

    public void setDetectedLanguage(DetectLang detectedLanguage) {
        this.detectedLanguage = detectedLanguage;
    }
}
