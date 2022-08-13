package com.proxy;
/*
    静态代理模式：
    1.真实对象和代理对象都实现同一个接口
    2.代理对象要代理真实对象
    好处：
    代理对象可以做真实对象做不了的事情，真实对象专注于自己的事情

 */
public class staticProxy {
    public static void main(String[] args) {
        You you=new You();
        //两者对比，线程的静态代理实现原理
        new Thread(()-> System.out.println("我爱你")).start();
        new WeddingCompany(new You()).HappyMarry();
    }

}
interface Marry{
    void HappyMarry();

}
//真实角色，结婚对象
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("我今天结婚了！");
    }
}
//代理角色，帮你结婚
class WeddingCompany implements Marry{
    private Marry target;
    public WeddingCompany(Marry target){
        this.target=target;
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();//这里是真实对象
        after();
        
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}
