package com.lesson2;

import java.util.Random;

public class TestSeed
{
    public static void main(String[] args)
    {
        Random r1 = new Random(50);
        System.out.println("第一个种子为50的Random对象");
        System.out.println("r1.nextBoolean():\t" + r1.nextBoolean());
        System.out.println("r1.nextInt():\t\t" + r1.nextInt());
        System.out.println("r1.nextDouble():\t" + r1.nextDouble());
        System.out.println("r1.nextGaussian():\t" + r1.nextGaussian());
        System.out.println("---------------------------");

        Random r2 = new Random(50);
        System.out.println("第二个种子为50的Random对象");
        System.out.println("r2.nextBoolean():\t" + r2.nextBoolean());
        System.out.println("r2.nextInt():\t\t" + r2.nextInt());
        System.out.println("r2.nextDouble():\t" + r2.nextDouble());
        System.out.println("r2.nextGaussian():\t" + r2.nextGaussian());
        System.out.println("---------------------------");

        Random r3 = new Random(100);
        System.out.println("种子为100的Random对象");
        System.out.println("r3.nextBoolean():\t" + r3.nextBoolean());
        System.out.println("r3.nextInt():\t\t" + r3.nextInt());
        System.out.println("r3.nextDouble():\t" + r3.nextDouble());
        System.out.println("r3.nextGaussian():\t" + r3.nextGaussian());


        Random r4 = new Random(System.currentTimeMillis());
        System.out.println("以当前时间为种子的Random对象");
        System.out.println("r3.nextBoolean():\t" + r4.nextBoolean());
        System.out.println("r3.nextInt():\t\t" + r4.nextInt());
        System.out.println("r3.nextDouble():\t" + r4.nextDouble());
        System.out.println("r3.nextGaussian():\t" + r4.nextGaussian());
    }
}
