package org.andios.servlet.servlet;


import org.andios.servlet.dao.UserDao;
import org.andios.servlet.impl.UserDaoImpl;
import org.andios.servlet.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author BieHongLi
 * @version 创建时间：2017年2月21日 上午10:49:44
 *
 */
@WebServlet("/user/userlogin")
public class UserLoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user=new User();
        //获取login.jsp页面提交的账号和密码
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        //测试数据
        System.out.println(name+" "+password);
        //获取login.jsp页面提交的账号和密码设置到实体类User中
        user.setName(name);
        user.setPassword(password);

        //引入数据交互层
        UserDao dao=new UserDaoImpl();
        User us=dao.login(user);
        //测试返回的值
        System.out.println(us);
        if(us!=null){//键值对
            request.setAttribute("info", "登陆成功");
        }else{
            request.setAttribute("info", "登录失败");
        }

        request.getRequestDispatcher("/index/info.jsp").forward(request, response);
    }



}
