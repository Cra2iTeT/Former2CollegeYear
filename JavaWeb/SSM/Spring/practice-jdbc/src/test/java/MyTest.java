import com.Cra2iTeT.bean.User;
import com.Cra2iTeT.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = context.getBean("userMapper", UserMapper.class);
        List<User> list = mapper.selectUser();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
