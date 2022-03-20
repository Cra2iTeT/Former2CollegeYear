package com.Cra2iTeT.service.impl;

import com.Cra2iTeT.dao.FmDao;
import com.Cra2iTeT.pojo.Document;
import com.Cra2iTeT.service.FmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("Fm1Service")
public class FmServiceImpl implements FmService {

    @Autowired
    private FmDao fmDao;

    @Override
    public List<Document> docList() {
        return fmDao.docList();
    }

    @Override
    public Document selectDocById(int id) {
        return fmDao.selectDocById(id);
    }

    @Override
    public int updateDoc(Map map) {
        return fmDao.updateDoc(map);
    }
}
