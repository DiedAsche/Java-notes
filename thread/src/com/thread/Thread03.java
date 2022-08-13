package com.thread;
//创建线程方式2：实现runnable接口，重写run方法，执行方法需要丢入runnable接口实现类，调用start方法
public class Thread03 implements Runnable{

    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 30; i++) {
            System.out.println("我在看代码--"+i);
        }
    }

    public static void main(String[] args) {
        //主方法main，主线程

        //创建一个线程对象，调用start方法，开启子线程

        Thread03 test = new Thread03();
        //创建线程对象，通过线程对象来开启我们的线程，代理
//        Thread thread=new Thread(test);
//        thread.start();
        new Thread(test).start();


        for (int i = 0; i < 2000; i++) {
            System.out.println("我在看多线程--" + i);
        }
    }
}
