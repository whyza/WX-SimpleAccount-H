package com.simpleaccount.controller;

import com.simpleaccount.util.imagesutil.FtpUtil;
import com.simpleaccount.util.imagesutil.QiniuFileUploadUtil;
import com.simpleaccount.util.resultutil.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/17 11:51
 * @Version: 1.0
 */
@Controller
public class ImageUploadController {
    /**
     * 文件上传类
     * 文件会自动绑定到MultipartFile中
     *
     * @param file    上传的文件
     * @return 上传成功或失败结果
     */
    @ResponseBody
    @RequestMapping("/upload")
    public ResultUtil<String> uploadImg(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = "", msg = "上传失败";
        if (FtpUtil.uploadFile(fileName,file.getInputStream())) {
            filePath = fileName;
            msg = "上传成功";
        }
        //该路径图片名称，前端框架可用ngnix指定的路径+filePath,即可访问到ngnix图片服务器中的图片
        return new ResultUtil<>(msg, filePath);
    }

    @ResponseBody
    @RequestMapping(value = "/getToken",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultUtil<String> getToken(){
        return new ResultUtil<>("",QiniuFileUploadUtil.getUpToken());
    }
}
