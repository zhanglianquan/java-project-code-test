package src.io.bio;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;

/**
 * @Author zhanglianquan
 * @Description
 * @Date 2020/1/19
 **/
public class JavaBIO {
    public  static void readBIO(){
        BufferedReader reader = null;
        String buffer = null;
        try {
            String path = JavaBIO.class.getClassLoader().getResource("assets/test.txt").getPath();
            reader = new BufferedReader(new FileReader(path));
            do {
                buffer = reader.readLine();
                System.out.println(buffer);
            } while (reader.read() != -1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

    public  static void writeBIO(){
        try {
            String path = JavaBIO.class.getClassLoader().getResource("assets/test.txt").getPath();
            FileWriter fw =  new FileWriter(path);
            //调用输出流对象写数据的方法
            //写一个字符串
            fw.write("I love you 我爱你");
            //数据没有直接写到文件，而是写到了缓冲区
            //刷新
            fw.flush();
            //释放资源
            //通知系统释放和该文件相关的资源
            fw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
