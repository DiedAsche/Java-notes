package com.state;

import com.thread.Thread04;

//模拟网络延时:方法问题
public class SleepTest implements Runnable{
    private int ticketNums=10;

    @Override
    public void run() {
        while (true){
            if(ticketNums<=0) break;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        SleepTest ticket=new SleepTest();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛").start();

    }
}
