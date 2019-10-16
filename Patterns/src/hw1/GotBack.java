package hw1;

import hw1.LBState;
import hw1.BadOperationException;
import hw1.LibraryBook;

public class GotBack implements LBState{
	private static GotBack s_gotBack = null;
	
	private GotBack() {
		myprint.mylogclass("GotBack Instance Created");
	}

	public static GotBack getInst() {
		if (s_gotBack == null) {
			s_gotBack = new GotBack();
		} 
		return s_gotBack;
	}
	
	@Override
	public String toString() {
		return "GotBack";
	}
	
	@Override
	public void s_shelf(LibraryBook lb) {
		lb.changestate(OnShelf.getInst());
		myprint.mylogclass("Leaving State GotBack for State OnShelf");
	}

	@Override
	public void s_issue(LibraryBook lb) throws BadOperationException{
		throw new BadOperationException("Can't use issue in GotBack state");
	}

	@Override
	public void s_extend(LibraryBook lb) throws BadOperationException {
		throw new BadOperationException("Can't use extend in GotBack state");
	}

	@Override
	public void s_returnIt(LibraryBook lb) throws BadOperationException {
		throw new BadOperationException("Can't use returnIt in GotBack state");		
	}

}
