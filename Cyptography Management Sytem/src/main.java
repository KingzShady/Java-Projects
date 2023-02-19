import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class main {
    
    // Define instance variables for the message and digest
    private String message; // User's input message to be hashed
    private String digest; // Hashed message
    
    // Constructor
    public main() {
        // Initialize the instance variables
    }
    
    // Set the message to be hashed
    public void setMessage(String message) {
        // TODO: Set the message to the given message
    }
    
    // Get the hashed message
    public String getDigest() {
        // TODO: Return the hashed message
        return null;
    }
    
    // Hash the message using the MD5 algorithm
    public void hash() throws NoSuchAlgorithmException {
        // TODO: Hash the message using the MD5 algorithm
    }
    
    // Main method for testing
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Create a new UserInput instance
        main ui = new main();
        // Get user input for the message to be hashed
        // TODO: Get user input for the message to be hashed
        // Set the message to be hashed
        ui.setMessage("hello world");
        // Hash the message using MD5
        ui.hash();
        // Get the hashed message and print it
        String digest = ui.getDigest();
        System.out.println(digest);
    }
}
