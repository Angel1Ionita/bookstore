package angel1ionita.bookstore.exception;

import java.time.Instant;

public record ErrorResponse(Integer status, Instant timestamp, String message) {
    public ErrorResponse(Integer status, String message) {
        this(status, Instant.now(), message);
    }
}
