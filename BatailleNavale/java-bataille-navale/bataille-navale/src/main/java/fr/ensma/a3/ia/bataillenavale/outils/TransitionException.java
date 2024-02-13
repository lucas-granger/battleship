package fr.ensma.a3.ia.bataillenavale.outils;

public class TransitionException extends Exception {

    private String message;

    public TransitionException() {
        message = "";
    }

    public TransitionException(final String mess) {
        message = mess;
    }

    @Override
    public String getMessage() {
        return message + " --> " + super.getMessage();
    }

}
