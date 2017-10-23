package controller;

import allservice.NewsService;
import allservice.UsersService;
import com.opensymphony.xwork2.ActionSupport;
import entity.NewsEntity;
import entity.UsersEntity;
import org.apache.struts2.ServletActionContext;

import util.PagerUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class UserLoginAction extends ActionSupport {

    UsersService usersService = new UsersService();
    NewsService newsService = new NewsService();

    @Override
    public String execute() throws Exception {


        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        //编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //System.out.println(account);
        //判断
        if(account == null && password == null || "".equals(account) && "".equals(password) || "".equals(account) || "".equals(password)) {

            return "error";
        }

        UsersEntity user = usersService.login(account,password);


        if(user == null) {
            return "error";
        }

        //将用户设置到作用域
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("user",user);

        PagerUtil<NewsEntity> list = newsService.queryPageNews(1,2);
        //System.out.println("分页后数据"+list.getData().size());
        request.setAttribute("list",list);


        return SUCCESS;
    }
}
