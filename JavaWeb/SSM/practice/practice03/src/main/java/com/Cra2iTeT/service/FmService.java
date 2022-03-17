package com.Cra2iTeT.service;

import com.Cra2iTeT.pojo.Document;

import java.util.List;
import java.util.Map;

public interface FmService {
    //浏览所有已发公文
    public List<Document> docList();

    //查询公文，通过id
    public Document selectDocById(int id);

    //修改公文
    public int updateDoc(Map map);
}
