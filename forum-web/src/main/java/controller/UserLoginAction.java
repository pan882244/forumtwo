package controller;

import allservice.UsersService;
import com.opensymphony.xwork2.ActionSupport;
import entity.UsersEntity;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class UserLoginAction extends ActionSupport {

    UsersService usersService = new UsersService();

    @Override
    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println(account);
        //判断
        if(account == null && password == null || "".equals(account) && "".equals(password) || "".equals(account) || "".equals(password)) {

            return "error";
        }

        UsersEntity user = usersService.login(account,password);

        System.out.println("登录用户"+user);
        if(user == null) {
            return "error";
        }

        request.setAttribute("user",user);
        return SUCCESS;


    }
}
