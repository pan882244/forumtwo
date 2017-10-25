package allDao;

import entity.NewsEntity;
import entity.Page;
import entity.UsersEntity;
import util.JPAUtil;
import util.PagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class NewsDao {
    EntityManagerFactory factory = JPAUtil.getFactory();
    EntityManager manager = factory.createEntityManager();

    //查询全部留言
    public List<NewsEntity> queryNews() {
        String hql = "select n from NewsEntity n order by n.genTime desc";
        Query q = manager.createQuery(hql,NewsEntity.class);
        List<NewsEntity> list = q.getResultList();

        return list;
    }

    //分页查询留言
    public PagerUtil<NewsEntity> queryPageNews(int currentPage, int pageCount) {
        PagerUtil<NewsEntity> pagerUtil = new  PagerUtil<NewsEntity>() ;
        String hql = "select n from NewsEntity n order by n.genTime desc";
        Query q = manager.createQuery(hql,NewsEntity.class);
        //总记录数
        int cout = q.getResultList().size();
        //System.out.println("总记录数"+cout);
        //设置每页显示多少个，设置多大结果。
        q.setMaxResults(pageCount);
        //设置起点
        q.setFirstResult((currentPage-1)*pageCount);
        List<NewsEntity> list = q.getResultList();

        //处理懒加载
        List<NewsEntity> list1 = new ArrayList<NewsEntity>();
        for(NewsEntity ne : list ) {
            NewsEntity newsEntity = new NewsEntity();
            UsersEntity usersEntity = new UsersEntity();

            newsEntity.setId(ne.getId());
            newsEntity.setContent(ne.getContent());
            newsEntity.setTitle(ne.getTitle());
            newsEntity.setGenTime(ne.getGenTime());
            newsEntity.setUserAccount(ne.getUserAccount());
            newsEntity.setLoginuserHead(ne.getLoginuserHead());
            /*usersEntity.setId(usersEntity.getId());
            newsEntity.setUsersByAuthorId(usersEntity);*/

            list1.add(newsEntity);
        }

        pagerUtil.setTotalRecords(cout);
        //2.设置每页显示的记录数
        pagerUtil.setPageCount(pageCount) ;

        //3.设置当前页
        pagerUtil.setCurrentPage(currentPage) ;


        pagerUtil.setData(list1) ;
        manager.close();
        return pagerUtil;
    }

    //添加留言
    public void insertNews(NewsEntity ne) {
        manager.getTransaction().begin();

        //定义对象
        NewsEntity newsEntity = new NewsEntity();
        String uuId = UUID.randomUUID().toString();
        newsEntity.setId(uuId);
        newsEntity.setLoginuserHead(ne.getLoginuserHead());
        newsEntity.setUsersByAuthorId(ne.getUsersByAuthorId());
        newsEntity.setUserAccount(ne.getUserAccount());
        newsEntity.setTitle(ne.getTitle());
        newsEntity.setContent(ne.getContent());

        Date date = new Date();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(date);
        ts = Timestamp.valueOf(strDate);
        newsEntity.setGenTime(ts);

        manager.persist(newsEntity);

        manager.getTransaction().commit();
        manager.close();
    }

    //删除留言
    public void deleteNews(String id) {
        manager.getTransaction().begin();
        Query q=manager.createQuery("delete from NewsEntity ne where ne.id=:id");
        q.setParameter("id",id);
        q.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
    }

    //修改留言
    public void updateNews(NewsEntity ne) {
        manager.getTransaction().begin();
        Query q=manager.createQuery("update NewsEntity ne set ne.title=:title, ne.content=:content where ne.id=:id");
        q.setParameter("id",ne.getId());
        q.setParameter("title",ne.getTitle());
        q.setParameter("content",ne.getContent());

        q.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
    }

    public NewsEntity queryById(String id) {
        String hql = "select ne from NewsEntity ne where ne.id=:id";
        Query q = manager.createQuery(hql,NewsEntity.class);
        q.setParameter("id",id);
        NewsEntity list = (NewsEntity) q.getSingleResult();

        manager.close();
        return list;
    }
}
