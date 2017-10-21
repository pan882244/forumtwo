package controller;

import allservice.UsersService;
import com.opensymphony.xwork2.ActionSupport;
import entity.UsersEntity;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class UserRegisterAction extends ActionSupport {
    @Override
    public String execute() {
        UsersService usersService = new UsersService();
        UsersEntity usersEntity = new UsersEntity();

        //页面获取数据
        HttpServletRequest request = ServletActionContext.getRequest();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        //设置实体对象数据
        usersEntity.setAccount(account);
        usersEntity.setPassword(password);
        usersEntity.setEmail(email);

        //调用service
        usersService.register(usersEntity);

        return SUCCESS;
    }
}
