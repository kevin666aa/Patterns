package hw1;

import hw1.LibraryBook;
//shelf(), issue(), extend(), and returnIt()
public interface LBState {
	public void s_shelf(LibraryBook lb) throws BadOperationException;
	public void s_issue(LibraryBook lb) throws BadOperationException;	
	public void s_extend(LibraryBook lb) throws BadOperationException;
	public void s_returnIt(LibraryBook lb) throws BadOperationException;
}
