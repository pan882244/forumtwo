package controller;

import allservice.NewsService;
import com.opensymphony.xwork2.ActionSupport;
import entity.NewsEntity;
import org.apache.struts2.ServletActionContext;
import util.PagerUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class queryPageNewsAction extends ActionSupport{
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int cp = Integer.parseInt(request.getParameter("cp"));

        NewsService newsService = new NewsService();
        PagerUtil<NewsEntity> list = newsService.queryPageNews(cp,2);

        //输出流向客户端发送数据
        PrintWriter out = response.getWriter();
        out.flush();
        out.close();

        return NONE;
    }
}
