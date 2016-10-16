package wordcounter.exception;

/**
 * Created by Sergiy on 16.10.2016.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
