package com.jk.service;

import com.jk.model.Fdfs;

import java.util.List;

public interface FdfsService {
    List<Fdfs> queryFdfs();

    void addFdfs(Fdfs fdfs);

    void deleteFdfs(String fastId);
}
