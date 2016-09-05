package ru.alexalex88.models;

import java.util.Random;

/**
 * Created by Alex on 05.09.2016.
 */
public class Board {
    private Random random = new Random(System.currentTimeMillis());

    /**
     * represents game squares
     */
    private int[][] squares = new int[4][4];

    /**
     * number of blank squares on the squares
     */
    private int blankSquares;

    /**
     * getter for squares
     * @return return array int[4][4] which contains values on the squares
     */
    public int[][] getSquares() {
        return squares;
    }

    /**
     * try to swipe squares right
     */
    public void swipeRight(){
        for(int i = 0; i < 4; i++)
            swipeRow(i, true);
        generateValue();
    }

    /**
     * try to swipe squares left
     */
    public void swipeLeft(){
        for(int i = 0; i < 4; i++)
            swipeRow(i, false);
        generateValue();
    }

    /**
     * try to swipe squares up
     */
    public void swipeUp(){
        for(int i = 0; i < 4; i++)
            swipeColumn(i, true);
        generateValue();
    }

    /**
     * try to swipe squares down
     */
    public void swipeDown(){
        for(int i = 0; i < 4; i++)
            swipeColumn(i, false);
        generateValue();
    }

    /**
     * start new game
     */
    public  void newGame(){
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                squares[i][j] = 0;
        blankSquares = 16;
    }

    /**
     * check if game is over
     * @return true if game is over, false if game is on
     */
    public boolean isGameOver(){
        return true;
    }

    /**
     * generate new value on one of the blank squares
     * new value is 2 or 4
     * variable p stored probability of 2
     */
    private void generateValue(){
        double p = 0.8;
        int n = random.nextInt(blankSquares);
        int zerosCount = 0;

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if(squares[i][j] == 0){
                    if(n == zerosCount) {
                        squares[i][j] = (random.nextDouble() < p) ? 2 : 4;
                        blankSquares--;
                        return;
                    }
                    else {
                        zerosCount++;
                    }
                }
    }

    /**
     * check if squares can be swiped
     * @return true if squares can be swiped, false otherwise
     */
    private boolean hasMove(){
        return false;
    }

    /**
     * swipe specified row
     * @param i - number of swiped row
     * @param right - swipe direction, true - right, false - left
     */
    private void swipeRow(int i, boolean right){;}

    /**
     * swipe specified column
     * @param i - number of swiped column
     * @param up - swipe direction, true - up, false - down
     */
    private void swipeColumn(int i, boolean up){;}
}
