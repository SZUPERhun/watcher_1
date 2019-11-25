package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static sample.Main.machines;
import static sample.Main.processLine;

public class Controller {

    @FXML
    private Button nextBtn;
    @FXML
    private Button previousBtn;
    @FXML
    private Button newdayBtn;

    @FXML
    private Label MachineLabel;


    @FXML
    private void handleNewdayButtonAction(ActionEvent event){
        processLine("newday");
        MachineLabel.setText(machines.get(0).toStringForJavaFX(i));
    }

    private int i = 0;

    @FXML
    private void handleNextButtonAction(ActionEvent event){
        if(i != 4)
            i++;
        MachineLabel.setText(machines.get(0).toStringForJavaFX(i));
    }

    public void handlePreviousButtonAction(ActionEvent event) {
        if(i != 0)
            i--;
        MachineLabel.setText(machines.get(0).toStringForJavaFX(i));
    }
}
