package lotfigrira.location.exceptions;

import ch.qos.logback.core.spi.ErrorCodes;
import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {
    @Getter
    private ErrorCodes errorCode;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
