package com.example.demo.controller;

import java.io.File;
import java.util.Set;

import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.domain.MateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.config.FastDFSClientUtil;
import com.github.tobato.fastdfs.service.FastFileStorageClient;


@RestController
public class UploadController {
	
	@Autowired
    private FastDFSClientUtil dfsClient;
	
	@Autowired
    FastFileStorageClient fastFileStorageClient;

	
	// 上传图片
    @PostMapping(value = "/upload")
    public String upload(MultipartFile file) throws Exception{
    	String imgUrl = dfsClient.uploadFile(file);
        return imgUrl;
    }
    
    // 文件路径上传
    @PostMapping(value = "/fileUpload")
    public String fileUpload() throws Exception{
    	File file = new File("F:\\timg.jpg");
//    	StorePath imgUrl = fastFileStorageClient.uploadFile(null, new FileInputStream(file), file.length(), "jpg");
        String imgUrl = dfsClient.uploadFile(file);
        System.out.println(imgUrl);
    	return imgUrl;
    }

    @PostMapping(value = "/filedelete")
    public Set<MateData> filedelete() throws Exception{
        dfsClient.deleteFile("group1/M00/00/01/rBCFo1unNuWAW9RJAAUFLq3fs_g827.jpg");
        return null;
    }

    @PostMapping(value = "/fileDetail")
    public void fileDetail(String filepath){
        FileInfo fileInfo = dfsClient.getFileDetail("group1", filepath);
        long fileSize = fileInfo.getFileSize();
        int crc32 = fileInfo.getCrc32();
        System.out.println("fileSize="+fileSize);
        System.out.println("crc32="+crc32);
    }
}
