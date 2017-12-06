package com.sunlands.uedService.utils;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * Created by lvpenghui on 2017/12/6.
 */
public class JsonUtils {
    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
    private static JsonParser jsonParser = new JsonParser();
    static public String GetString(JsonObject jobj, String key) {
        String result = "";
        if (!jobj.has(key)) {
            return result;
        }
        Object tmp_data = jobj.get(key);
        if (null == tmp_data) {
            return result;
        }
        if (tmp_data instanceof String) {
            result = jobj.get(key).getAsString();
        } else if (tmp_data instanceof Integer) {
            result = String.valueOf(jobj.get(key).getAsInt());
        } else if (tmp_data instanceof Double) {
            result = String.valueOf(jobj.get(key).getAsDouble());
        } else if (tmp_data instanceof Long) {
            result = String.valueOf(jobj.get(key).getAsLong());
        } else if (tmp_data instanceof Boolean) {
            result = String.valueOf(jobj.get(key).getAsBoolean());
        }
        return result;
    }

    public static JsonObject getJsonObject(String param) {
        try {
            return jsonParser.parse(param).getAsJsonObject();
        } catch (Exception e) {
            return null;
        }
    }


}
