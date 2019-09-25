package com.feri.onedrive.admin.test;

import com.feri.onedrive.entity.car.CarBrand;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-18 11:02
 */
public class JDK8_Main {
    public static void main(String[] args) {
        //1、Stream语法 函数式编程 声明式处理数据
        System.out.println(Stream.empty());
        System.out.println(Stream.of(new CarBrand()));

        //2、Optional 容器对象 防止null
        System.out.println(Optional.empty());
        System.out.println(Optional.of(new CarBrand()));

        //3、Lambda 表达式 简化接口实现类 代替匿名内部类 接口中只能有一个方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("传统写法");
            }
        }).start();

        new Thread(()-> System.out.println("Lambda表达式")).start();

        //4、方法引用 运算符 :: 可以直接使用类中的方法
        //构造函数 实例化 Supplier get 对象
        CarBrand carBrand1=new CarBrand();
//        CarBrand carBrand2=CarBrand.createObj(CarBrand::new);
//        System.out.println(carBrand2);
//        //实例方法 配合集合的迭代器 Consumer 接口的实例化对象
//        List<CarBrand> list=new ArrayList<>();
//        list.forEach(CarBrand::toString);
//        //静态方法 但是必须有参数 当前类的对象
//        list.forEach(CarBrand::show);
//       for(CarBrand c:list){
//           System.out.println(c);
//       }
       //函数式编程  --  响应式开发---  SpringWebFlux
    }
}
