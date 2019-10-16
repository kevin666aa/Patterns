package hw1;

import java.util.ArrayList;

import hw1.LBState;
import hw1.Subject;

public class LibraryBook implements Subject{
	private LBState s_state;
	private String bookname; 
	
	public LibraryBook(String string) {
		setBookname(string);
		observers = new ArrayList<Observer>();
		s_state = OnShelf.getInst();
	}
	
	@Override
	public String toString() {
		return bookname;
	}
	
	public void shelf() {
		boolean exp = true;
		try {
			s_state.s_shelf(this);
		} catch (BadOperationException e) {
			myprint.mylogclass(e.getErrorString());
			exp = false;
		}
		
		if (exp) {
			Notify();
		}
	}
	
	public void issue() {
		boolean exp = true;
		try {
			s_state.s_issue(this);
		} catch (BadOperationException e) {
			myprint.mylogclass(e.getErrorString());
			exp = false;
		} 
		
		if (exp) {
			Notify();
		}
	}
	public void extend() {
		boolean exp = true;
		try {
			s_state.s_extend(this);
		} catch (BadOperationException e) {
			myprint.mylogclass(e.getErrorString());
			exp = false;
		}
		
		if (exp) {
			Notify();
		}
	}
	public void returnIt() {
		boolean exp = true;
		try {
			s_state.s_returnIt(this);
		} catch (BadOperationException e) {
			myprint.mylogclass(e.getErrorString());
			exp = false;
		}
		
		if (exp) {
			Notify();
		}
	}
	
	public void changestate(LBState newstate) {
		s_state = newstate;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	
	
	private ArrayList<Observer> observers;
	@Override
	public void detach(Observer ob) {
		for (int i = 0; i < observers.size(); i++) {
			if (ob.getName() == observers.get(i).getName()) {
				myprint.mylogclass(ob.getName() + " is no longer watching " + this.bookname);
				ob.removefromlist(this);
				observers.remove(ob);
			}
		}
		
	}


	@Override
	public void attach(Observer ob) {
		ob.addtolist(this);
		observers.add(ob);
		myprint.mylogclass(ob.getName() + " is now watching " + this.bookname);
	}
	

	@Override
	public void Notify() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update(this);
		}
	}

	@Override
	public String getState() {
		return s_state.toString();
	}
	@Override
	public String getname() {
		return bookname;
	}
}
