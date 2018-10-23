package com.jk.controller;

import com.jk.config.FastDFSClientUtil;
import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.jk.model.Fdfs;
import com.jk.service.FdfsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * <pre>项目名称：springboot-fastdfs
 * 类名称：Fdfs
 * 类描述：
 * 创建人：刘晓彤
 * 创建时间：2018/10/22  19:53
 * 手机号：18511777907&16619767907
 * 备注：生命不息，车轮不止
 */

@Controller
@RequestMapping("fdfs")
public class UploadController {

    @Autowired
    private FdfsService fdfsService;

	@Autowired
    private FastDFSClientUtil dfsClient;
	
	@Autowired
    FastFileStorageClient fastFileStorageClient;


    //跳查
    @RequestMapping("toMain")
    public String toMain(){
        return "showFdfs";
    }

    //查
    @RequestMapping("queryFdfs")
    @ResponseBody
    public List<Fdfs> queryFdfs(){
        List<Fdfs> list = fdfsService.queryFdfs();
        return list;
    }

    //跳转增
    @RequestMapping("toAddFdfs")
    public String toAddFdfs(){
        return "addFdfs";
    }

    // 上传文件
    @RequestMapping("uploadFdfs")
    public String uploadFdfs(MultipartFile file,Fdfs fdfs) throws Exception{
        String imgUrl = dfsClient.uploadFile(file);
        fdfs.setFdfsUrl(imgUrl);
        System.out.println(imgUrl);
        fdfsService.addFdfs(fdfs);
        return "redirect:toMain";
    }

    //打开浏览器  浏览文件
    @RequestMapping("openExplorer")
    @ResponseBody
    public  void openExplorer(String urls) {
        try {
            ProcessBuilder proc = new ProcessBuilder(
                    "C:\\Users\\LXT\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe", urls);
            proc.start();
        } catch (Exception e) {
            System.out.println("Error executing progarm.");
        }
    }

    //删除
    @RequestMapping("deleteFdfs")
    @ResponseBody
    public boolean deleteFdfs(String url,String fastId) throws Exception{
//      dfsClient.deleteFile("group1/M00/00/01/rBCFo1unNuWAW9RJAAUFLq3fs_g827.jpg");
        boolean result = dfsClient.deleteFile(url);
        if(result){
            fdfsService.deleteFdfs(fastId);
        }
        return result;
    }









    ///////////////////////////////////////////////////////////////////////////////////////////////


/*
	// 上传图片
    @RequestMapping("upload")
    public String upload(MultipartFile file) throws Exception{
    	String imgUrl = dfsClient.uploadFile(file);
        System.out.println(imgUrl);
        return imgUrl;
    }
    
    // 文件路径上传
    @RequestMapping("fileUpload")
    public String fileUpload() throws Exception{
    	File file = new File("C:\\Users\\LXT\\Desktop\\111.jpg");
//    	StorePath imgUrl = fastFileStorageClient.uploadFile(null, new FileInputStream(file), file.length(), "jpg");
        String imgUrl = dfsClient.uploadFile(file);
        System.out.println(imgUrl);
    	return imgUrl;
    }

    @RequestMapping("filedelete")
    public boolean filedelete(String allFilePath) throws Exception{
//      dfsClient.deleteFile("group1/M00/00/01/rBCFo1unNuWAW9RJAAUFLq3fs_g827.jpg");
        boolean result = dfsClient.deleteFile(allFilePath);
        return result;
    }

    @RequestMapping("fileDetail")
    public FileInfo fileDetail(String group,String filepath){
//        FileInfo fileInfo = dfsClient.getFileDetail("group1", "M00/00/01/rBCFo1unNuWAW9RJAAUFLq3fs_g827.jpg");
        FileInfo fileInfo = dfsClient.getFileDetail(group, filepath);
        long fileSize = fileInfo.getFileSize();
        int crc32 = fileInfo.getCrc32();
        System.out.println("fileSize="+fileSize);
        //可以用crc32校验文件是否相同,做秒传功能
        System.out.println("crc32="+crc32);
        return fileInfo;
    }*/
}
