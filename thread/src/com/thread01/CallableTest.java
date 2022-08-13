package com.thread01;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class CallableTest implements Callable<Boolean> {
    private String url;
    private String name;
    public CallableTest(String url, String name){
        this.url=url;
        this.name=name;

    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载一个文件名为"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest t1=new CallableTest("https://images-new-cdn.123rf.com.cn/450wm/lukjonis/lukjonis1810/lukjonis181000021.jpg","1.jpg");
        CallableTest t2=new CallableTest("https://images-new-cdn.123rf.com.cn/450wm/lukjonis/lukjonis1810/lukjonis181000021.jpg","2.jpg");
        CallableTest t3=new CallableTest("https://images-new-cdn.123rf.com.cn/450wm/lukjonis/lukjonis1810/lukjonis181000021.jpg","3.jpg");

      //执行创建服务
        ExecutorService ser= Executors.newFixedThreadPool(3);
       //提交执行
        Future<Boolean> result1=ser.submit(t1);
        Future<Boolean> result2=ser.submit(t2);
        Future<Boolean> result3=ser.submit(t3);
       //获取结果
        boolean r1=result1.get();
        boolean r2=result2.get();
        boolean r3=result3.get();
        //关闭服务
        ser.shutdown();

    }
}
//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io异常，downloader方法出现问题");
        }
    }
}