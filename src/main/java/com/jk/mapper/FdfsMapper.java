package com.jk.mapper;

import com.jk.model.Fdfs;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FdfsMapper {

    List<Fdfs> queryFdfs();

    void addFdfs(Fdfs fdfs);

    void deleteFdfs(String fastId);
}
