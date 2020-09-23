package com.itqf.service;

import com.itqf.entity.Orders;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2020/9/17
 * @Time: 下午4:42
 */
public interface OrderDetailService {


    public Orders findOrderAndDetail(String oid) throws  Exception;


}
