package angel1ionita.bookstore.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceType, Long id) {
        super("No " + resourceType + " found with id " + id);
    }
}
