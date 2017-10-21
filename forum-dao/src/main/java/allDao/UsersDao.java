package allDao;

import entity.UsersEntity;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UsersDao {
    private EntityManagerFactory factory = JPAUtil.getFactory();
    EntityManager manager = factory.createEntityManager();




    //用户注册(需要id,Account,email,gendar,password,注册时间)
    public void insert(UsersEntity user) {
        manager.getTransaction().begin();

        UsersEntity usersEntity = new UsersEntity();
        String uuId = UUID.randomUUID().toString();
        usersEntity.setId(uuId);
        usersEntity.setAccount(user.getAccount());
        usersEntity.setGendar("男");
        usersEntity.setPassword(user.getPassword());
        usersEntity.setEmail(user.getEmail());

        Date date = new Date();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(date);
        ts = Timestamp.valueOf(strDate);
        usersEntity.setRegTime(ts);

        manager.persist(usersEntity);

        manager.getTransaction().commit();
        manager.close();
    }

    //用户登录并把用户信息放到作用域里
    public UsersEntity login(String account, String password) {
        String hql = "select ue from UsersEntity ue where ue.account=:account and password=:password";
        Query q = manager.createQuery(hql, UsersEntity.class);
        q.setParameter("account",account);
        q.setParameter("password",password);
        List list = q.getResultList();

        //处理getSingleResult()为空的异常
        UsersEntity user = null;
        if(list.size()==1) {
            user = (UsersEntity) list.get(0);

        } else {
            user = null;

        }


        //System.out.println(user);
        manager.close();
        return user;
    }
}
