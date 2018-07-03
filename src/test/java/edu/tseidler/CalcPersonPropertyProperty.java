package edu.tseidler;

import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static org.testfx.matcher.control.LabeledMatchers.*;

public class CalcPersonPropertyProperty extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("calculator.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void shouldActivateButton() {
        FxAssert.verifyThat("#searchButton", hasText("search"));
        FxAssert.verifyThat("#searchButton", org.testfx.matcher.control.ButtonMatchers.isCancelButton());
    }

}
