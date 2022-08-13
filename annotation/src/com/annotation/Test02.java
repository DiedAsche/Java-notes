package com.annotation;

import java.lang.annotation.*;

//测试元注解
public class Test02 {
    @MyAnnotation
    public  void test() {

    }
}

//定义一个注解
//Target表示我们可以用在什么地方
@Target(value = ElementType.METHOD)
//Retention表示我们的注解在什么什么时候有效
//runtime>class>sources
@Retention(value = RetentionPolicy.RUNTIME)
//Documented表示是否将我们的注解生成在Javadoc中
    @Documented
//Inherited子类可以继承父类的注解
    @Inherited
 @interface MyAnnotation{

}
