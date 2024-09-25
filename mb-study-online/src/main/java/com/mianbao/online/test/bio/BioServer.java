package com.mianbao.online.test.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: bio服务端
 * @Author:bread
 * @Date: 2024-09-25 20:27
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket();
        //绑定端口
        serverSocket.bind(new InetSocketAddress(9090));
        //阻塞，接收外界链接
        Socket socket = serverSocket.accept();
        while (true){

            InputStream inputStream=socket.getInputStream();
            byte[]bytes=new byte[10];
            inputStream.read(bytes);
            System.out.println("服务端接收到的数据:"+new String(bytes));
        }
    }
}
