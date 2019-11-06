import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static List<Departure> departures;
	
	public static void main(String args[]) {
		
		departures = new ArrayList<Departure>();
		
		init();
		
		System.out.println(departures.get(0).toString());
	}
	
	public static void init() {
		departures.add(new Departure(0, "koho1"));
		Device device = new Device(0, "egesterTemp", "tmp001", "temperature", "2019.11.05", 100, 0, 100);
		departures.get(0).AddNewDevice(device);
		device = new Device(1, "szellozoTemp", "tmp001", "temperature", "2019.11.05", 100, 0, 100);
		departures.get(0).AddNewDevice(device);
		device = new Device(2, "langor", "lang001", "langor", "2019.11.05", 100, 0, 1);
		departures.get(0).AddNewDevice(device);
		device = new Device(3, "gaznyomas", "press001", "pressure", "2019.11.05", 100, 0, 100);
		departures.get(0).AddNewDevice(device);
		device = new Device(4, "gazcsap", "csap001", "zar", "2019.11.05", 100, 0, 100);
		departures.get(0).AddNewDevice(device);
	}
	
	public static void processLine(String line) {
		String[] str = line.split(";");
		if(str[0].equals("newday"))
			for(int i = 0; i < departures.size(); i++)
				departures.get(i).NewDay();
		else if(str.length == 4) {
			if(str[2].equals("value"))
				departures.get(Integer.parseInt(str[0])).devices.get(Integer.parseInt(str[1])).setValue(Integer.parseInt(str[3]));
			else if(str[2].equals("fault"))
				departures.get(Integer.parseInt(str[0])).devices.get(Integer.parseInt(str[1])).fault = (Integer.parseInt(str[3]));
			//else if(str[2].equals("fault"))
				//departures.get(Integer.parseInt(str[0])).devices.get(Integer.parseInt(str[1])).fault = (Integer.parseInt(str[3]));
			//else if(str[2].equals("fault"))
				//departures.get(Integer.parseInt(str[0])).devices.get(Integer.parseInt(str[1])).fault = (Integer.parseInt(str[3]));
			//else if(str[2].equals("fault"))
				//departures.get(Integer.parseInt(str[0])).devices.get(Integer.parseInt(str[1])).fault = (Integer.parseInt(str[3]));
			//else if(str[2].equals("fault"))
				//departures.get(Integer.parseInt(str[0])).devices.get(Integer.parseInt(str[1])).fault = (Integer.parseInt(str[3]));
				
		}
	}
	
}