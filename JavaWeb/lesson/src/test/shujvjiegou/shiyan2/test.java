package test.shujvjiegou.shiyan2;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        str = str.replace(" ", "");//去除空格

        int flag = 0;

            for (int i = 0; i < str.length(); i++) {
                if (i > 0 && isOperator(str.substring(i, i + 1))) {//操作符连续出现
                    if (isOperator(str.substring(i - 1, i)) || str.charAt(i - 1) == '(') {
                        System.out.print("ERROR:表达式缺操作数");
                        return;
                    }
                } else if (i > 1 && str.charAt(i) == '(') {//左右括号连着出现
                    if (str.charAt(i - 1) == ')') {
                        System.out.print("ERROR:表达式缺操作数");
                        return;
                    }
                } else if (i > 1 && str.charAt(i) == ')') {
                    if (str.charAt(i - 1) == '(' || isOperator(str.substring(i - 1, i))) {
                        System.out.print("ERROR:表达式缺操作数");
                        return;
                    }
                }


                if (str.charAt(i) == '(') {//左右括号匹配
                    flag++;
                } else if (str.charAt(i) == ')') {
                    flag--;
                }
            }

        StringBuilder stringBuilder = new StringBuilder("(");
        stringBuilder.append(str);
        stringBuilder.append(")");
        str = String.valueOf(stringBuilder);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("+", 1);
        hashMap.put("-", 1);
        hashMap.put("*", 2);
        hashMap.put("/", 2);
        hashMap.put("(", 3);
        hashMap.put(")", 3);

        if (flag != 0) {
            System.out.print("ERROR:缺少括号");
            return;
        }

        Stack<Double> stack = new Stack<>();//计算栈
        Stack<String> stack1 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            fun(s, hashMap, stack, stack1);
        }
        System.out.println();
        String temp = String.valueOf(stack.pop());
        if ((temp.length() - temp.indexOf(".") == 2) && (temp.charAt(temp.indexOf(".") + 1) == '0')) {
            System.out.print(temp.substring(0, temp.indexOf(".")));
        } else {
            System.out.print(temp);
        }
    }

    public static boolean isBrackets(String s) {
        if (s.equals("(") || s.equals(")")) {
            return true;
        }
        return false;
    }

    public static boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }

    public static double operate(String s, double n1, double n2) {
        if (s.equals("+")) {
            return n1 + n2;
        } else if (s.equals("-")) {
            return n1 - n2;
        } else if (s.equals("*")) {
            return n1 * n2;
        } else {
            return n1 / n2;
        }
    }

    public static void fun(String s, HashMap<String, Integer> hashMap, Stack<Double> stack, Stack<String> stack1) {
        if (isBrackets(s) || isOperator(s)) {
            if (!stack1.empty()) {
                if (!stack1.peek().equals("(") && hashMap.get(s) <= hashMap.get(stack1.peek())) {//比较优先级，且前一个操作符不应该是左括号
                    double num2 = stack.pop();
                    if (stack.empty()) {//例如-1/2的情况
                        stack.push(-num2);
                        return;
                    }
                    double num1 = stack.pop();
                    System.out.print(stack1.peek());//后缀输出
                    stack.push(operate(stack1.pop(), num1, num2));//把计算结果再压栈
                    if (Objects.equals(hashMap.get(s), hashMap.get(stack1.peek()))) {
                        fun(s, hashMap, stack, stack1);//运算一次后出现栈顶操作符与当前操作符重优先级
                    } else {
                        stack1.push(s);//把后续操作符压入栈
                    }
                } else if (s.equals(")")) {//遇到右括号得开始计算
                    String tempStr = stack1.pop();
                    while (!tempStr.equals("(")) {//没有遇到左括号就不停，继续计算
                        double num2 = stack.pop();
                        if (stack.empty()) {//例如-1/2的情况
                            stack.push(-num2);
                            return;
                        }
                        double num1 = stack.pop();
                        System.out.print(tempStr);//后缀输出
                        stack.push(operate(tempStr, num1, num2));//把计算结果再压栈
                        tempStr = stack1.pop();
                    }
                } else {//优先级大直接压栈
                    stack1.push(s);
                }
            } else {//栈空直接压栈
                stack1.push(s);
            }
        } else {//不是操作数就压入操作数栈
            stack.push(Double.valueOf(s));
            System.out.print(s);//后缀输出操作数
        }
    }
}