package daotest;

import allDao.NewsDao;
import entity.NewsEntity;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class NewsDaoTest {
    /*@Test
    public void testInsertNews() {
        NewsDao newsDao = new NewsDao();
        NewsEntity newsEntity = new NewsEntity();

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
}
