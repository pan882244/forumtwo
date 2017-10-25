package daotest;

import allDao.UsersDao;
import entity.UsersEntity;
import org.junit.Assert;
import org.junit.Test;

public class UserDaoTest {
    UsersDao usersDao = new UsersDao();
    /*@Test
    public void zhuce() {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setAccount("qbb");
        usersEntity.setPassword("123");
        usersEntity.setEmail("123@qq.com");

        usersDao.insert(usersEntity);
    }

    @Test
    public void denglu() {

        UsersEntity list = usersDao.login("zss","123");

        System.out.println(list.getAccount());
    }*/

    /*@Test
    public void testLogin() {
        UsersEntity usersEntity = usersDao.login("zss","123");

        if("".equals(usersEntity)) {
            Assert.fail("登录失败");
        } else {
            System.out.println("登录成功");
        }
    }*/
}
