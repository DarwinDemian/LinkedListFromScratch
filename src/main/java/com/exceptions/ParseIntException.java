package java.com.exceptions;

public class ParseIntException extends Exception {
    public ParseIntException(Object value) {
        super(String.format(
                "Can't convert Integer value '%s' to Integer. Please pass an actual Integer value as a String such as 'intValueAsString' ",
                value.toString()));
    }
}
