package org.openfact.theme.beans;

public class MessageBean {

    private String summary;

    private MessageType type;

    public MessageBean(String message, MessageType type) {
        this.summary = message;
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void appendSummaryLine(String newLine) {
        if (newLine == null)
            return;
        if (summary == null)
            summary = newLine;
        else
            summary = summary + "<br>" + newLine;
    }

    public String getType() {
        return this.type.toString().toLowerCase();
    }

    public boolean isSuccess() {
        return MessageType.SUCCESS.equals(this.type);
    }

    public boolean isWarning() {
        return MessageType.WARNING.equals(this.type);
    }

    public boolean isError() {
        return MessageType.ERROR.equals(this.type);
    }

}