package assignment5;

/* EE422C Assignment #2 submission by
 * Replace <...> with your actual data.
 * <Paul J. Han>
 * <pjh2235>
 */

import java.util.ArrayList;

import static assignment2.GameConfiguration.pegNumber;

public class Board{

    ArrayList<String> secretCode;
    public Board(String code){
        secretCode = new ArrayList<String>(pegNumber);
        for(int i = 0; i < pegNumber; i++){
            secretCode.add(code.substring(i,i+1));
        }
    }
    public boolean validateGuess(String guess){
        if(guess.length()!=pegNumber){
            return false;
        }
        ArrayList<String> tokenGuess = new ArrayList<String>(guess.length());
        ArrayList<Boolean> tokenGuessArray = new ArrayList<Boolean>(guess.length());
        for(int i = 0; i < guess.length(); i++){
            tokenGuess.add(guess.substring(i,i+1));
            tokenGuessArray.add(false);
        }
        for(int i = 0; i < guess.length(); i++){
            for(int x = 0; x < GameConfiguration.colors.length; x++){
                if(tokenGuess.get(i).equals(GameConfiguration.colors[x]) == true){
                    tokenGuessArray.set(i,true);
                    break;
                }
            }
        }
        for(int i = 0; i < tokenGuessArray.size(); i++){
            if(tokenGuessArray.get(i) == false){
                return false;
            }
        }
        return true;
    }
    public String resultGuess(String guess, Player player){
        String result = "";
        ArrayList<String> copyCode = new ArrayList<String>();
        ArrayList<String> copyGuess = new ArrayList<String>();
        for(int i = 0; i < secretCode.size(); i++){
            copyCode.add(secretCode.get(i));
        }
        for(int i = 0; i < guess.length(); i++){
            copyGuess.add(guess.substring(i,i+1));
        }

        int bPeg = 0;
        int wPeg = 0;
        for(int i = 0; i < copyGuess.size(); i++){
            if(copyGuess.get(i).equals(copyCode.get(i))){
                bPeg++;
                copyCode.set(i,"-");
                copyGuess.set(i,"-");
            }
        }
        boolean exists = false;
        for(int i = 0; i < copyGuess.size(); i++){
            if(!copyGuess.get(i).equals("-")){
                for(int x = 0; x < copyCode.size(); x++){
                    if(copyGuess.get(i).equals(copyCode.get(x))){
                        copyCode.set(x,"-");
                        exists = true;
                    }
                }
                if(exists == true){
                    wPeg++;
                    exists = false;
                }
            }
        }
        player.setHistoryResultNum(bPeg,wPeg);
        result = bPeg + "B_" + wPeg + "W";
        player.setHistoryResult(result);
        return result;
    }
}
