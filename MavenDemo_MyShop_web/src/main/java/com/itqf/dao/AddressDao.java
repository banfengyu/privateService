package com.itqf.dao;

import com.itqf.entity.Address;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2020/9/17
 * @Time: 上午10:03
 */
public interface AddressDao {

    public List<Address> findAllAddress(int uid) throws SQLException;

    int deleteByAid(int aid) throws SQLException;

    int updateAstateByAid(int aid) throws SQLException;

    int updateAllAstate(int uid) throws SQLException;

    int changeAddressByAid(Address address) throws SQLException;

    int insertAddress(Address address) throws SQLException;
}
