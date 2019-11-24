package com.upfile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileControl {
    @PostMapping("/upfile")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
            if (file.isEmpty()) {
                return "上传失败，请选择文件";
            }
            String fileName = file.getOriginalFilename();
            String filePath = "/home/wq/vedio/file";
            File dest = new File(filePath, fileName);
            try {
                file.transferTo(dest);
                return "上传成功";
            } catch (IOException e) {
                System.out.println(e.toString());
                return "上传失败！";
            }
    }
}

