package com.Lamda;

public class LambdaTest2 {

    public static void main(String[] args) {
        ILove love =null;
        //1.Lambda表达式简化
/*        ILove love=(int a) ->{
                System.out.println("i love you-->"+a);
        };
        //2.简化参数类型
        love=(a)->{
            System.out.println("i love you-->"+a);
        };
        //3.简化括号
        love=a ->{
                System.out.println("i love you-->"+a);
    };*/
        //4.简化花括号
        love=a -> System.out.println("i love you-->"+a);
        love.iLove(2);

        /*
            1.lambda表达式只有一行代码才能简化花括号
            2.前提是函数式接口
            3.多个参数也可以去掉参数，要去掉就全部去掉，必须加括号
         */
    }
}
interface ILove{
    void iLove(int a);
}
class Love implements ILove{

    @Override
    public void iLove(int a) {
        System.out.println("i love you-->"+a);
    }
}
