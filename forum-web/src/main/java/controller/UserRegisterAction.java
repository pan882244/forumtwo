package controller;

import allservice.UsersService;
import com.opensymphony.xwork2.ActionSupport;
import entity.UsersEntity;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        //邮箱正则规则
        String regEx = "/^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$/";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(email);
        boolean m = matcher.matches();
        System.out.println("邮箱："+m);

        if(m=false) {
            return "error";
        }

        usersEntity.setPassword(password);
        usersEntity.setEmail(email);

        //调用service
        usersService.register(usersEntity);

        return SUCCESS;
    }
}
