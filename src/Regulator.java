
public class Regulator {	
	
	public Regulator() {
	
	}
	
	public void regulate(Departure departure) {
		double currentValue = departure.getDevice("tmp001").getValue();
		departure.getDevice("tmp001").setValue(currentValue + 1);
	}

}