package hw1;

import hw1.LBState;
import hw1.BadOperationException;
import hw1.LibraryBook;
import hw1.myprint;

public class OnShelf implements LBState{
	private static OnShelf s_onShelf = null;
	
	private OnShelf() {
		myprint.mylogclass("OnShelf Instance Created");
	}
	
	public static OnShelf getInst() {
		if (s_onShelf == null) {
			s_onShelf = new OnShelf();
		}
		
		return s_onShelf;
	}
	
	@Override
	public String toString() {
		return "OnShelf";
	}
	
	@Override
	public void s_shelf(LibraryBook lb) throws BadOperationException {
		throw new BadOperationException("Can't use shelf in OnShelf state");
	}

	@Override
	public void s_issue(LibraryBook lb) throws BadOperationException {
		lb.changestate(Borrowed.getInst());
		myprint.mylogclass("Leaving State OnShelf for State Borrowed");
	}

	@Override
	public void s_extend(LibraryBook lb) throws BadOperationException {
		throw new BadOperationException("Can't use extend in OnShelf state");	
	}

	@Override
	public void s_returnIt(LibraryBook lb) throws BadOperationException {
		throw new BadOperationException("Can't use returnIt in OnShelf state");
	}

}
