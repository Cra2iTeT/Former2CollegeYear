import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test() {
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("=============");
        list.removeAll(list);
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
