package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;


    public void onEnter (ActionEvent actionEvent) {
         textArea.appendText(textField.getText()+'\n');
         textField.requestFocus();
         textField.clear();
    }

}
