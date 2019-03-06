 package com.jicl.io.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * @function 文件类的学习
 * @author xianzilei
 * @date 2019/03/06
 */
public class FileLearning {
   
    /**
     * 构造方法
     */
    @Test
    public void testConstructor() {
        //1.public File(String pathname)
        File f1=new File("D:\\a\\animal.jpg");
        
        //2.public File(String parent, String child)
        File f2=new File("D:\\a", "animal.jpg");
        
        //3.public File(File parent, String child)
        File f3=new File("D:"+File.separator+"a");
        File f4=new File(f3, "animal.jpg");
        
        System.out.println("f1----------"+f1);
        System.out.println("f2----------"+f2);
        System.out.println("f3----------"+f3);
        System.out.println("f4----------"+f4);
    }
    
    /**
     * 创建方法
     * @throws IOException 
     */
    @Test
    public void testCreateMethod() throws IOException {
        String path1="D:\\eclipse_workspace\\iolearning\\src\\test\\resources\\lib\\test.txt";
        File file1=new File(path1);
        String path2="D:\\eclipse_workspace\\iolearning\\src\\test\\resources\\lib\\a";
        File file2=new File(path2);
        String path3="D:\\eclipse_workspace\\iolearning\\src\\test\\resources\\lib\\b\\c";
        File file3=new File(path3);
        String path4="D:\\eclipse_workspace\\iolearning\\src\\test\\resources\\lib\\d\\e";
        File file4=new File(path4);
        //1.当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件,只能创建文件，无法创建文件夹
        boolean flag1 = file1.createNewFile();//不存在就返回true,存在就返回false
        System.out.println(flag1?"创建成功！":"已有源文件，无需创建！"); 
        
        //2.创建单级目录:如果已经存在则返回false
        //2.1创建单级目录成功，即只能创建一级目录，其父文件夹必须存在,返回true
        boolean flag2 = file2.mkdir();
        System.out.println("mkdir()创建单级目录----"+(flag2?"创建成功！":"创建失败！")); 
        //2.2创建多级目录失败，返回false
        boolean flag3 = file3.mkdir();
        System.out.println("mkdir()创建多级目录----"+(flag3?"创建成功！":"创建失败！")); 
        
        //3.创建多级目录：如果已经存在则返回false
        //3.1创建多级目录成功，返回true
        boolean flag4 = file4.mkdirs();
        System.out.println("mkdirs()创建单级目录----"+(flag4?"创建成功！":"创建失败！")); 
    }
    
    @Test
    public void testDelete() {
        
    }
}
