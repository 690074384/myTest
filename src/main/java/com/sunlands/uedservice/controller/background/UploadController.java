package com.sunlands.uedservice.controller.background;

import com.google.gson.Gson;
import com.sunlands.uedservice.bean.DownloadLocationBean;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.utils.FileUtil;
import com.sunlands.uedservice.utils.GsonUtil;
import com.sunlands.uedservice.utils.ParamUtils;
import com.sunlands.uedservice.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 18:00 2017/12/15
 * @ModifiedBy :
 */
@Controller
@RequestMapping("/background/upload")
public class UploadController {

    private static Gson gson = GsonUtil.getGson();
    private static View view = new View();
    @Autowired
    private DownloadLocationBean downloadLocationBean;



    /**
     * 图片上传  TODO 使用jersey实现应用服务器和图片服务器分离 http://blog.csdn.net/qq_31951571/article/details/49681027
     *
     * @param file
     * @param response
     * @return
     */
    @RequestMapping(value = "/attachment", method = RequestMethod.POST)
    public @ResponseBody
    void attachment(@RequestParam("file") MultipartFile file,
                 HttpServletResponse response) {
        ResultBean resultBean = new ResultBean();
        Map<String, String> map = new HashMap<>(2);
        String filePath = downloadLocationBean.getAttachmentUrl();
        try {
            filePath = FileUtil.uploadFile(file, filePath);
        } catch (Exception e) {
            resultBean.setMsg("附件上传失败！");
            resultBean.setCode(0);
            view.viewString(gson.toJson(resultBean), response);
        }
        map.put("attachmentUrl", filePath);
        resultBean.setData(map);
        resultBean.setMsg("附件上传成功！");
        resultBean.setCode(1);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }

    /**
     * 图片上传 TODO 使用jersey实现应用服务器和图片服务器分离 http://blog.csdn.net/qq_31951571/article/details/49681027
     *
     * @param file
     * @param response
     * @return
     */
    @RequestMapping(value = "/picture", method = RequestMethod.POST)
    public @ResponseBody
    void picture(@RequestParam("file") MultipartFile file,
                   HttpServletResponse response) {
        ResultBean resultBean = new ResultBean();
        Map<String, String> map = new HashMap<>(2);
        String filePath = downloadLocationBean.getPictureUrl();
        try {
            filePath = FileUtil.uploadFile(file, filePath);
        } catch (Exception e) {
            resultBean.setMsg("图片上传失败！");
            resultBean.setCode(0);
            view.viewString(gson.toJson(resultBean), response);
        }
        map.put("pictureUrl", filePath);
        resultBean.setData(map);
        resultBean.setMsg("图片上传成功！");
        resultBean.setCode(1);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }

    /**
     * 测试方法
     * @return
     */
    @RequestMapping(value = "/gouploadimg", method = RequestMethod.GET)
    public ModelAndView goUploadImg() {
        return new ModelAndView("uploadimg");
    }

}
