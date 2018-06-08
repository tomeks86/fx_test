package edu.tseidler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    private static int i = 0;

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
