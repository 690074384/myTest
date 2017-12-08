package com.sunlands.uedservice.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 9:45 2017/12/6
 * @ModifiedBy :
 *
*/
public class GsonUtil {
    private static Gson gson = null;

    static {
        ExclusionStrategy myExclusionStrategy = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fa) {
                return fa.getName().startsWith("CGLIB");
            }
            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        gson = new GsonBuilder()
                .setExclusionStrategies(myExclusionStrategy)
                .disableHtmlEscaping()
                .create();
    }

    public static Gson getGson() {
        return gson;
    }

    public static void main(String[] args) {

    }
}
