package com.Cra2iTeT.Demo03;

public class test1 {
    public static void main(String[] args) {
        Container container = new Container();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

class Producer extends Thread {
    Container container;

    public Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.f1(new Product(i));
            System.out.println("生产了" + i + "只鸡");
        }
    }
}

class Consumer extends Thread {
    Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了" + container.f2().id + "只鸡");
        }
    }
}

class Product {
    int id;
    public Product(int id) {
        this.id = id;
    }
}

class Container {
    Product[] products = new Product[100];
    int count = 0;

    public synchronized void f1(Product product) {
        if (count == 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products[count] = product;
        count++;
        this.notifyAll();
    }

    public synchronized Product f2() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        count--;
        Product product = products[count];
        this.notifyAll();
        return product;
    }
}
