package hw1;

import java.util.HashMap;
import java.util.Map;

import hw1.Observer;

public class DestObserver implements Observer {
	private String name;
	private Map<String, String> targets = new HashMap<String, String>();
	
	public DestObserver(String string) {
		setName(string);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	
	@Override
	public void update(Subject bk) {
		if (bk.getState() == targets.get(bk.getname())) {
			return;
		}
		myprint.mylogclass(this.name + " OBSERVED " + bk.getname() + " REACHING STATE: " + bk.getState());	
		targets.remove(bk.getname());
		targets.put(bk.getname(), bk.getState());
	}

	@Override
	public void addtolist(Subject bk) {
		targets.put(bk.getname(), bk.getState());
	}
	@Override
	public void removefromlist(Subject bk) {
		targets.remove(bk.getname());
	}
}
