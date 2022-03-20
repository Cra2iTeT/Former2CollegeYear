package com.Cra2iTeT.service.impl;

import com.Cra2iTeT.bean.Document;
import com.Cra2iTeT.dao.DocumentDao;
import com.Cra2iTeT.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("DocumentService")
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDao documentDao;

    @Override
    public int addDocument(Map map) {
        return documentDao.addDocument(map);
    }

    @Override
    public List<Document> queryDocument(Map map) {
        return documentDao.queryDocument(map);
    }

    @Override
    public int updateDocument(Map map) {
        return documentDao.updateDocument(map);
    }

    @Override
    public int deleteDocumentById(int id) {
        return documentDao.deleteDocumentById(id);
    }
}
