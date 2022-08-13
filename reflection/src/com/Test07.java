package com;
//获取系统类的加载器
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取系统类加载器的父类加载器-->扩展加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        //获取扩展加载器的父类加载器-->根加载器（c/c++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        //测试当前类是哪个类加载器加载
        ClassLoader classLoader = Class.forName("com.Test07").getClassLoader();
        System.out.println(classLoader);
        //测试jdk内部内置的类加载器是什么
         classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);
        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

    }
}
