package org.miniproject.Exception;

public class InsufficientStockException extends Exception {
    public InsufficientStockException() {
       
    }
    public String getMessage() {
        return "Insufficient stock for the selected fertilizer. Please enter a valid quantity.\n";
    }
}
