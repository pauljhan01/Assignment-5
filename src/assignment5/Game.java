package assignment5;

/* EE422C Assignment #2 submission by
 * Replace <...> with your actual data.
 * <Paul J. Han>
 * <pjh2235>
 */

import java.util.ArrayList;
import java.util.Scanner;

import static assignment5.SecretCodeGenerator.getInstance;

public class Game {
    private String play; //if true, keep playing, if false, stop playing
    private boolean testingMode; //if true, reveal the secret code every guess
    private Scanner in;
    private String guess;
    private String result;
    private ArrayList<Player> playerList;
    private int currentPlayer;
    public Game(boolean mode){
        currentPlayer = 0;
        in = new Scanner(System.in);
        playerList = new ArrayList<Player>();
        testingMode = mode;
        guess = "";
        result = "";
    }

    public void runGame(){
        String play = in.nextLine();
        boolean validCmd = true;
        boolean win = false;
        String code = "";
        if(testingMode == true){
            while(play.equals("Y")){
                code = getInstance().getNewSecretCode();
                System.out.println("\nGenerating secret code ...(for this example the secret code is "+code + ")\n");
                Board board = new Board(code);
                playerList.add(new Player());
                while(playerList.get(currentPlayer).getNumGuesses()!=0) {
                    if(validCmd == true){
                        System.out.print("You have " + playerList.get(currentPlayer).getNumGuesses() + " guesses left.\n" +
                                "What is your next guess?\n" +
                                "Type in the characters for your guess and press enter.\n" +
                                "Enter guess: ");
                    }
                    else{
                        System.out.print("What is your next guess?\n" +
                                "Type in the characters for your guess and press enter.\n" +
                                "Enter guess: ");
                    }

                    guess = in.nextLine();
                    if(guess.equals("HISTORY")){
                        validCmd = true;
                        System.out.print("\n");
                        for(int i = 0; i < playerList.get(currentPlayer).getHistoryGuess().size(); i++){
                            System.out.println(playerList.get(currentPlayer).getHistoryGuess().get(i) + "\t\t" + playerList.get(currentPlayer).getHistoryResult().get(i));
                        }
                        System.out.print("\n");
                    }
                    else{
                        validCmd = board.validateGuess(guess);
                        if (validCmd == true) {
                            playerList.get(currentPlayer).decreaseNumGuesses();
                            result = board.resultGuess(guess,playerList.get(currentPlayer));
                            playerList.get(currentPlayer).setHistoryGuess(guess);
                            if(playerList.get(currentPlayer).getHistoryResultNum().get(playerList.get(currentPlayer).getHistoryResultNum().size()-1).get(0)==GameConfiguration.pegNumber){
                                win = true;
                                System.out.println("\n" + guess + " -> " + "Result: " + result + " - You win!!\n");
                                break;
                            }
                            else{
                                win = false;
                                if(playerList.get(currentPlayer).getNumGuesses()==0){
                                    System.out.println("\nSorry, you are out of guesses. You lose, boo-hoo.\n");
                                }
                                else{
                                    System.out.println("\n" + guess + " -> " + "Result: " + result + "\n");
                                }
                            }
                        }
                        else {
                            System.out.println("\n" + guess + " -> INVALID GUESS\n");
                        }
                    }
                }
                System.out.print("Are you ready for another game (Y/N): ");
                win = false;
                play = in.nextLine();
                currentPlayer++;
            }
        }
        else {
            while(play.equals("Y")){
                System.out.println("\nGenerating secret code ...\n");
                code = SecretCodeGenerator.getInstance().getNewSecretCode();
                Board board = new Board(code);
                playerList.add(new Player());
                while(playerList.get(currentPlayer).getNumGuesses()!=0) {
                    if(validCmd == true){
                        System.out.print("You have " + playerList.get(currentPlayer).getNumGuesses() + " guesses left.\n" +
                                "What is your next guess?\n" +
                                "Type in the characters for your guess and press enter.\n" +
                                "Enter guess: ");
                    }
                    else{
                        System.out.print("What is your next guess?\n" +
                                "Type in the characters for your guess and press enter.\n" +
                                "Enter guess: ");
                    }
                    guess = in.nextLine();
                    if(guess.equals("HISTORY")){
                        validCmd = true;
                        System.out.print("\n");
                        for(int i = 0; i < playerList.get(currentPlayer).getHistoryGuess().size(); i++){
                            System.out.println(playerList.get(currentPlayer).getHistoryGuess().get(i) + "\t\t" + playerList.get(currentPlayer).getHistoryResult().get(i));
                        }
                        System.out.print("\n");
                    }
                    else{
                        validCmd = board.validateGuess(guess);
                        if (validCmd == true) {
                            playerList.get(currentPlayer).decreaseNumGuesses();
                            result = board.resultGuess(guess,playerList.get(currentPlayer));
                            playerList.get(currentPlayer).setHistoryGuess(guess);
                            if(playerList.get(currentPlayer).getHistoryResultNum().get(playerList.get(currentPlayer).getHistoryResultNum().size()-1).get(0)==GameConfiguration.pegNumber){
                                win = true;
                                System.out.println("\n" + guess + " -> " + "Result: " + result + " - You win!!\n");
                                break;
                            }
                            else{
                                win = false;
                                if(playerList.get(currentPlayer).getNumGuesses()==0){
                                    System.out.println("\nSorry, you are out of guesses. You lose, boo-hoo.\n");
                                }
                                else{
                                    System.out.println("\n" + guess + " -> " + "Result: " + result + "\n");
                                }
                            }
                        }
                        else {
                            System.out.println("\n" + guess + " -> INVALID GUESS\n");
                        }
                    }
                }
                System.out.print("Are you ready for another game (Y/N): ");
                win = false;
                play = in.nextLine();
                currentPlayer++;
            }
        }
    }
}

