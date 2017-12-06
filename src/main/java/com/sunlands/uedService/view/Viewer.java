package com.sunlands.uedService.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chensong on 2015/12/10.
 */
public interface Viewer {
    void setHttpServletResponse(HttpServletResponse response);

    void writeResult(String reuslt, HttpServletResponse response, HttpServletRequest request);
}
