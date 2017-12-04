package com.sunlands.uedService;


import com.sunlands.uedService.Utils.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lvpenghui
 * @date 2017/12/4 19:12
 */
@RestController
public class FileUploader {

    //跳转到上传文件的页面
    @RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
    public ModelAndView goUploadImg() {
        return new ModelAndView("uploadimg");
    }

    //处理文件上传
    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody
    String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request) {

       // String fileName = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            /*FileUtil.uploadFile(file.getBytes(), filePath, fileName);*/
            filePath = FileUtil.uploadFile(file , filePath);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return filePath;
    }
}
