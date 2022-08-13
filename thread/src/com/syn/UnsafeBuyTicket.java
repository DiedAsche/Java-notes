
package com.syn;
//不安全买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        new  Thread(station,"苦逼的我").start();
        new  Thread(station,"牛逼的你").start();
        new  Thread(station,"可恶的黄牛").start();
    }
}
//
class BuyTicket implements Runnable{
    //票
    private int ticketNums = 10;
    boolean flag = true;//外部停止方式
    @Override
    public  void  run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private synchronized void  buy() throws InterruptedException {
        //判断是否有票
        if(ticketNums<=0){
            flag = false;
            return;
        }
        Thread.sleep(1000);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}
