package com.annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//什么是注解
public class Test01 extends Object{

    //@Override重写的注解
    @Override
    public String toString() {
        return super.toString();

    }
    //测试Deprecated:不推荐程序员使用，但是可以使用，或者存在更好的方式
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }

    @SuppressWarnings("all")
    public void test02(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
