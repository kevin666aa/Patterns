package hw1;

public class BadOperationException extends Exception{
	private String errorString;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadOperationException(String message) {
		setErrorString("hw1.BadOperationException: " + message);
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

}
