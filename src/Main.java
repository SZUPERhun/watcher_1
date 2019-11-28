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
		machines.get(0).addNewMachinePart(new MachinePart(0, "egesterTemp", "tertmp", "temperature", "2019.11.05", 100, 80, 100));
		machines.get(0).addNewMachinePart(new MachinePart(1, "szellozoTemp", "szelltmp", "temperature", "2019.11.05", 100, 40, 50));
		machines.get(0).addNewMachinePart(new MachinePart(2, "langor", "lang", "langor", "2019.11.05", 100, 0, 1));
		machines.get(0).addNewMachinePart(new MachinePart(3, "gaznyomas", "press", "pressure", "2019.11.05", 100, 0, 100));
		machines.get(0).addNewMachinePart(new MachinePart(4, "gazcsap", "csap", "zar", "2019.11.05", 100, 0, 100));
		
		sch = new Scheduler();
		sch.start(machines);
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
