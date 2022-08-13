package com.state;


//测试join方法，理解为插队
public class JoinTest implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动线程
        JoinTest joinTest=new JoinTest();
        Thread thread=new Thread(joinTest);
        thread.start();


        //主线程
        for (int i = 0; i < 1000; i++) {
            if (i==200){
                thread.join();//插队
            }
            System.out.println("main"+i);
        }
    }
}


