package com.state;

//测试停止线程
/*
    1.建议线程正常停止--》利用次数，不建议死循环
    2.建议使用标志--》设置一个标志位
    3.不要使用stop和destroy等过时方法
 */
public class StopTest implements Runnable{

    //1.设置一个标志位
    private boolean flag=true;


    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("run....Thread"+i++);
        }

    }

    //设置一个公开的方法停止线程，转换标志位
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        StopTest stopTest=new StopTest();
        new Thread(stopTest).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if (i==900){
                //调用stop方法切换标志位，让线程停止

                stopTest.stop();
                System.out.println("线程停止了");
            }
        }
    }
}
