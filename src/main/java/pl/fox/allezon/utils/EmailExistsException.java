package pl.fox.allezon.utils;

public class EmailExistsException extends Exception {

    public EmailExistsException(String errorMessage) {
        super(errorMessage);
    }

}