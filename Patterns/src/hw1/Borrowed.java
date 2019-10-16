package hw1;

import hw1.LBState;
import hw1.BadOperationException;
import hw1.LibraryBook;

public class Borrowed implements LBState{
	private static Borrowed s_borrowed = null;
	
	private Borrowed() {
		myprint.mylogclass("Borrowed Instance Created");
	}
	
	public static Borrowed getInst() {
		if (s_borrowed == null) {
			s_borrowed = new Borrowed();
		} 
		
		return s_borrowed;
	}
	
	@Override
	public String toString() {
		return "Borrowed";
	}
	
	@Override
	public void s_shelf(LibraryBook lb) throws BadOperationException {
		throw new BadOperationException("Can't use shelf in Borrowed state");
	}

	@Override
	public void s_issue(LibraryBook lb) throws BadOperationException{
		throw new BadOperationException("Can't use issue in Borrowed state");
	}

	@Override
	public void s_extend(LibraryBook lb) {
		lb.changestate(Borrowed.getInst());
		myprint.mylogclass("Leaving State Borrowed for State Borrowed");

	}

	@Override
	public void s_returnIt(LibraryBook lb) throws BadOperationException{
		lb.changestate(GotBack.getInst());
		myprint.mylogclass("Leaving State Borrowed for State GotBack");
	}
	
}
