package watcher;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.List;

public class Main  extends  Application{

	static List<Machine> machines;
	static Scheduler sch;

	private static void handle(WindowEvent t) {
		Platform.exit();
		System.exit(0);
	}

	public void start(Stage primaryStage) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
		Parent root = loader.load();

		Controller controller = loader.<Controller>getController();

		Thread thread = new Thread(new Runnable() {
			@Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                    	controller.updateData(machines);
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }
		});
        // don't let thread prevent JVM shutdown
        thread.setDaemon(true);
        thread.start();

        primaryStage.setTitle("Watcher");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.setResizable(false);
		primaryStage.show();
		primaryStage.setOnCloseRequest(Main::handle);
	}

	public static void main(String args[]) {
		machines = new ArrayList<Machine>();

		machines.add(new Machine(0, "koho1"));
		machines.get(0).addNewMachinePart(new MachinePart(0, "egesterTemp", "tertmp", "temperature", "2019.11.05", 100, 80, 100));
		machines.get(0).addNewMachinePart(new MachinePart(1, "szellozoTemp", "szelltmp", "temperature", "2019.11.05", 100, 40, 50));
		machines.get(0).addNewMachinePart(new MachinePart(2, "langor", "lang", "langor", "2019.11.05", 100, 0, 1));
		machines.get(0).addNewMachinePart(new MachinePart(3, "gaznyomas", "press", "pressure", "2019.11.05", 100, 0, 100));
		machines.get(0).addNewMachinePart(new MachinePart(4, "gazcsap", "csap", "zar", "2019.11.05", 100, 0, 100));

		machines.add(new Machine(1, "koho2"));
		machines.get(1).addNewMachinePart(new MachinePart(0, "egesterTemp", "tertmp", "temperature", "2019.11.05", 100, 80, 100));
		machines.get(1).addNewMachinePart(new MachinePart(1, "szellozoTemp", "szelltmp", "temperature", "2019.11.05", 100, 40, 50));
		machines.get(1).addNewMachinePart(new MachinePart(2, "langor", "lang", "langor", "2019.11.05", 100, 0, 1));
		machines.get(1).addNewMachinePart(new MachinePart(3, "gaznyomas", "press", "pressure", "2019.11.05", 100, 0, 100));
		machines.get(1).addNewMachinePart(new MachinePart(4, "gazcsap", "csap", "zar", "2019.11.05", 100, 0, 100));

		sch = new Scheduler();
		sch.start(machines);

		launch(args);
	}

	public static void processLine(String line) {
		String[] str = line.split(";");
		if(str[0].equals("newday"))
			for(int i = 0; i < machines.size(); i++)
				machines.get(i).nextDay();
		else if(str.length == 4)
			if(str[2].equals("serviced"))
				machines.get(Integer.parseInt(str[0])).getMachineParts().get(Integer.parseInt(str[1])).getServiced();
		else if(str.length == 4) {
			if(str[2].equals("value"))
				machines.get(Integer.parseInt(str[0])).getMachineParts().get(Integer.parseInt(str[1])).setValue(Integer.parseInt(str[3]));
			else if(str[2].equals("fault"))
				machines.get(Integer.parseInt(str[0])).getMachineParts().get(Integer.parseInt(str[1])).setFault(Integer.parseInt(str[3]));
		}
	}
}
