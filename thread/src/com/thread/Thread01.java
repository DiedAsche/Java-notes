package com.thread;

public class Thread01 extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 3; i++) {
            System.out.println("我在看代码--"+i);
        }
    }

    public static void main(String[] args) {
        //主方法main，主线程

        //创建一个线程对象，调用start方法，开启子线程

        Thread01 test=new Thread01();
        test.start();
        //test.run();



        for (int i = 0; i < 2000; i++) {
            System.out.println("我在看多线程--"+i);
        }
    }
}
