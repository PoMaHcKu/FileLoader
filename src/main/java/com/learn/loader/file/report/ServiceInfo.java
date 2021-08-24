package com.learn.loader.file.report;

/**
 * Software
 */
public class ServiceInfo {

    private String name;
    private String version;
    private int apiVersion;
    private boolean premium;
    private String premiumHint;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(int apiVersion) {
        this.apiVersion = apiVersion;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getPremiumHint() {
        return premiumHint;
    }

    public void setPremiumHint(String premiumHint) {
        this.premiumHint = premiumHint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
