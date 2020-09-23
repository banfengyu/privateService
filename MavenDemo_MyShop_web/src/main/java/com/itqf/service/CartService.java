package com.itqf.service;

import com.itqf.entity.Cart;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2020/9/16
 * @Time: 上午11:24
 */
public interface CartService {


    public int addCart(Cart cart) throws  Exception;

    public List<Cart>  findAllCart(int uid) throws  Exception;

    public int updateNum(int pid, int uid, BigDecimal price, String flag) throws  Exception;

    public  boolean delete(int uid, int pid)throws  Exception;
}
