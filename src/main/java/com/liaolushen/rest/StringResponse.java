package com.liaolushen.rest;

/**
 * Created by liaolushen on 11/24/15.
 *
 * @author liaolushen
 */
public class StringResponse {
    private String type;
    private Object data;
    public StringResponse(String type, Object data) {
        this.type = type;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format(
                "{'type': '%s', 'data': '%s'}",
                type, data);
    }
}
