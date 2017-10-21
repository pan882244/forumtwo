package allservice;

import allDao.UsersDao;
import entity.UsersEntity;

public class UsersService {
    UsersDao usersDao = new UsersDao();

    //用户注册
    public void register(UsersEntity user) {
        usersDao.insert(user);
    }

    //用户登录以及把用户信息放到作用域
    public UsersEntity login(String account, String password) {

        UsersEntity ue = usersDao.login(account,password);


        return ue;
    }
}
