package ru.alexalex88;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.alexalex88.controllers.GameFieldController;
import ru.alexalex88.models.Board;

public class Main extends Application {
    private Board board;
    private GameFieldController gameFieldController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        board = new Board();
        board.newGame();

        String fxmlFile = "/GameField.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setTitle("2048");
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        scene.getStylesheets().add((getClass().getResource("/css/GameTheme.css")).toExternalForm());
        gameFieldController = loader.getController();
        gameFieldController.setBoard(board);
        gameFieldController.setStage(primaryStage);
        gameFieldController.drawBoard(board.getSquares());
        primaryStage.show();
        root.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
