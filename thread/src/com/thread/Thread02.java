package com.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Thread02 extends Thread{
   private String url;
   private String name;
   public Thread02(String url,String name){
       this.url=url;
       this.name=name;

   }

    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载一个文件名为"+name);

    }

    public static void main(String[] args) {
        Thread02 t1=new Thread02("https://images-new-cdn.123rf.com.cn/450wm/lukjonis/lukjonis1810/lukjonis181000021.jpg","1.jpg");
        Thread02 t2=new Thread02("https://images-new-cdn.123rf.com.cn/450wm/lukjonis/lukjonis1810/lukjonis181000021.jpg","2.jpg");
        Thread02 t3=new Thread02("https://images-new-cdn.123rf.com.cn/450wm/lukjonis/lukjonis1810/lukjonis181000021.jpg","3.jpg");

        t1.start();
        t2.start();
        t3.start();

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
