package allservice;

import allDao.NewsDao;
import entity.NewsEntity;
import entity.Page;
import entity.UsersEntity;
import util.PagerUtil;

import java.util.ArrayList;
import java.util.List;


public class NewsService {
    NewsDao newsDao = new NewsDao();

    //查询全部留言
    public List<NewsEntity> queryNews() {
        List<NewsEntity> list = newsDao.queryNews();
        return list;
    }

    //分页查询留言
    public PagerUtil<NewsEntity> queryPageNews(int currentPage, int pageCount) {
        /*PagerUtil<NewsEntity> pagerUtil = new  PagerUtil<NewsEntity>() ;
        int sa = queryNews().size();
        //System.out.println("总记录数"+sa);

        pagerUtil.setTotalRecords(sa);
        //2.设置每页显示的记录数
        pagerUtil.setPageCount(pageCount) ;

        //3.设置当前页
        pagerUtil.setCurrentPage(currentPage) ;*/


        PagerUtil<NewsEntity> list = newsDao.queryPageNews(currentPage,pageCount);

        return list;
    }

    //添加留言
    public void insertNews(NewsEntity ne) {
        newsDao.insertNews(ne);

    }

    //删除留言
    public void deleteNews(String id) {
        newsDao.deleteNews(id);
    }

    //修改留言
    public void updateNews(NewsEntity ne) {
        newsDao.updateNews(ne);
    }

    public NewsEntity queryById(String id) {
        NewsEntity list = newsDao.queryById(id);
        return list;
    }
}
