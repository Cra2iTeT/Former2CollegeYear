import com.Cra2iTeT.bean.Blog;
import com.Cra2iTeT.bean.T;
import com.Cra2iTeT.mapper.BlogMapper;
import com.Cra2iTeT.mapper.TMapper;
import com.Cra2iTeT.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTest {
//    @Test
//    public void test(){
//        SqlSession session = MybatisUtils.getSqlSession();
//        BlogMapper mapper = session.getMapper(BlogMapper.class);
//
//        Blog blog = new Blog();
//        blog.setId(IdUtiles.getId());
//        blog.setTitle("Mybatis如此简单");
//        blog.setAuthor("狂神说");
//        blog.setCreateTime(new Date());
//        blog.setViews(9999);
//
//        mapper.addBlog(blog);
//
//        blog.setId(IdUtiles.getId());
//        blog.setTitle("Java如此简单");
//        mapper.addBlog(blog);
//
//        blog.setId(IdUtiles.getId());
//        blog.setTitle("Spring如此简单");
//        mapper.addBlog(blog);
//
//        blog.setId(IdUtiles.getId());
//        blog.setTitle("微服务如此简单");
//        mapper.addBlog(blog);
//
//        session.close();
//    }

//    @Test
//    public void test() {
//        SqlSession session = MybatisUtils.getSqlSession();
//        BlogMapper mapper = session.getMapper(BlogMapper.class);
//
//        HashMap hashMap = new HashMap<>();
//        //hashMap.put("title","Java如此简单");
//
//        List<Blog> blogList = mapper.queryBlogIf(hashMap);
//
//        for (Blog blog : blogList) {
//            System.out.println(blog);
//        }
//
//        session.close();
//    }

//    @Test
//    public void test() {
//        SqlSession session = MybatisUtils.getSqlSession();
//        BlogMapper mapper = session.getMapper(BlogMapper.class);
//
//        HashMap hashMap = new HashMap<>();
//        //hashMap.put("title","Java如此简单");
//        hashMap.put("author","狂神说");
//
//        List<Blog> blogList = mapper.queryBlogChoose(hashMap);
//
//        for (Blog blog : blogList) {
//            System.out.println(blog);
//        }
//
//        session.close();
//    }

//    @Test
//    public void test() {
//        SqlSession session = MybatisUtils.getSqlSession();
//        BlogMapper mapper = session.getMapper(BlogMapper.class);
//
//        HashMap hashMap = new HashMap<>();
//        hashMap.put("title", "Java如此简单");
//        //hashMap.put("author", "Cra2iTeT");
//        hashMap.put("id", "ae44df573be44f2083ce01baf471d06a");
//
//        int i = mapper.updateBlog(hashMap);
//
//        session.close();
//    }

    //    @Test
//    public void test() {
//        SqlSession session = MybatisUtils.getSqlSession();
//        BlogMapper mapper = session.getMapper(BlogMapper.class);
//
//        HashMap hashMap = new HashMap<>();
//        ArrayList<Integer> list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        hashMap.put("ids", list);
//        List<Blog> blogList = mapper.queryBlogForeach(hashMap);
//
//        for (Blog blog : blogList) {
//            System.out.println(blog);
//        }
//
//        session.close();
//    }
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TMapper mapper = sqlSession.getMapper(TMapper.class);

        T t = mapper.queryT("20203907");
        System.out.println(t);

        sqlSession.close();
    }
}
