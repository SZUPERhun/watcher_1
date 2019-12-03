package watcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.List;


public class Controller {

    @FXML
    private Button errorBtn;

    @FXML
    private Button resetBtn;

    @FXML
    private Label machineLabel;

    private List<Machine> machines;

    public void updateData(List<Machine> machines) {
    	this.machines = machines;
        machineLabel.setText(String.format("%1$,.2f", machines.get(0).getMachinePart("tertmp").getValue()));

        if (isWorking(machines.get(0))) {
        	errorBtn.setStyle("-fx-background-color: #00FF00; ");
    	} else {
    		errorBtn.setStyle("-fx-background-color: #FF0000; ");
    	}

        if (machines.get(0).getMachinePart("tertmp").getValue() == 0) {
        	resetBtn.setStyle("-fx-background-color: #00FF00; ");
    	} else {
    		resetBtn.setStyle("-fx-background-color: #FF0000; ");
    	}
    }

    private Boolean isWorking(Machine machine) {
    	for(MachinePart machinePart : machine.getMachineParts()) {
    		if (machinePart.getFault() != 0) {
        		return false;
        	}
    	}

    	return true;
    }

    @FXML
    private void handleNewdayButtonAction(ActionEvent event){
        //something
    }

    @FXML
    private void handleErrorAction(ActionEvent event){
    	machines.get(0).getMachinePart("tertmp").setFault(1);
    }

    @FXML
    private void handleResetAction(ActionEvent event){
    	if (machines.get(0).getMachinePart("tertmp").getValue() == 0) {
    		for(MachinePart machinePart : machines.get(0).getMachineParts()) {
        		machinePart.setFault(0);
        		machinePart.setInitFault(0);
        	}
    	}
    }
}
