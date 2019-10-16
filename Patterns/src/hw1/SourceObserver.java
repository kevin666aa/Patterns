package hw1;

import java.util.HashMap;
import java.util.Map;

import hw1.Observer;

public class SourceObserver implements Observer {
	private String name;
	private Map<String, String> targets = new HashMap<String, String>();
	private Map<String, Boolean> boolob = new HashMap<String, Boolean>();
	
	
	
	public SourceObserver(String string) {
		setName(string);
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public void update(Subject bk) {
		if (bk.getState() == targets.get(bk.getname())) {
			boolob.remove(bk.getname());
			boolob.put(bk.getname(), false);
			
			return;
		}
		if (boolob.get(bk.getname())) {
			boolob.remove(bk.getname());
			boolob.put(bk.getname(), false);
			myprint.mylogclass(this.name + " OBSERVED " + bk.getname() + " LEAVING STATE: UNOBSERVED" );
		} else {
			myprint.mylogclass(this.name + " OBSERVED " + bk.getname() + " LEAVING STATE: " + targets.get(bk.getname()));
		}
		targets.remove(bk.getname());
		targets.put(bk.getname(), bk.getState());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addtolist(Subject bk) {
		targets.put(bk.getname(), bk.getState());
		boolob.put(bk.getname(), true);
	}
	@Override
	public void removefromlist(Subject bk) {
		targets.remove(bk.getname());
		boolob.remove(bk.getname());
	}
	
}
