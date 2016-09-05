package ru.alexalex88.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import ru.alexalex88.models.Board;

public class GameFieldController {
    private Board board;

    @FXML
    private Label label00;
    @FXML
    private Label label01;
    @FXML
    private Label label02;
    @FXML
    private Label label03;
    @FXML
    private Label label10;
    @FXML
    private Label label11;
    @FXML
    private Label label12;
    @FXML
    private Label label13;
    @FXML
    private Label label20;
    @FXML
    private Label label21;
    @FXML
    private Label label22;
    @FXML
    private Label label23;
    @FXML
    private Label label30;
    @FXML
    private Label label31;
    @FXML
    private Label label32;
    @FXML
    private Label label33;

    @FXML
    private Label[][] labels;

    public void setBoard(Board board) {
        this.board = board;
    }

    @FXML
    private void initialize() {
        labels = new Label[4][4];
        labels[0][0] = label00;
        labels[0][1] = label01;
        labels[0][2] = label02;
        labels[0][3] = label03;
        labels[1][0] = label10;
        labels[1][1] = label11;
        labels[1][2] = label12;
        labels[1][3] = label13;
        labels[2][0] = label20;
        labels[2][1] = label21;
        labels[2][2] = label22;
        labels[2][3] = label23;
        labels[3][0] = label30;
        labels[3][1] = label31;
        labels[3][2] = label32;
        labels[3][3] = label33;
    }

    public void drawBoard(int[][] board){
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                labels[i][j].setText(Integer.valueOf(board[i][j]).toString());
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()){
            case LEFT:
                board.swipeLeft();
                drawBoard(board.getBoard());
                break;
            case RIGHT:
                board.swipeRight();
                drawBoard(board.getBoard());
                break;
            case UP:
                board.swipeUp();
                drawBoard(board.getBoard());
                break;
            case DOWN:
                board.swipeDown();
                drawBoard(board.getBoard());
                break;
        }
    }
}
