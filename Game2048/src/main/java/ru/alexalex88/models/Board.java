package ru.alexalex88.models;

/**
 * Created by Alex on 05.09.2016.
 */
public class Board {
    //represents game board
    private int[][] board = new int[4][4];

    //number of blank squares on the board
    private int blankSquares;

    //getter for board
    public int[][] getBoard() {
        return board;
    }

    //try to swipe squares right
    public void swipeRight(){;}

    //try to swipe squares left
    public void swipeLeft(){;}

    //try to swipe squares up
    public void swipeUp(){;}

    //try to swipe squares down
    public void swipeDown(){;}

    //start new game
    public  void newGame(){
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                board[i][j] = 0;
    }

    //check if game is over
    public boolean isGameOver(){
        return true;
    }

    //generate new value on one of the blank squares
    private void generateValue(){;}

    //check if squares can be swiped
    private boolean hasMove(){
        return false;
    }
}
