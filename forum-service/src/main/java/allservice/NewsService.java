package allservice;

import allDao.NewsDao;
import entity.NewsEntity;

import java.util.List;


public class NewsService {
    NewsDao newsDao = new NewsDao();

    //查询全部留言
    public List<NewsEntity> queryNews() {
        List<NewsEntity> list = newsDao.queryNews();
        return list;
    }

    //分页查询留言
    public List<NewsEntity> queryPageNews(int maxResults,int firstResult) {
        List<NewsEntity> list = newsDao.queryPageNews(maxResults, firstResult);
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
