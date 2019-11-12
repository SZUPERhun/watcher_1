
public class Device {
	
	private int id;
	private String name;
	private String type;
	private String category;
	private String startDate;
	private int lifeTime;
	private int TTL;
	private int serviceTime = 0;
	private int fault = 0;
	private int faultTime = 0;
	private double value = 0;
	private double minValue = 0;
	private double maxValue = 0;
	
	public Device() {
		
	}
	
	public Device(int id1, String name1, String type1, String category1, String startDate1, int lifeTime1) {
		id = id1;
		name = name1;
		type = type1;
		category = category1;
		startDate = startDate1;
		lifeTime = lifeTime1;
		TTL = lifeTime;
	}
	
	public Device(int id1, String name1, String type1, String category1, String startDate1, int lifeTime1, int minValue1, int maxValue1) {
		id = id1;
		name = name1;
		type = type1;
		category = category1;
		startDate = startDate1;
		lifeTime = lifeTime1;
		TTL = lifeTime;
		minValue = minValue1;
		maxValue = maxValue1;
	}
	
	public void GetServiced() {
		IncServiceTime();
		if(serviceTime == 1)
			TTL = (int)(lifeTime * 0.8);
		else if(serviceTime == 2)
			TTL = (int)(lifeTime * 0.6);
		else if(serviceTime == 3)
			TTL = (int)(lifeTime * 0.4);
		else if(serviceTime == 4)
			TTL = (int)(lifeTime * 0.2);
		else if(serviceTime <= 5)
			TTL = 0;
	}
	
	public void IncAge() {
		TTL--;
	}
	
	public void IncServiceTime() {
		serviceTime++;
	}
	
	public void setValue(double val) {
		value = val;
		if(value > maxValue || value < minValue)
			fault = 2;
	}
	
	public String toString() {
		return id + ";" + name + ";" + type + ";" + category + ";" + startDate + ";" + lifeTime + ";" + TTL + ";" + serviceTime + ";" + fault + ";" + faultTime + ";" + value + ";" + minValue + ";" + maxValue;
	}
	
	public void setFault(int value) {
		fault = value;
	}

	public double getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
}
