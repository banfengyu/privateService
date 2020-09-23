package com.itqf.dao.impl;

import com.itqf.dao.AddressDao;
import com.itqf.entity.Address;
import com.itqf.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2020/9/17
 * @Time: 上午10:04
 */
public class AddressDaoImpl implements AddressDao {

    QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());//connection

    @Override
    public List<Address> findAllAddress(int uid) throws SQLException {
        String sql="select a_id as aid,a_name as aname,a_phone as aphone ,a_detail as adetail" +
                ",a_state as astate from address where u_id=?";

        return queryRunner.query(sql,new BeanListHandler<Address>(Address.class),uid);//
    }

    @Override
    public int deleteByAid(int aid) throws SQLException {
        String sql="delete from address where a_id=?";
        return queryRunner.update(sql, aid);
    }

    @Override
    public int updateAstateByAid(int aid) throws SQLException {
        String sql="update address set a_state = 1 where a_id = ?";
        return queryRunner.update(sql, aid);
    }

    @Override
    public int updateAllAstate(int uid) throws SQLException {
        String sql="update address set a_state = 0 where u_id = ?";
        return queryRunner.update(sql, uid);
    }

    @Override
    public int changeAddressByAid(Address address) throws SQLException{
        String sql="update address set a_name=?,a_phone=?,a_detail=? where a_id=?";
        return queryRunner.update(sql, address.getAname(),address.getAphone(),address.getAdetail(),address.getAid());
    }

    @Override
    public int insertAddress(Address address) throws SQLException {
        String sql="insert into address(a_name,a_phone,a_detail,u_id,a_state) values(?,?,?,?,0)";
        return queryRunner.update(sql, address.getAname(), address.getAphone(), address.getAdetail(), address.getUid());
    }
}
