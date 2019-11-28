package watcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;


public class Controller {

    @FXML
    private Button nextBtn;
    @FXML
    private Button previousBtn;
    @FXML
    private Button newdayBtn;

    private List<Machine> machines;

    @FXML
    private Label MachineLabel;

    public void passMachines(List<Machine> machines) {
        this.machines = machines;
    }

    @FXML
    private void handleNewdayButtonAction(ActionEvent event){
        MachineLabel.setText(Double.toString(machines.get(0).getMachinePart("tertmp").getValue()));
    }

    private int i = 0;

    @FXML
    private void handleNextButtonAction(ActionEvent event){
        if(i != 4)
            i++;
        MachineLabel.setText(Double.toString(machines.get(0).getMachinePart("tertmp").getValue()));
    }

    public void handlePreviousButtonAction(ActionEvent event) {
        if(i != 0)
            i--;
        MachineLabel.setText(Double.toString(machines.get(0).getMachinePart("tertmp").getValue()));
    }
}
