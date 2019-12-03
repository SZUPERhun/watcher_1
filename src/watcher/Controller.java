package watcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.List;


public class Controller {

    @FXML
    private Button nextBtn;
    @FXML
    private Button previousBtn;
    @FXML
    private Button errorBtn;

    private List<Machine> machines;

    private double temp = 0;

    private Text labelText = new Text(Double.toString(temp));

    @FXML
    private Label MachineLabel;

    public void updateData(List<Machine> machines) {
        this.machines = machines;
        this.temp = machines.get(0).getMachinePart("tertmp").getValue();
        MachineLabel.setText(String.format("%1$,.2f", temp));
        if (machines.get(0).getMachinePart("tertmp").getFault() == 0) {
        	errorBtn.setStyle("-fx-background-color: #00FF00; ");
    	} else {
    		errorBtn.setStyle("-fx-background-color: #FF0000; ");
    	}
    }

    @FXML
    private void handleNewdayButtonAction(ActionEvent event){
        MachineLabel.setText(Double.toString(this.temp));
    }

    @FXML
    private void handleErrorAction(ActionEvent event){
    	if (machines.get(0).getMachinePart("tertmp").getFault() == 0) {
    		machines.get(0).getMachinePart("tertmp").setFault(1);
    	} else {
    		machines.get(0).getMachinePart("tertmp").setFault(0);
    	}
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
