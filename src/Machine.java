import java.util.ArrayList;
import java.util.List;

public class Machine {
	
	private int id;
	private String name;
	private List<MachinePart> machineParts = new ArrayList<MachinePart>();
	
	public Machine(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public MachinePart addNewMachinePart(MachinePart machinePart) {
		machineParts.add(machinePart);
		return machinePart;
	}
	
	public void nextDay() {
		for(int i = 0; i < machineParts.size(); i++)
			machineParts.get(i).incAge();
	}
	
	public String toString() {
		String result = 
			"MACHINE: \n" +
			"id: " + id + "\n" +
			"name: " + name + "\n" +
			"============================\n" +
			"MACHINEPARTS: \n";
		
		int i = 0;
		for (MachinePart machinePart : machineParts) {
			result += machinePart;
			if (++i < machineParts.size()) {
				result += "---------------------------- \n";
			}
		
    	}
		result += "\n";
		
		return result;
	}
	
	public List<MachinePart> getMachineParts() {
		return machineParts;
	}
	
	public MachinePart getMachinePart(String name) {
		MachinePart result = machineParts.stream()
				  .filter(machinePart -> name.equals(machinePart.getName()))
				  .findAny()
				  .orElse(machineParts.get(0));
		return result;
	}

}
