
public class Regulator {	

	public void regulate(Machine departure) {
		double currentValue = departure.getMachinePart("tmp001").getValue();
		departure.getMachinePart("tmp001").setValue(currentValue + 1);
	}

}