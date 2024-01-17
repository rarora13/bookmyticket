package in.simplygeek.show.exceptions;


public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 6188112248401297705L;

	public CustomException(String message) {
        super(message);
    }
}
