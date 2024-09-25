package com.mianbao.online.test.bio;

import jdk.net.Sockets;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Description: bio客户端
 * @Author:bread
 * @Date: 2024-09-25 20:27
 */
public class BioClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        //连接bioserver
        Socket socket=new Socket();
        socket.connect(new InetSocketAddress(9090));
        OutputStream outputStream=socket.getOutputStream();
        //发送数据
        while (true){
            outputStream.write("test".getBytes());
            outputStream.flush();
            System.out.println("发送数据");
            Thread.sleep(1000);
        }
    }
}
