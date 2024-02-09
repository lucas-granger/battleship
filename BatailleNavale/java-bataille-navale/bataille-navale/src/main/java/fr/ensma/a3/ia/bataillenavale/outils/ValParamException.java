package fr.ensma.a3.ia.bataillenavale.outils;

public class ValParamException extends Exception {

    private String message;

    public ValParamException() {
        message = "";
    }

    public ValParamException(final String mess) {
        message = mess;
    }

    @Override
    public String getMessage() {
        return message + " --> " + super.getMessage();
    }

}
