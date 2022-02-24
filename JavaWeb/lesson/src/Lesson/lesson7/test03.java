package Lesson.lesson7;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class test03 {
    public static int n=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s;
        int count=0;
        int num=1;
        //作为FileReader和FileWriter读取的对象
        String file1="C:\\CS\\Java\\IdeaProjects\\lesson\\src\\Lesson\\lesson7\\test.txt";
        try
        {
            BufferedReader a=new BufferedReader(new FileReader(file1));
            StringBuffer c=new StringBuffer();
            //将文件内容存入StringBuffer中
            while((s = a.readLine()) != null)
            {
                //用于拼接字符串
                c.append(s);
            }
            //将StringBuffer转换成String，然后再将所有字符转化成小写字符
            String m=c.toString().toLowerCase();
            //匹配由数字和26个字母组成的字符串
            String [] d=m.split("[^a-zA-Z0-9]+");
            //遍历数组将其存入Map<String, Integer>中
            Map<String , Integer> myTreeMap=new  TreeMap<String, Integer>();
            for(int i = 0; i < d.length; i++) {
                //containsKey()方法用于检查特定键是否在TreeMap中映射
                if(myTreeMap.containsKey(d[i])) {
                    count = myTreeMap.get(d[i]);
                    myTreeMap.put(d[i], count + 1);
                }
                else {
                    myTreeMap.put(d[i], 1);
                }
            }
            //通过比较器实现排序
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(myTreeMap.entrySet());
            //按降序排序
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

                public int compare(Entry<String, Integer> k1, Entry<String, Integer> k2) {
                    //返回两个单词出现次数较多的那个单词的出现次数
                    return k2.getValue().compareTo(k1.getValue());
                }

            });
            System.out.println("请输入N:");
            n=sc.nextInt();
            for(Map.Entry<String, Integer> map : list) {
                if(num <= n) {
                    //输出到程序控制台
                    System.out.println(map.getKey() + ":" + map.getValue());
                    num++;
                }
                //输出完毕退出
                else break;
            }
            //关闭文件指针
            a.close();
            // b.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("找不到指定文件");
        }
        catch(IOException e)
        {
            System.out.println("文件读取错误");
        }
    }

}