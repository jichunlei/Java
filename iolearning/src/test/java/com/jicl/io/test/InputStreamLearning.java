package com.jicl.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.junit.Test;

/**
 * 输入流学习
 * 
 * @function InputStreamLearning
 * @author xianzilei
 * @date 2019/03/05
 */
public class InputStreamLearning {
    
    private String path="D:"+File.separator+"eclipse_workspace"+File.separator+"iolearning"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"text.txt";
    
    /**
     * 字节流
     * 读取文件内容(预先指定字符数组的大小)
     * @throws Exception 
     */
    @Test
    public void readTxtInputStream() throws Exception {
        File file=new File(path);
        InputStream is=new FileInputStream(file);
        long length = file.length();
        System.out.println("文件长度："+length);
        byte[] bs1=new byte[(int)file.length()];//避免字符数组长度过大或过小
        byte[] bs2=new byte[(int)file.length()];
        int length1 = is.read(bs1,1,15);
        int length2 = is.read(bs2);
        is.close();
        System.out.println("bs1数组长度:"+bs1.length+"----------"+"bs2数组长度:"+bs2.length);
        System.out.println("bs1数组实际读入长度:"+length1+"----------"+"bs2数组实际读入长度:"+length2);
        System.out.println("打印bs1字符数组：-------------------");
        System.out.println(new String(bs1,0,length1));
        System.out.println("打印bs2字符数组：-------------------");
        System.out.println(new String(bs2,0,length2));
    }
    
    /**
     * 字节流
     * 读取文件内容(逐字读取)
     * @throws Exception 
     */
    @Test
    public void readTxtInputStream2() throws Exception {
        File file=new File(path);
        InputStream is=new FileInputStream(file);
        long length = file.length();
        System.out.println("文件长度："+length);
        byte[] bs1=new byte[(int)file.length()];//避免字符数组长度过大或过小
        int temp=0;
        int count=0;
        while((temp=is.read())!=-1) {
            bs1[count++]=(byte)temp;
        }
        is.close();
        System.out.println("打印bs1字符数组：-------------------");
        System.out.println(new String(bs1));
    }
}
