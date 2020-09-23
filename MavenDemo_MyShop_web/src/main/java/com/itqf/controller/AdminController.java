package com.itqf.controller;

import com.itqf.dao.OrderDao;
import com.itqf.dao.TypesDao;
import com.itqf.dao.impl.OrderDaoImpl;
import com.itqf.dao.impl.TypesDaoImpl;
import com.itqf.entity.Users;
import com.itqf.service.ProductService;
import com.itqf.service.UserService;
import com.itqf.service.impl.ProductServiceImpl;
import com.itqf.service.impl.UserServiceImpl;
import com.itqf.utils.SysConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 小熊猫 2020/9/20 17:26
 */
@WebServlet("/adminController")
public class AdminController extends BaseController {
    ProductService productService = new ProductServiceImpl();
    UserService userService = new UserServiceImpl();
    TypesDao typesDao = new TypesDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();
    
    public  String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //登录
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        String code = req.getParameter("code");
        String scode = (String) req.getSession().getAttribute("code");
        try {
            Users admin = userService.login(name, password);
            if (admin != null && admin.getUrole() == SysConstant.USER_RIGHT) {
                req.setAttribute("msg", "账号没有管理员权限");
            } else if (admin != null && admin.getUstatus() == SysConstant.ROLE_RIGHT) {
                req.getSession().setAttribute("admin", admin);//redis
                return SysConstant.FORWARD + SysConstant.FLAG + "admin/admin.jsp";
            } else {
                req.setAttribute("msg", "用户名或者密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysConstant.FORWARD + SysConstant.FLAG + "admin/login.jsp";

    }

    public String getGoodsType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String flag = req.getParameter("flag");

        if ("show".equals(flag)){
            return SysConstant.FORWARD + SysConstant.FLAG + "admin/showGoodsType.jsp";
        }else {
            return SysConstant.FORWARD + SysConstant.FLAG + "admin/addGoodsType.jsp";
        }
    }

    public String getGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String flag = req.getParameter("flag");

        if ("show".equals(flag)){
            return SysConstant.FORWARD + SysConstant.FLAG + "admin/showGoods.jsp";
        }else {
            return SysConstant.FORWARD + SysConstant.FLAG + "admin/addGoods.jsp";
        }
    }

    public String userList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String flag = req.getParameter("flag");

        if ("useful".equals(flag)){
            return SysConstant.FORWARD + SysConstant.FLAG + "admin/userList.jsp";
        }else {
            return SysConstant.FORWARD + SysConstant.FLAG + "admin/invalidUser.jsp";
        }
    }
}
