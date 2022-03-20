package com.alice.service;
import com.alice.mapper.CbisMapper;
import com.alice.pojo.CBIS;
import java.util.List;
public class CbisServiceImpl implements CbisService{
    private CbisMapper cbisMapper;
    public void setCbisMapper(CbisMapper cbisMapper){this.cbisMapper=cbisMapper;}
    @Override
    public List<CBIS> getAllCBIS() {
        return cbisMapper.getAllCBIS();
    }
    @Override
    public List<CBIS> selectCbisByNameLike(String UserName) {
        return cbisMapper.selectCbisByNameLike(UserName);
    }
    @Override
    public CBIS selectCbisByIdNumber(String IdNumber) {
        return cbisMapper.selectCbisByIdNumber(IdNumber);
    }
    @Override
    public CBIS selectCbisByPhone(String Phone) {
        return cbisMapper.selectCbisByPhone(Phone);
    }
    @Override
    public CBIS selectCbisByUserID(String UserID) {
        return cbisMapper.selectCbisByUserID(UserID);
    }
    @Override
    public List<CBIS> selectCbisUserAddressLike(String UserAddress) {
        return cbisMapper.selectCbisUserAddressLike(UserAddress);
    }
    @Override
    public int addUser(CBIS cbis) {
        return cbisMapper.addUser(cbis);
    }
    @Override
    public int updataUser(CBIS cbis) {
        return cbisMapper.updataUser(cbis);
    }
    @Override
    public int deleteUser(String UserID) {
        return cbisMapper.deleteUser(UserID);
    }
}
