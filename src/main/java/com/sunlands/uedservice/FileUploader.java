package com.sunlands.uedservice;


import org.springframework.web.bind.annotation.*;

/**
 * @author lvpenghui
 * @date 2017/12/4 19:12
 */
@RestController
public class FileUploader {
    public static void main(String[]args){
        System.out.println(1<<1);
    }

    /*//跳转到上传文件的页面
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
            *//*FileUtil.uploadFile(file.getBytes(), filePath, fileName);*//*
            filePath = FileUtil.uploadFile(file , filePath);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return filePath;
    }*/
}
