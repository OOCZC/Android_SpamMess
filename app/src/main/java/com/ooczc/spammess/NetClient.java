package com.ooczc.spammess;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import static com.ooczc.spammess.R.string.mess;

public class NetClient {
    String ServerIP = "172.26.49.3";
    String reply = "8";
    String messStr;

    public  String isSpamMess(String mess) throws IOException {
        //1.建立客户端socket连接，指定服务器位置及端口
        messStr = mess;
        Log.i("zcc","---------NetClient   isSpamMess *****1 mess ="+messStr);
        new MyThread().start();
        Log.i("zcc","---------NetClient   isSpamMess *****2 mess ="+mess);
        while(true){
            Log.i("zcc", "---------NetClient  循环 1");
            int i=0;int j=0;
            if(reply != "8") {
                return reply;
//                Log.i("zcc", "---------NetClient  循环");
            }
            else{
                i++;
                if(i % 10000 == 0)
                    Log.i("zcc","---------NetClient  循环 2");
            }
        }
//        Log.i("zcc","---------NetClient   isSpamMess 222");
//        return "error";
    }
/*
        Log.i("zcc","NetClient ********"+mess+"*****"+mess.length());
        Log.i("zcc","---------NetClient   1");
        Socket socket =new Socket(ServerIP,6464);
        Log.i("zcc","---------NetClient   2");
//        System.out.println("111");
        //2.得到socket读写流  
        OutputStream os=socket.getOutputStream();
        Log.i("zcc","---------NetClient   3");
        PrintWriter pw=new PrintWriter(os);
        Log.i("zcc","---------NetClient   4");
//        System.out.println("222");
        Log.i("zcc","---------NetClient   5");
        //输入流  
        InputStream is=socket.getInputStream();
        Log.i("zcc","---------NetClient   6");
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
//        System.out.println("333");
        Log.i("zcc","---------NetClient   7");
        //3.利用流按照一定的操作，对socket进行读写操作  
//        String info="用户名：Tom,用户密码：123456";  
//        String reply=br.readLine();
//        System.out.println(reply);
        pw.write(mess);
        Log.i("zcc","---------NetClient   8");
        pw.flush();
        Log.i("zcc","---------NetClient   9");
//        System.out.println("444");
        Log.i("zcc","---------NetClient   10");
//        socket.shutdownOutput();  
        String reply=br.readLine();
        Log.i("zcc","---------NetClient   11");
        System.out.println(reply);
        Log.i("zcc","---------NetClient   12");
        return reply;
        //接收服务器的相应
         */


//        String reply=null;  
//        while(!((reply=br.readLine())==null)){  
//            System.out.println("接收服务器的信息："+reply);  
//        }  
        
    	/*
    	Socket s=new Socket(ServerIP,6464); 
    	System.out.println("111");
    	
    	DataInputStream in = new DataInputStream(s.getInputStream());
//    	in.read(b);
    	System.out.println("222");
    	String str = new String();
//    	str = in.readUTF();
    	str = in.readLine();
    	System.out.println("333");
    	System.out.println("get: "+str);
    	DataOutputStream out = new DataOutputStream(s.getOutputStream());
    	System.out.println("444");
    	out.write(mess.getBytes());
    	out.flush();
    	str = in.readUTF();
    	System.out.println("555");
    	System.out.println("get: "+str);
    	out.close();
    	in.close();
    	s.close();
    	return str;
    	*/


    class MyThread extends Thread{
//        public String mess;
        String ServerIP = "172.26.49.3";
//        public MyThread(String str){
//            mess = str;
//        }
        @Override
        public void run(){
            Log.i("zcc", "---------MyThread   0");
            try {
                Log.i("zcc", "---------MyThread   1");
                Socket socket = new Socket(ServerIP, 6464);
                Log.i("zcc", "---------MyThread   2");
//        System.out.println("111");
                //2.得到socket读写流
                OutputStream os = socket.getOutputStream();
                Log.i("zcc", "---------MyThread   3");
                PrintWriter pw = new PrintWriter(os);
                Log.i("zcc", "---------MyThread   4");
//        System.out.println("222");
                Log.i("zcc", "---------MyThread   5");
                //输入流
                InputStream is = socket.getInputStream();
                Log.i("zcc", "---------MyThread   6");
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        System.out.println("333");
                Log.i("zcc", "---------MyThread   7");
                //3.利用流按照一定的操作，对socket进行读写操作
//        String info="用户名：Tom,用户密码：123456";
//        String reply=br.readLine();
//        System.out.println(reply);
                Log.i("zcc","---------MyThread   messStr ="+messStr);
                pw.write(messStr);
                Log.i("zcc", "---------MyThread   8");
                pw.flush();
                Log.i("zcc", "---------MyThread   9");
//        System.out.println("444");
                Log.i("zcc", "---------MyThread   10,reply init "+reply);
//        socket.shutdownOutput();
                reply = br.readLine();
                Log.i("zcc", "---------MyThread   11");
//                System.out.println(reply);
                Log.i("zcc", "---------MyThread   reply = "+reply);

            } catch (Exception e){
                e.printStackTrace();
                Log.i("zcc", "---------MyThread   Exception");
            }
//            return reply;
        }
    }


    /*
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = new String("");
        //两次价值xxx元王牌项目；可充值xxx元店内项目卡一张；
//        可以参与V动好生活百分百抽奖机会一次！预约电话：xxxxxxxxxxx
        try{
            System.out.println("start~");
            NetClient.isSpamMess(str);
            System.out.println("over~");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    */

}
