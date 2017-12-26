package com.sunlands.uedservice.view;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.utils.GsonUtil;
import com.sunlands.uedservice.utils.NameUtil;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 11:11 2017/12/6
 * @ModifiedBy :
 */
public class View {
    private Logger logger = LoggerFactory.getLogger(View.class);
    private static Gson gson = GsonUtil.getGson();
    private static final JsonFactory JSON_FACTORY = new JsonFactory();
    private static Integer LENGTH = 10240;

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
            if (writer != null) {
                writer.close();
            }
        }
    }

	public void viewString(String str, HttpServletResponse response, HttpServletRequest request) {
		logger.info("结果:" + str);
        Cookie[]cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if(NameUtil.JSESSIONID.equalsIgnoreCase(cookie.getName())){
                response.addCookie(cookie);
            }
        }
		setHttpServletResponse(response);
		writeResult(str, response);
	}

    public void viewString(String str, HttpServletResponse response) {
        if (str == null || str.length() < LENGTH) {
            // 10k以下数据显示
            logger.info("结果:" + str);
        }
        setHttpServletResponse(response);
        writeResult(str, response);
    }


    public String viewDetailSet(Map<String, JsonObject> headMap, JsonArray dataArray) {
        StringWriter sw = new StringWriter();
        try {
            JsonGenerator jg = JSON_FACTORY.createJsonGenerator(sw);
            jg.writeStartObject();//mark-0
            jg.writeArrayFieldStart("head");
            for (Map.Entry<String, JsonObject> entry : headMap.entrySet()) {
                jg.writeStartObject();//mark-2
                JsonObject headObj = entry.getValue();
                jg.writeStringField("key", headObj.get("key").getAsString());
                jg.writeStringField("UIFieldName", headObj.get("UIFieldName").getAsString());
                jg.writeStringField("type", headObj.get("type").getAsString());
                jg.writeEndObject();//mark-2
            }
            jg.writeEndArray();//mark-1
            jg.writeArrayFieldStart("data");
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
