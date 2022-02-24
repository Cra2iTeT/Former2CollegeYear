import com.Cra2iTeT.bean.Student;
import com.Cra2iTeT.bean.Teacher;
import com.Cra2iTeT.mapper.StudentMapper;
import com.Cra2iTeT.mapper.TeacherMapper;
import com.Cra2iTeT.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TeacherTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> stuList = mapper.getStuList();
        for (Student _Stu : stuList) {
            System.out.println(_Stu);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> stuList = mapper.getStuList2();
        for (Student _Stu : stuList) {
            System.out.println(_Stu);
        }
        sqlSession.close();
    }
}
