package test.shujvjiegou.shiyan3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Node root = create(arr);
        int Wpl[] ={0};
        preOrder(root);//添加编码
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            preOrder(root, arr[i], Wpl);
            System.out.println();
        }
        System.out.println("WPL:" + Wpl[0]);

    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        }
    }

    public static void preOrder(Node root, int temp, int[] Wpl) {
        if (root != null) {
            root.preOrder(temp, Wpl);
        }
    }

    public static Node create(int[] arr) {
        List<Node> node = new ArrayList<Node>();//存储方便排序
        for (int value : arr) {
            node.add(new Node(value));
        }

        while (node.size() > 1) {
            Collections.sort(node);//排序

            Node leftNode = node.get(0);
            Node rightNode = node.get(1);

            Node parent = new Node(leftNode.value + rightNode.value, 1);
            parent.lChild = leftNode;
            parent.rChild = rightNode;

            node.remove(leftNode);
            node.remove(rightNode);
            node.add(parent);//把结果再加回去排序
        }
        return node.get(0);//根节点
    }
}

class Node implements Comparable<Node> {
    int value; //结点权值
    Node lChild; //左结点
    Node rChild; //右结点
    String str;//编码
    int flag;//标记是加出来的还是本来就有的

    public void preOrder() {
        //System.out.println(this.value + " " + this.str + " " + this.flag);
        if (this.lChild != null) {
            this.lChild.str = this.str + "0";
            this.lChild.preOrder();
        }
        if (this.rChild != null) {
            this.rChild.str = this.str + "1";
            this.rChild.preOrder();
        }
    }

    public void preOrder(int temp, int[] Wpl) {
        if (this.value == temp && this.flag == 0) {
            System.out.print(this.value + "编码为" + this.str);
            Wpl[0] += this.value * this.str.length();
            //System.out.println(Wpl);
        }
        if (this.lChild != null) {
            this.lChild.preOrder(temp, Wpl);
        }
        if (this.rChild != null) {
            this.rChild.preOrder(temp, Wpl);
        }
    }

    public Node(int value) {
        this.flag = 0;
        this.str = "";
        this.value = value;
    }

    public Node(int value, int flag) {
        this.flag = flag;
        this.str = "";
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

}


