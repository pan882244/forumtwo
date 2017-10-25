package daotest;

import allDao.NewsDao;
import entity.NewsEntity;
import org.junit.*;
import util.PagerUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class NewsDaoTest {
    NewsDao newsDao = new NewsDao();
    /*@Test
    public void testInsertNews() {
        NewsDao newsDao = new NewsDao();
        final NewsEntity newsEntity = new NewsEntity();

        String uuId = UUID.randomUUID().toString();
        newsEntity.setId(uuId);
        newsEntity.setUserAccount("111");
        newsEntity.setTitle("第五次留言");
        newsEntity.setContent("哈哈哈哈哈哈哈哈");

        Date date = new Date();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(date);
        ts = Timestamp.valueOf(strDate);
        newsEntity.setGenTime(ts);

        newsDao.insertNews(newsEntity);

    }*/

    /*@Test
    public void testQueryNews() {
        List<NewsEntity> list = newsDao.queryNews();

        if(list.size()==0) {
            Assert.fail("结果为空");
        } else {
            System.out.println("数据为："+list.size());
        }
    }*/

    /*@Test
    public void testQueryPageNews() {
        PagerUtil<NewsEntity> list = newsDao.queryPageNews(1,3);

        for(NewsEntity newsEntity : list.getData() ) {
            System.out.println("id"+newsEntity.getId());

        }

    }*/
}
