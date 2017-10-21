package allDao;

import entity.NewsEntity;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class NewsDao {
    EntityManagerFactory factory = JPAUtil.getFactory();
    EntityManager manager = factory.createEntityManager();

    //查询全部留言
    public List<NewsEntity> queryNews() {
        String hql = "select n from NewsEntity n";
        Query q = manager.createQuery(hql,NewsEntity.class);
        List<NewsEntity> list = q.getResultList();
        manager.close();
        return list;
    }

    //分页查询留言
    public List<NewsEntity> queryPageNews(int maxResults,int firstResult) {
        String hql = "select n from NewsEntity n";
        Query q = manager.createQuery(hql,NewsEntity.class);
        //设置每页显示多少个，设置多大结果。
        q.setMaxResults(maxResults);
        //设置起点
        q.setFirstResult(firstResult);
        List<NewsEntity> list = q.getResultList();
        manager.close();
        return list;
    }

    //添加留言
    public void insertNews(NewsEntity ne) {
        manager.getTransaction().begin();

        //定义对象
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setId(ne.getId());
        newsEntity.setLoginuserHead(ne.getLoginuserHead());
        newsEntity.setUsersByAuthorId(ne.getUsersByAuthorId());
        newsEntity.setUserAccount(ne.getUserAccount());
        newsEntity.setTitle(ne.getTitle());
        newsEntity.setContent(ne.getContent());
        newsEntity.setGenTime(ne.getGenTime());

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
