package com.state;


//测试守护线程
//上帝有守护你
public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认是false表示是用户线程，正常线程都是用户线程
        thread.start();

        new Thread(you).start();//你用户线程启动
    }
}
//上帝
class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你");
        }
    }
}



//你
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都快乐活着");
        }
        System.out.println("-====goodbye world=====-");
    }
}
