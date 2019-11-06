import java.util.ArrayList;
import java.util.List;

public class Departure {
	
	public int id;
	public String name;
	public List<Device> devices = new ArrayList<Device>();
	
	public Departure() {
		
	}
	
	public Departure(int id1, String name1) {
		id = id1;
		name = name1;
	}
	
	public Device AddNewDevice(Device device) {
		devices.add(device);
		return device;
	}
	
	public void NewDay() {
		for(int i = 0; i < devices.size(); i++)
			devices.get(i).IncAge();
	}
	
	public String toString() {
		String result = id + ";" + name;
		for(int i = 0; i < devices.size(); i++) {
			result += "\n     " + devices.get(i).toString();
		}
		return result;
	}

}
