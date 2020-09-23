package com.itqf.service.impl;

import com.itqf.dao.AddressDao;
import com.itqf.dao.impl.AddressDaoImpl;
import com.itqf.entity.Address;
import com.itqf.service.AddressService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2020/9/17
 * @Time: 上午10:11
 */
public class AddressServiceImpl implements AddressService {

    AddressDao addressDao = new AddressDaoImpl();//以后--->解耦 Spring

    @Override
    public List<Address> findAllAddress(int uid) throws SQLException {
        return addressDao.findAllAddress(uid);
    }

    @Override
    public int deleteByAid(int id) throws SQLException {
        return addressDao.deleteByAid(id);
    }

    @Override
    public int changeAddressByAid(Address address) throws SQLException {
        return addressDao.changeAddressByAid(address);
    }

    @Override
    public int insertAddress(Address address) throws SQLException {
        return addressDao.insertAddress(address);
    }

    @Override
    public int updateDefaultAstate(int uid, int aid) throws SQLException{
        addressDao.updateAllAstate(uid);
        return addressDao.updateAstateByAid(aid);
    }
}
