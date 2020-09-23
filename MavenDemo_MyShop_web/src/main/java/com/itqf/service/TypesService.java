package com.itqf.service;

import com.itqf.entity.Types;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2020/9/15
 * @Time: 下午3:42
 */
public interface TypesService {

    public List<Types> findAll()throws SQLException;
}
