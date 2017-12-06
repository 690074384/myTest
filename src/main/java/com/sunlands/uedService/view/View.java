package com.sunlands.uedService.view;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sunlands.uedService.bean.ResultBean;
import com.sunlands.uedService.utils.GsonUtil;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by lvpenghui on 2017/12/6.
 */
public class View {
    private Logger logger = LoggerFactory.getLogger(View.class);
    private static Gson gson = GsonUtil.getGson();
    private static final JsonFactory jsonFactory = new JsonFactory();

    public void setHttpServletResponse(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "http://angular.js");
        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("application/json");
    }

    public void writeResult(String result, HttpServletResponse response) {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            if (result == null) {
                ResultBean resultBean = new ResultBean();
                resultBean.setCode(0);
                resultBean.setMsg("请求出错");
                writer.write(gson.toJson(resultBean));
                writer.flush();
            } else {
                writer.write(result);
                writer.flush();
            }
        } catch (IOException e) {
            logger.error("", e);
        } finally {
            writer.close();
        }
    }

    public void viewString(String str, HttpServletResponse response, HttpServletRequest request) {
        //logger.info("结果:" + str);
        setHttpServletResponse(response);
        writeResult(str, response);
    }

    public void viewString(String str, HttpServletResponse response) {
        if (str == null || str.length() < 1024 * 10) logger.info("结果:" + str);// 10k以下数据显示
        setHttpServletResponse(response);
        writeResult(str, response);
    }


    public String ViewDetailSet(Map<String, JsonObject> headMap, JsonArray dataArray) {
        StringWriter sw = new StringWriter();
        try {
            JsonGenerator jg = jsonFactory.createJsonGenerator(sw);
            jg.writeStartObject();//mark-0
            jg.writeArrayFieldStart("head");//mark-1
            for (String id : headMap.keySet()) {
                jg.writeStartObject();//mark-2
                JsonObject headObj = headMap.get(id);
                jg.writeStringField("key", headObj.get("key").getAsString());
                jg.writeStringField("UIFieldName", headObj.get("UIFieldName").getAsString());
                jg.writeStringField("type", headObj.get("type").getAsString());
                jg.writeEndObject();//mark-2
            }
            jg.writeEndArray();//mark-1
            jg.writeArrayFieldStart("data");//mark-2
            for (JsonElement item : dataArray) {
                jg.writeStartArray();//mark-3
                JsonObject itemObj = item.getAsJsonObject();
                for (String id : headMap.keySet()) {
                    String value = "";
                    if (itemObj.get(id) != null) {
                        value = itemObj.get(id).getAsString();
                    }
                    jg.writeString(value);
                }
                jg.writeEndArray();//mark-3
            }
            jg.writeEndArray();//mark-2
            jg.writeEndObject();//mark-0
            jg.close();
            return sw.toString();
        } catch (IOException e) {
            logger.error("", e);
        }

        return null;
    }
}
