package exception.trynumber;

import exception.DomainException;

public class InvalidTryNumberException extends DomainException {

    public InvalidTryNumberException(String message) {
        super(message);
    }
}
