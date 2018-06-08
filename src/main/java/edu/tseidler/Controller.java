package edu.tseidler;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML
    GridPane main;
    @FXML
    TextArea textArea;
    @FXML
    Label myLabel;
    @FXML
    TextField firstArgument;
    @FXML
    TextField secondArgument;
    @FXML
    Button multiplyButton;
    @FXML
    Label result;

    private static int i = 0;

    public void initialize() {
        main.addEventHandler(KeyEvent.KEY_PRESSED, event -> onEnterPressed(event));
    }

    private void onEnterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) showText();
    }

    public void showText() {
        i++;
        textArea.setText("hello: " + i);
        if (!myLabel.isVisible())
            myLabel.setVisible(true);
    }

    public void multiply(MouseEvent mouseEvent) {
        int a = 0;
        int b = 0;
        try {
            try {
                a = Integer.valueOf(firstArgument.getText());
            } catch (NumberFormatException e) {
                firstArgument.setText("error!");
                throw new NumberFormatException();
            }
            try {
                b = Integer.valueOf(secondArgument.getText());
            } catch (NumberFormatException e) {
                secondArgument.setText("error!");
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            result.setText("error!");
            return;
        }
        result.setText("" + a * b);
    }
}
