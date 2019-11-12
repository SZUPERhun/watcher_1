import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {
	private Timer t;
	
	public Scheduler() {
		t = new Timer();
	}

	public void start(List<Machine> machines) {
		Regulator regulator = new Regulator();
		t.schedule(new TimerTask() {
		    @Override
		    public void run() {
		    	for (Machine machine : machines) { 
		    		System.out.println(machine);
		    		regulator.regulate(machine);
		    	}
		    	
		    }
		}, 0, 3000);
	}
	
	public void stop() {
		t.cancel();
	}
}
