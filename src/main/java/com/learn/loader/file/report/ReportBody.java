package com.learn.loader.file.report;

import java.util.ArrayList;
import java.util.List;

public class ReportBody {

    private ServiceInfo software;
    private List<ReportItem> matches = new ArrayList<>();
    private Warn warnings;
    private Lang language;

    public ServiceInfo getSoftware() {
        return software;
    }

    public void setSoftware(ServiceInfo software) {
        this.software = software;
    }

    public List<ReportItem> getMatches() {
        return matches;
    }

    public void setMatches(List<ReportItem> matches) {
        this.matches = matches;
    }

    public Warn getWarnings() {
        return warnings;
    }

    public void setWarnings(Warn warnings) {
        this.warnings = warnings;
    }

    public Lang getLanguage() {
        return language;
    }

    public void setLanguage(Lang language) {
        this.language = language;
    }
}
