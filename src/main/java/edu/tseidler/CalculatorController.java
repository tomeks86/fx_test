package edu.tseidler;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.Locale;

public class CalculatorController {
    @FXML
    private GridPane root;
    @FXML
    private TextField firstArgument;
    @FXML
    private TextField secondArgument;
    @FXML
    private Button searchButton;
    @FXML
    private Label myLabel;
    @FXML
    private PersonController personController;

    public void initialize() {
        Locale.setDefault(Locale.ENGLISH);
        searchButton.setOnAction(this::handle);
        searchButton.disableProperty()
                .bind(Bindings.createBooleanBinding(() ->
                        numberArgumentCheck(), firstArgument.textProperty(), secondArgument.textProperty()));
        root.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ENTER && !searchButton.isDisabled())
                multiply();
        });
        root.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                System.out.println("quitting");
                Platform.exit();
            }
        });
        root.addEventHandler(KeyEvent.ANY, e -> personController.changeLabels());
    }

    private void multiply() {
        double a = Double.valueOf(firstArgument.getText());
        double b = Double.valueOf(secondArgument.getText());
        myLabel.setText(String.format("%.3f", a * b));
        firstArgument.setText("");
        secondArgument.setText("");
        firstArgument.requestFocus();
    }

    private boolean numberArgumentCheck() {
        boolean invalid = false;
        try {
            Double.valueOf(firstArgument.getText());
            Double.valueOf(secondArgument.getText());
        } catch (NumberFormatException e) {
            invalid = true;
        }
        return invalid;
    }

    private void handle(ActionEvent e) {
        multiply();
    }
}
