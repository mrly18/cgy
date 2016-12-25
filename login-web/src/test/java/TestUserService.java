import com.login.User;
import com.login.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lenovo on 2016/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestUserService {
    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser(){
        boolean b1=userService.hasMatchUser("admin","123456");
        Assert.assertEquals(true,b1);
    }

    @Test
    public void findUserByUserName(){
        User user=userService.findUserByUserName("admin");
        Assert.assertEquals(1,user.getUserId());
    }
}
