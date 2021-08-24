package com.learn.loader.file.report;

/**
 * Matches.Context
 */
public class Context {

    private String text;
    private int offset;
    private int length;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
