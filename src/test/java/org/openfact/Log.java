package org.openfact;

import java.util.List;

public class Log {

    private final String logName;
    private final List<String> lines;

    public Log(String logName, List<String> lines) {
        this.logName = logName;
        this.lines = lines;
    }

    public String getLogName() {
        return logName;
    }

    public List<String> getLines() {
        return this.lines;
    }
}
