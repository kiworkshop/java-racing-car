package exception.name;

import exception.DomainException;

public class InvalidNameException extends DomainException {

    public InvalidNameException(String message) {
        super(message);
    }

}
