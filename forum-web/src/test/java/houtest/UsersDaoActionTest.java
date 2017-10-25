package houtest;

import com.opensymphony.xwork2.ActionProxy;
import controller.UserLoginAction;
import entity.UsersEntity;
import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

public class UsersDaoActionTest extends StrutsTestCase {
    @Test
    public void testExecute() throws Exception {
        request.getParameter("zss");
        request.getParameter("123");

        //获取ActionProxy
        ActionProxy actionProxy = getActionProxy("/login");
        actionProxy.setExecuteResult(false);

        UserLoginAction userLoginAction = (UserLoginAction) actionProxy.getAction();
        String result = actionProxy.execute();


    }

}
