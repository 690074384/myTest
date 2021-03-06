package com.sunlands.uedservice.utils;

import com.google.gson.Gson;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 9:45 2017/12/6
 * @ModifiedBy :
 */
public class ParamUtils {
    private static Logger logger = LoggerFactory.getLogger(ParamUtils.class);
    private static Gson gson = GsonUtil.getGson();
    private static View viewer = new View();
    private static String GET = "GET";

    public static String getParam(HttpServletRequest request) {
        String param;
        String contentType = request.getContentType();
        if (GET.equals(request.getMethod())) {
            param = request.getParameter("param");
        } else {
            if (contentType != null && contentType.contains(NameUtil.APPLICATION)) {
                param = resolveURLENCODERParam(request);
            } else {
                param = getPostParm(request);
            }
        }
        return cleanXSS(param);
    }

    private static String getPostParm(HttpServletRequest request) {
        StringBuffer jb = new StringBuffer();
        String line;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            if (!reader.ready()) {
                return jb.toString();
            }
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            logger.error("读取请求参数出错", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    logger.error("", e);
                }
            }
        }
        return jb.toString();
    }


    public static String encodeURI(String uri) {
        try {
            return URLEncoder.encode(uri, "UTF-8");
        } catch (Exception e) {
            return uri;
        }
    }

    public static int[] parseLimit(String limit) {
        String[] strings = limit.split(",");
        int[] result = new int[2];
        result[0] = Integer.parseInt(strings[0]);
        result[1] = Integer.parseInt(strings[1]);
        return result;
    }

    private static String cleanXSS(String value) {
        if (value == null) {
            return null;
        }
        value = value.replaceAll("eval", "");
        value = value.replaceAll("<script>", "");
        value = value.replaceAll("<javascript>", "");
        return value;
    }

/*    public static void errorParam(HttpServletRequest request, HttpServletResponse resps) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setInfo("请求参数出错");
        viewer.viewString(gson.toJson(resultBean), resps, request);
        return;
    }*/

/*    public static void errorParam(String info, HttpServletRequest req, HttpServletResponse resp) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setInfo(info);
        String data = gson.toJson(resultBean);
        viewer.viewString(data, resp, req);
    }*/

    public static String errorParam(String info) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setInfo(info);
        return gson.toJson(resultBean);
    }

    public static String errorAuthorityParam() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(-2);
        String info = "没有权限";
        resultBean.setInfo(info);
        return gson.toJson(resultBean);
    }

    public static ResultBean errorParamResultBean(String info) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setInfo(info);
        return resultBean;
    }

    public static String errorSessionLosParam() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(-1);
        resultBean.setInfo("session失效");
        return gson.toJson(resultBean);
    }

    /**
     * 解析post请求中 content_type是url_encoded的请求参数
     *
     * @param request 用户请求
     * @return 返回json串
     */
    private static String resolveURLENCODERParam(HttpServletRequest request) {
        String params = null;
        try {
            Map<String, Object> map = new HashMap<>();
            Map<String, String[]> paramMap = request.getParameterMap();

            Iterator<String> it = paramMap.keySet().iterator();

            while (it.hasNext()) {
                String key = it.next();
                String[] values = paramMap.get(key);
                String value = values[0];
                map.put(key, value);
            }

            params = gson.toJson(map);
        } catch (Exception e) {
            logger.error("params resolve error", e);
        }
        return params;
    }

}
