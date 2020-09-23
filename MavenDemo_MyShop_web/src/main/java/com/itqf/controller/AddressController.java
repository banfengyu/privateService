package com.itqf.controller;

import com.itqf.anno.ContentType;
import com.itqf.entity.Address;
import com.itqf.entity.Users;
import com.itqf.service.AddressService;
import com.itqf.service.impl.AddressServiceImpl;
import com.itqf.utils.SysConstant;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小熊猫 2020/9/18 11:38
 */
@WebServlet("/addressController")
public class AddressController extends BaseController {
    AddressService addressService = new AddressServiceImpl();

    public String getAddress(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        Users user = (Users) request.getSession().getAttribute("user");
        List<Address> allAddress = addressService.findAllAddress(user.getId());
        request.setAttribute("allAddress", allAddress);
        return SysConstant.FORWARD + SysConstant.FLAG + "self_info.jsp";
    }

    @ContentType(value = "application/json;charset=utf-8")
    public Map<String,Object> addressDelete(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        int i = addressService.deleteByAid(id);
        Map<String,Object> map = new HashMap<>();
        if (i>0){//有 {data:1}
            map.put("data",1);
        }else {
            map.put("data",0);
        }
        return  map;
    }

    public String addressDefault(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        Users user = (Users) request.getSession().getAttribute("user");
        int  id = Integer.parseInt(request.getParameter("id"));
        addressService.updateDefaultAstate(user.getId(),id);
        return SysConstant.FORWARD + SysConstant.FLAG + "addressController?method=getAddress";
    }

    public String updateAddress(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        int aid = Integer.parseInt(request.getParameter("id"));
        String phone = request.getParameter("phone");
        String detail = request.getParameter("detail");

        Address address = new Address();
        address.setAdetail(detail);
        address.setAname(name);
        address.setAphone(phone);
        address.setAid(aid);

        addressService.changeAddressByAid(address);

        return SysConstant.FORWARD + SysConstant.FLAG + "addressController?method=getAddress";
    }

    public String insertAddress(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        Users user = (Users) request.getSession().getAttribute("user");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String detail = request.getParameter("detail");

        Address address = new Address();
        address.setAdetail(detail);
        address.setAname(name);
        address.setAphone(phone);
        address.setUid(user.getId());

        addressService.insertAddress(address);

        return SysConstant.FORWARD + SysConstant.FLAG + "addressController?method=getAddress";
    }

}
