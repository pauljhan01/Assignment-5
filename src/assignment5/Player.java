package assignment5;

import com.sun.security.ntlm.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Player implements Runnable{
    final Socket s;
    final DataInputStream din;
    final DataOutputStream dout;

    public Player(Socket s, DataInputStream din, DataOutputStream dout){
        this.s = s;
        this.din = din;
        this.dout = dout;

    }
    public void run(){
        String send = "";
        String receive = "";
        Game game = new Game();
        while(true){
            try {
                receive = din.readUTF();
                switch(receive){
                    case "Y":
                        break;
                    case "HISTORY":
                        break;
                    default:
                        break;
                }
                System.out.println("Closing client... good night");
                this.s.close();
                din.close();
                dout.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }


    }
}
