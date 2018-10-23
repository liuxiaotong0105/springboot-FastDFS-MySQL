package com.jk.service;

import com.jk.mapper.FdfsMapper;
import com.jk.model.Fdfs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>项目名称：springboot-fastdfs
 * 类名称：FdfsServiceImpl
 * 类描述：
 * 创建人：刘晓彤
 * 创建时间：2018/10/22  20:24
 * 手机号：18511777907&16619767907
 * 备注：生命不息，车轮不止
 */
@Service
public class FdfsServiceImpl implements FdfsService {


    @Autowired
    private FdfsMapper fdfsMapper;

    @Override
    public List<Fdfs> queryFdfs() {
        return fdfsMapper.queryFdfs();
    }

    @Override
    public void addFdfs(Fdfs fdfs) {
         fdfsMapper.addFdfs(fdfs);
    }

    @Override
    public void deleteFdfs(String fastId) {
        fdfsMapper.deleteFdfs(fastId);
    }
}
