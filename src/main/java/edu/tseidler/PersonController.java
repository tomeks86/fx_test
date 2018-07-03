package edu.tseidler;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;
import java.util.stream.Collectors;

public class PersonController {
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    private PersonProperty personProperty = new PersonProperty("stefan", "beton");

    public void initialize() {
        firstNameLabel.textProperty().bind(personProperty.firstNameProperty());
        lastNameLabel.textProperty().bind(personProperty.lastNameProperty());
    }

    private String getRandomString() {
        return new Random().ints(5, 30, 100)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining(""));
    }

    @FXML
    public void changeLabels() {
        if (new Random().nextInt(30) % 2 == 1)
            personProperty.setFirstName(getRandomString());
        else
            personProperty.setLastName(getRandomString());
    }
}
