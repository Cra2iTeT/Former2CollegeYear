package com.alice.service;
import com.alice.pojo.CBIS;
import java.util.List;
public interface CbisService {
    List<CBIS> getAllCBIS();
    List<CBIS> selectCbisByNameLike(String UserName);
    CBIS selectCbisByIdNumber(String IdNumber);
    CBIS selectCbisByPhone(String Phone);
    CBIS selectCbisByUserID(String UserID);
    List<CBIS> selectCbisUserAddressLike(String UserAddress);
    int addUser(CBIS cbis);
    int updataUser(CBIS cbis);
    int deleteUser(String UserID);
}