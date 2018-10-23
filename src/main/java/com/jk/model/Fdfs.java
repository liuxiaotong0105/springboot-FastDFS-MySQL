package com.jk.model;

import java.io.Serializable;

/**
 * <pre>项目名称：springboot-fastdfs
 * 类名称：Fdfs
 * 类描述：
 * 创建人：刘晓彤
 * 创建时间：2018/10/22  19:53
 * 手机号：18511777907&16619767907
 * 备注：生命不息，车轮不止
 */

public class Fdfs implements Serializable {

    private Integer fdfsId;

    private String fdfsHttp;

    private String fdfsUrl;



    public Integer getFdfsId() {
        return fdfsId;
    }

    public void setFdfsId(Integer fdfsId) {
        this.fdfsId = fdfsId;
    }

    public String getFdfsHttp() {
        return fdfsHttp;
    }

    public void setFdfsHttp(String fdfsHttp) {
        this.fdfsHttp = fdfsHttp;
    }

    public String getFdfsUrl() {
        return fdfsUrl;
    }

    public void setFdfsUrl(String fdfsUrl) {
        this.fdfsUrl = fdfsUrl;
    }







}
