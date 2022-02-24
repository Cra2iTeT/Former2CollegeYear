import com.Cra2iTeT.bean.Teacher;
import com.Cra2iTeT.mapper.TeacherMapper;
import com.Cra2iTeT.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

//    @Test
//    public void test() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//
//        List<Teacher> teacherList = mapper.getTeacher();
//
//        for (Teacher teacher : teacherList) {
//            System.out.println(teacher);
//        }
//
//        sqlSession.close();
//    }

//    @Test
//    public void test() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//
//        Teacher teacher = mapper.getTeacher(1);
//
//        System.out.println(teacher);
//
//        sqlSession.close();
//    }

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher2(1);

        System.out.println(teacher);

        sqlSession.close();
    }
}
