package exception.position;

import exception.DomainException;

public class InvalidPositionException extends DomainException {

    public InvalidPositionException(String message) {
        super(message);
    }
}
