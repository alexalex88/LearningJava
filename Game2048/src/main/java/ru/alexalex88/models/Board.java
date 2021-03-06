package ru.alexalex88.models;

import java.util.Random;

/**
 * Created by Alex on 05.09.2016.
 */
public class Board {
    private Random random = new Random(System.currentTimeMillis());

    private int score;

    public int getScore() {
        return score;
    }

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
        boolean changed = false;
        for(int i = 0; i < 4; i++)
            changed = (swipeRow(i, true)) ? true : changed;
        if (changed) generateValue();
    }

    /**
     * try to swipe squares left
     */
    public void swipeLeft(){
        boolean changed = false;
        for(int i = 0; i < 4; i++)
            changed = (swipeRow(i, false)) ? true : changed;
        if (changed) generateValue();
    }

    /**
     * try to swipe squares up
     */
    public void swipeUp(){
        boolean changed = false;
        for(int i = 0; i < 4; i++)
            changed = (swipeColumn(i, true)) ? true : changed;
        if (changed) generateValue();
    }

    /**
     * try to swipe squares down
     */
    public void swipeDown(){
        boolean changed = false;
        for(int i = 0; i < 4; i++)
            changed = (swipeColumn(i, false)) ? true : changed;
        if (changed) generateValue();
    }

    /**
     * start new game
     */
    public  void newGame(){
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                squares[i][j] = 0;
        blankSquares = 16;
        score = 0;
        generateValue();
        generateValue();
    }

    /**
     * check if game is over
     * @return true - game over, false - game on
     */
    public boolean isGameOver(){
        //if (score>20) return true;
        return (blankSquares > 0 || hasMove()) ? false : true;
    }

    /**
     * generate new value on one of the blank squares
     * new value is 1 or 2
     * variable p stored probability of 1
     */
    private void generateValue(){
        if(blankSquares == 0) return;
        double p = 0.9;
        int n = random.nextInt(blankSquares);
        int zerosCount = 0;

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if(squares[i][j] == 0){
                    if(n == zerosCount) {
                        squares[i][j] = (random.nextDouble() < p) ? 1 : 2;
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
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 3; j++)
                if(squares[i][j] != 0 && squares[i][j] == squares[i][j + 1]) return true;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 4; j++)
                if(squares[i][j] != 0 && squares[i][j] == squares[i + 1][j]) return true;
        return false;
    }

    /**
     * swipe specified row
     * we move from the edge square into pointed direction
     * in every square we check if it is 0 and if true we look the row further trying to find non zero value and swap them
     * if row contains only zero values than row is swiped
     * after swapping squares we look the row further, if next non zero value is the same to value in current square than we merge this squares
     * moving to the next square in the row
     * @param i - number of swiped row
     * @param right - swipe direction, true - right, false - left
     * @return true - row was changed, false - wasn't changed
     */
    private boolean swipeRow(int i, boolean right){
        boolean changed = false;
        int dirRight = (right) ? -3 : 0;

        for (int j = 0 + dirRight; j < 3 + dirRight ; j++){
            int k = j + 1;

            if (squares[i][Math.abs(j)] == 0) {
                while ((k < 3 + dirRight) && (squares[i][Math.abs(k)] == 0)) k++;
                if (squares[i][Math.abs(k)] != 0) {
                    squares[i][Math.abs(j)] = squares[i][Math.abs(k)];
                    squares[i][Math.abs(k)] = 0;
                    changed = true;
                }
                else{
                    return changed;
                }
            }

            k = j + 1;
            while ((k < 3 + dirRight) && (squares[i][Math.abs(k)] == 0)) k++;
            if (squares[i][Math.abs(k)] == squares[i][Math.abs(j)]) {
                squares[i][Math.abs(j)]++;
                squares[i][Math.abs(k)] = 0;
                blankSquares++;
                score += (1 << squares[i][Math.abs(j)]);
                changed = true;
            }
        }
        return changed;
    }

    /**
     * swipe specified column
     * we move from the edge square into pointed direction
     * in every square we check if it is 0 and if true we look the column further trying to find non zero value and swap them
     * if column contains only zero values than column is swiped
     * after swapping squares we look the column further, if next non zero value is the same to value in current square than we merge this squares
     * moving to the next square in the column
     * @param i - number of swiped column
     * @param up - swipe direction, true - up, false - down
     * @return true - column was changed, false - wasn't changed
     */
    private boolean swipeColumn(int i, boolean up){
        boolean changed = false;
        int dirUp = (up) ? 0 : -3;

        for (int j = 0 + dirUp; j < 3 + dirUp ; j++){
            int k = j + 1;
            if (squares[Math.abs(j)][i] == 0) {
                while ((k < 3 + dirUp) && (squares[Math.abs(k)][i] == 0)) k++;
                if (squares[Math.abs(k)][i] != 0) {
                    squares[Math.abs(j)][i] = squares[Math.abs(k)][i];
                    squares[Math.abs(k)][i] = 0;
                    changed = true;
                }
                else{
                    return changed;
                }
            }

            k = j + 1;
            while ((k < 3 + dirUp) && (squares[Math.abs(k)][i] == 0)) k++;
            if (squares[Math.abs(k)][i] == squares[Math.abs(j)][i]) {
                squares[Math.abs(j)][i]++;
                squares[Math.abs(k)][i] = 0;
                blankSquares++;
                score += (1 << squares[Math.abs(j)][i]);
                changed = true;
            }
        }
        return changed;
    }
}
