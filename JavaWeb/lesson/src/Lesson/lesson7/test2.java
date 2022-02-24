package Lesson.lesson7;

import java.io.*;
import java.util.*;

public class test2 {
    public static void main(String[] args) throws IOException {
        char[] chars = new char[1024];

        StringBuilder sb = new StringBuilder();

        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\CS\\Java\\IdeaProjects\\lesson\\src\\Lesson\\lesson7\\test.txt"), "GBK");

        int length = 0;
        while ((length = isr.read(chars)) != -1) {
            sb.append(chars, 0, length);
        }

        //System.out.println(sb.toString().toLowerCase());
        String str = sb.toString().toLowerCase();

        String[] s = str.split("[^a-zA-Z0-9]+");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (hashMap.containsKey(s[i])) {
                int temp = hashMap.get(s[i]) + 1;
                hashMap.put(s[i], temp);
            } else {
                hashMap.put(s[i], 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());

        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> k0,
                               Map.Entry<String, Integer> k1) {
                return (k0.getValue()).compareTo(k1.getValue());
            }
        };
        int temp = 0;
        Collections.sort(list, comparator);// 排序
        for (int i = list.size() - 1; i > 0; i--) {
            String key = list.get(i).getKey();
            Integer value = list.get(i).getValue();
            temp += value;
        }


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 1;
        for (Map.Entry<String, Integer> map : list) {
            if (num <= n) {
                System.out.println(map.getKey() + ":" + map.getValue());
            } else {
                return;
            }
            num++;
        }
    }
}
