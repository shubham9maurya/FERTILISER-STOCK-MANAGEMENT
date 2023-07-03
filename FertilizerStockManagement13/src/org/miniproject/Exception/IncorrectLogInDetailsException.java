package org.miniproject.Exception;

public class IncorrectLogInDetailsException extends Exception {
	public IncorrectLogInDetailsException() {
		
	}
    public String getMessage() {
        return "Invalid retailer id or password!!\n";
    }
}
