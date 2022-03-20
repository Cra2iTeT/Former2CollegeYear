import com.Cra2iTeT.bean.User;
import com.Cra2iTeT.mapper.UserMapper;
import com.Cra2iTeT.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user1 = mapper.queryUserById(2);
        System.out.println(user1);

        sqlSession.close();
    }
}
