package com.github.t1.log;

import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.StatusType;

@ConverterType(Response.class)
public class ResponseLogConverter implements Converter {
    @Override
    public String convert(Object o) {
        Response response = (Response) o;
        StatusType statusInfo = response.getStatusInfo();
        return statusInfo.getStatusCode() + " " + statusInfo.getReasonPhrase() + entityInfo(response);
    }

    private String entityInfo(Response response) {
        Object entity = response.getEntity();
        if (entity == null)
            return "";
        return ": " + entity.getClass().getSimpleName();
    }
}