import java.util.ArrayList;
import java.util.Random;

public class thegame {
    private int yourResult;
    int playerMove;
    int Num;
    String resultPrint;
    Random rand = new Random();
    int playerWins = 0;
    int computerWins = 0;
    int tiesWins = 0;
    int wins = 0;

    /**
     * Method to determine the results of the game
     * @return returns the number that corresponds with a result
     */
    public int getPlay(int playerMove){
        int randMove = rand.nextInt(3);
        
        if(playerMove==(1)){
            if (randMove == 1){
                yourResult = 7;
            }else if(randMove == 2){
                yourResult = 2;
            }else{
                yourResult = 1;
            }
        } else if (playerMove==(2)) {
            if (randMove == 1){
                yourResult = 3;
            }else if(randMove == 2){
                yourResult = 7;
            }else{
                yourResult = 4;
            }
        } else {
            if (randMove == 1){
                yourResult = 6;
            }else if(randMove == 2){
                yourResult = 5;
            }else{
                yourResult = 7;
            }
        }
        return yourResult;
    }
    /**
     * Method to take the numbered result and turn it into a string labeling the result
     * @return returns the string version of the numbered result
     */
    public String getResult(int yourResult){
        if(yourResult == 1){
            resultPrint = "Rock crushes Scissors! You Win";
        } else if (yourResult == 2) {
            resultPrint = "Paper covers Rock! You Lose";
        }else if(yourResult == 3){
            resultPrint = "Paper covers Rock! You Win";
        }else if(yourResult == 4){
            resultPrint = "Scissors cuts Paper! You Lose";
        }else if(yourResult == 5){
            resultPrint = "Scissors cuts Paper! You Win";
        }else if(yourResult == 6){
            resultPrint = "Rock crushes Scissors! You lose";
        }else if(yourResult == 7) {
            resultPrint = "Same Move! Tie";
        }
        return resultPrint;
    }
    /**
     * Method to count the total number of games played
     * @return returns the updated number of games played
     */
    public int gameCounter(int yourResult){

        wins = wins +1;
        return wins;

    }
    /**
     * Method to count the total number of times the player has won
     * @return returns the updated number of times the player has won
     */
    public int playerWinCounter(int yourResult){

        playerWins = playerWins +1;
        return playerWins;

    }
    /**
     * Method to count the total number of times the computer has won
     * @return returns the updated number of times the computer has won
     */
    public int computerWinCounter(int yourResult){

        computerWins = computerWins +1;
        return computerWins;

    }
    /**
     * Method to count the total number of times there has been a tie
     * @return returns the updated number of times there has been a tie
     */
    public int tiesCounter(int yourResult){

        tiesWins = tiesWins +1;
        return tiesWins;

    }
}
