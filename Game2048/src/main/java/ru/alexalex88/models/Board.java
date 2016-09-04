package ru.alexalex88.models;

/**
 * Created by Alex on 05.09.2016.
 */
public class Board {
    private int[][] board = new int[4][4];
    
    private int freeSquares;

    public int[][] getBoard() {
        return board;
    }

    public void swipeRight(){;}

    public void swipeLeft(){;}

    public void swipeUp(){;}

    public void swipeDown(){;}

    public  void newGame(){
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                board[i][j] = 0;
    }

    public boolean isGameOver(){
        return true;
    }

    private void generateValue(){;}

    private boolean hasMove(){
        return false;
    }
}
