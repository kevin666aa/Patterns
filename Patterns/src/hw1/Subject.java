package hw1;

import hw1.Observer;
public interface Subject {
	public void detach(Observer ob);
	public void attach(Observer ob);
	public void Notify();
	public String getState();
	public String getname();
}
