package ru.alexalex88.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import ru.alexalex88.models.Board;

import java.util.ArrayList;
import java.util.List;

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

    private List<Square> squareList;

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

        squareList = new ArrayList<>();
        squareList.add(new Square("", "-fx-text-fill: #776e65; -fx-background-color: #eee4da;"));
        squareList.add(new Square("2", "-fx-text-fill: #776e65; -fx-background-color: #eee4da;"));
        squareList.add(new Square("4", "-fx-text-fill: #776e65; -fx-background-color: #ede0c8;"));
        squareList.add(new Square("8", "-fx-text-fill: #f9f6f2; -fx-background-color: #f2b179;"));
        squareList.add(new Square("16", "-fx-text-fill: #f9f6f2; -fx-background-color: #f59563;"));
        squareList.add(new Square("32", "-fx-text-fill: #f9f6f2; -fx-background-color: #f67c5f;"));
        squareList.add(new Square("64", "-fx-text-fill: #f9f6f2; -fx-background-color: #f65e3b;"));
        squareList.add(new Square("128", "-fx-text-fill: #f9f6f2; -fx-background-color: #edcf72;"));
        squareList.add(new Square("256", "-fx-text-fill: #f9f6f2; -fx-background-color: #edcc61;"));
        squareList.add(new Square("512", "-fx-text-fill: #f9f6f2; -fx-background-color: #edc850;"));
        squareList.add(new Square("1024", "-fx-text-fill: #f9f6f2; -fx-background-color: #edc53f;"));
        squareList.add(new Square("2048", "-fx-text-fill: #f9f6f2; -fx-background-color: #edc22e;"));
        squareList.add(new Square("4096", "-fx-text-fill: #f9f6f2; -fx-background-color: #ff4444;"));
        squareList.add(new Square("8192", "-fx-text-fill: #f9f6f2; -fx-background-color: #ff4444;"));
        squareList.add(new Square("16384", "-fx-text-fill: #f9f6f2; -fx-background-color: #ff4444;"));
        squareList.add(new Square("32768", "-fx-text-fill: #f9f6f2; -fx-background-color: #ff4444;"));
        squareList.add(new Square("65536", "-fx-text-fill: #f9f6f2; -fx-background-color: #ff4444;"));
        squareList.add(new Square("131072", "-fx-text-fill: #f9f6f2; -fx-background-color: #ff4444;"));
    }

    public void drawBoard(int[][] board){
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++){
                labels[i][j].setText(squareList.get(board[i][j]).getText());
                labels[i][j].setStyle(squareList.get(board[i][j]).getStyle());
            }
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()){
            case LEFT:
                board.swipeLeft();
                drawBoard(board.getSquares());
                break;
            case RIGHT:
                board.swipeRight();
                drawBoard(board.getSquares());
                break;
            case UP:
                board.swipeUp();
                drawBoard(board.getSquares());
                break;
            case DOWN:
                board.swipeDown();
                drawBoard(board.getSquares());
                break;
        }
    }

    private class Square{
        final private String text;
        final private String style;

        public Square(String text, String style) {
            this.text = text;
            this.style = style;
        }

        public String getText() {
            return text;
        }

        public String getStyle() {
            return style;
        }
    }
}
