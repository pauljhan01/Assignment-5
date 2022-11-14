package assignment5;

import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) throws IOException{
        ServerSocket ss=new ServerSocket(6666);
        while (true)
        {
            Socket s = null;
            Socket s1 = null;
            try
            {
                s = ss.accept();
                s1 = ss.accept();

                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());

                DataInputStream din1 = new DataInputStream(s1.getInputStream());
                DataOutputStream dout1 = new DataOutputStream(s1.getOutputStream());

                Thread t = new Thread(new Player(s, din, dout));
                Thread t1 = new Thread(new Player(s1, din1, dout1));

                t.start();
                t1.start();

            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }
}
