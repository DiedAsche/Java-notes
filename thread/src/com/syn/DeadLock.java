
package com.syn;

//死锁：多个线程互相持有对方需要的资源，形成死锁
public class DeadLock {
    public static void main(String[] args) {
        MakeUp girl1 = new MakeUp(0,"灰姑凉");
        MakeUp girl2 = new MakeUp(1,"白雪公主");
        girl1.start();
        girl2.start();
    }

}

//口红
class Lipsticks{


}

//镜子
class Mirror{

}

//化妆
class MakeUp extends Thread{
    //需要的资源，用static来保证只有一份
    static Lipsticks lipsticks = new Lipsticks();
    static Mirror mirror = new Mirror();
    //选择
    int choice;
    //使用者名字
    String girlName;

    MakeUp(int choice,String girlName){
        this.girlName=girlName;
        this.choice=choice;
    }
    @Override
    public void run() {
        //化妆
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    //化妆，互相持有对方的资源
    private void makeUp() throws InterruptedException {
        if (choice==0){
            synchronized (lipsticks){//获得口红的锁
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);


            }
            synchronized (mirror){
                //一秒钟后想获得镜子
                System.out.println(this.girlName+"获得镜子的锁");
            }
        }else {
            synchronized (mirror){//获得镜子的锁
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(2000);


            }
            synchronized (lipsticks){
                //一秒钟后想获得口红
                System.out.println(this.girlName+"获得镜子的锁");
            }
        }
    }
}