package fr.ensma.a3.ia.bataillenavale.outils;

public class IllegalArgumentException extends Exception{
    
    private String message;
    
    public IllegalArgumentException() {
        message = "";
    }
    
    public IllegalArgumentException(final String mess) {
        message = mess;
    }

    @Override
    public String getMessage() {
        return message + " --> " + super.getMessage();
    }
}
