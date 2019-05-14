package com.simpleaccount.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/8 14:33
 * @Version: 1.0
 */
public class test {
    public static List<List<String>> createList(List<String> targe, int size) {
        List<List<String>> listArr = new ArrayList<List<String>>();
        //获取被拆分的数组个数
        int arrSize = targe.size() % size == 0 ? targe.size() / size : targe.size() / size + 1;
        for (int i = 0; i < arrSize; i++) {
            List<String> sub = new ArrayList<String>();
            //把指定索引数据放入到list中
            for (int j = i * size; j <= size * (i + 1) - 1; j++) {
                if (j <= targe.size() - 1) {
                    //得到拆分后的集合
                    sub.add(targe.get(j));
                }
            }
            listArr.add(sub);
        }
        return listArr;
    }

    public static void main(String[] args) {
        List<String> tarArr = new ArrayList<String>();
        tarArr.add("a");
        tarArr.add("b");
        tarArr.add("c");
        tarArr.add("d");
        tarArr.add("e");
        tarArr.add("f");
        tarArr.add("g");
        tarArr.add("h");

        List<List<String>> result = createList(tarArr, 2);

        for (List<String> subArr : result) {
            for (String str : subArr) {
                System.out.print(str + ",");
            }
            System.out.println("~~");
        }
    }
}
