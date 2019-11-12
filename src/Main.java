import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static List<Machine> machines;
	static Scheduler sch;
	
	public static void main(String args[]) {
		machines = new ArrayList<Machine>();
		
		init();
	}
	
	public static void init() {
		machines.add(new Machine(0, "koho1"));
		MachinePart MachinePart = new MachinePart(0, "egesterTemp", "tmp001", "temperature", "2019.11.05", 100, 0, 100);
		machines.get(0).addNewMachinePart(MachinePart);
		MachinePart = new MachinePart(1, "szellozoTemp", "tmp001", "temperature", "2019.11.05", 100, 0, 100);
		machines.get(0).addNewMachinePart(MachinePart);
		MachinePart = new MachinePart(2, "langor", "lang001", "langor", "2019.11.05", 100, 0, 1);
		machines.get(0).addNewMachinePart(MachinePart);
		MachinePart = new MachinePart(3, "gaznyomas", "press001", "pressure", "2019.11.05", 100, 0, 100);
		machines.get(0).addNewMachinePart(MachinePart);
		MachinePart = new MachinePart(4, "gazcsap", "csap001", "zar", "2019.11.05", 100, 0, 100);
		machines.get(0).addNewMachinePart(MachinePart);
		
		sch = new Scheduler();
		sch.start(machines);
	}
}
