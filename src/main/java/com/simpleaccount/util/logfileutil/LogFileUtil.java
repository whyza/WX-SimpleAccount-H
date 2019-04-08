package com.simpleaccount.util.logfileutil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 读取日志文件
 * @Author: Whyza
 * @CreateDate: 2019/3/8 14:12
 * @Version: 1.0
 */
public class LogFileUtil {
    public static List<String> getAllFile(String directoryPath, boolean isAddDirectory) {
        List<String> list = new ArrayList<String>();
        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
            return list;
        }
        File[] files = baseFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                if (isAddDirectory) {
                    list.add(file.getName());
                }
                list.addAll(getAllFile(file.getAbsolutePath(), isAddDirectory));
            } else {
                list.add(file.getName());
            }
        }
        return list;
    }

    public static List<String> readLogFile(String fileName) {
        List<String> result = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String s = null;
            while((s = br.readLine())!=null){
                result.add(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}