package com.Cra2iTeT.Demo01;

//lambda表达式推导
public class LambdaDemo {
    //静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        //局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        ILike like1 = new Like();
        like1.lambda();

        like1 = new Like2();
        like1.lambda();

        like1 = new Like3();
        like1.lambda();

        //匿名内部类
        like1 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like1.lambda();

        //lambda简化
        like1 = () -> {
            System.out.println("I like lambda5");
        };
        like1.lambda();
    }
}

//定义一个函数式接口
interface ILike {
    void lambda();
}

//外部实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like lambda1");
    }
}