package com.thread;
//多个对象操作一个对象
//买火车票的例子
public class Thread04 implements Runnable{

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
        Thread04 ticket=new Thread04();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛").start();

    }
}
