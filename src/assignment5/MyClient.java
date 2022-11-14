package assignment5;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args)throws IOException{
        try{
            Scanner in = new Scanner(System.in);
            Socket s = new Socket("localhost",6666);

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());

            printIntro();
            while(true){
                dout.writeUTF(in.nextLine());
                break;

            }

            in.close();
            s.close();
        }catch(IOException e){
            System.out.println(e);
        }

    }
    public static void printIntro(){
        System.out.println("Welcome to Mastermind.  Here are the rules. \n" +
                " \n" +
                "This is a text version of the classic board game Mastermind. \n" +
                " \n" +
                "The  computer  will  think  of  a  secret  code.  The  code  consists  of  4 \n" +
                "colored  pegs.  The  pegs  MUST  be  one  of  six  colors:  blue,  green, \n" +
                "orange, purple, red, or yellow. A color may appear more than once in \n" +
                "the  code.  You  try  to  guess  what  colored  pegs  are  in  the  code  and \n" +
                "what  order  they  are  in.  After  you  make  a  valid  guess  the  result \n" +
                "(feedback) will be displayed. \n" +
                " \n" +
                "The  result  consists  of  a  black  peg  for  each  peg  you  have  guessed \n" +
                "exactly correct (color and position) in your guess.  For each peg in \n" +
                "the guess that is the correct color, but is out of position, you get \n" +
                "a  white  peg.  For  each  peg,  which  is  fully  incorrect,  you  get  no \n" +
                "feedback.  \n" +
                " \n" +
                "Only the first letter of the color is displayed. B for Blue, R for \n" +
                "Red, and so forth. When entering guesses you only need to enter the \n" +
                "first character of each color as a capital letter. \n" +
                " \n" +
                "You  have  12  guesses  to  figure  out  the  secret  code  or  you  lose  the \n" +
                "game.  Are you ready to play? (Y/N): ");
    }
}
