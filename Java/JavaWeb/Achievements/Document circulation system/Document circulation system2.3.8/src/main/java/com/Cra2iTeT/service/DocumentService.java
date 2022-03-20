package com.Cra2iTeT.service;

import com.Cra2iTeT.bean.Document;

import java.util.List;
import java.util.Map;

public interface DocumentService {
    //添加公文
    public int addDocument(Map map);

    //查看公文
    public List<Document> queryDocument(Map map);

    //签审公文
    public int updateDocument(Map map);

    //根据id删除公文
    public int deleteDocumentById(int id);


}
