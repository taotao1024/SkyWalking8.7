package com.demo.java.atomic;

import jdk.nashorn.internal.ir.CallNode;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main {
    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        // 获取一个 int 类型数组对象的 对象头的字节长度
        // OFF SZ  TYPE DESCRIPTION
        // 0   8        object header: mark
        // 8   4        object header: class
        // 12  4        array  length
        // 12  4        alignment/padding gap
        // 16  16  int  I.<elements>
        System.out.println(unsafe.arrayBaseOffset(int[].class));
        // System.out.println(ClassLayout.parseInstance(new int[4]).toPrintable());
        // 计算指定数据类型的数组中 每个元素占用的内存空间
        int scale = unsafe.arrayIndexScale(int[].class);
        System.out.println();
        // 计算传入的数 在二进制表示下 从左开始有多少个连续的0
        // 00000000 00000000 00000000 00000100
        System.out.println(Integer.numberOfLeadingZeros(scale));
        // 传入任何一个数组下标 只需要左移 shift 位，并加上 对象头的便宜长度，就可以得到当前这个下表所对应元素的起始内存地址
        int shift = 31 - Integer.numberOfLeadingZeros(scale);
        System.out.println(shift);
        System.out.println(0 << 2);
        System.out.println(1 << 2);
        System.out.println(2 << 2);
        System.out.println(3 << 2);
    }
}
