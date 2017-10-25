package controller;

import allservice.NewsService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import entity.NewsEntity;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import util.PagerUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class queryPageNewsAction extends ActionSupport implements ServletRequestAware {
    private HttpServletRequest request;

    private String result;
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    /*private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }*/

    @Override
    public String execute() throws Exception {
        /*HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");*/

        int cp = Integer.parseInt(request.getParameter("cp"));


        NewsService newsService = new NewsService();
        PagerUtil<NewsEntity> list = newsService.queryPageNews(cp,2);

        // 第三：把数据，转换为JSON格式的字符串
        result = new Gson().toJson(list);


        //inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));

        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
}
