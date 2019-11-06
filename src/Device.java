
public class Device {
	
	public int id;
	public String name;
	public String type;
	public String category;
	public String startDate;
	public int lifeTime;
	public int TTL;
	public int serviceTime = 0;
	public int fault = 0;
	public int faultTime = 0;
	public int value = 0;
	public int minValue = 0;
	public int maxValue = 0;
	
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
	
	public void setValue(int val) {
		value = val;
		if(value > maxValue || value < minValue)
			fault = 2;
	}
	
	public String toString() {
		return id + ";" + name + ";" + type + ";" + category + ";" + startDate + ";" + lifeTime + ";" + TTL + ";" + serviceTime + ";" + fault + ";" + faultTime + ";" + value + ";" + minValue + ";" + maxValue;
	}
	
}
