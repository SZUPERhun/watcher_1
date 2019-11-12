package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static sample.Main.machines;
import static sample.Main.processLine;

public class Controller {

    @FXML
    private Button btn;
    @FXML
    private Label innerLabel;
    @FXML
    private Label outerLabel;
    @FXML
    private Label gasLabel;
    @FXML
    private TextField textField;

    public void setGasLabel(Label gasLabel) {
        machines.get(0).getMachinePart("tmp001").getValue();
    }

    @FXML
    private void handleButtonAction(ActionEvent event){
        processLine(textField.getText());
    }

}
