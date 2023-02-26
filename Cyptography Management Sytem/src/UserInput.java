/**
 * This class represents user input and stores a message that the user provides.
 */
public class UserInput {
    private String message;

    /**
     * Constructor that sets the message to the value passed in as a parameter.
     *
     * @param message the message to store
     */
    public UserInput(String message) {
        this.message = message;
    }

    /**
     * Returns the message that the user provided.
     *
     * @return the user's message
     */
    public String getMessage() {
        return message;
    }
}
