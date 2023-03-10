import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class performs MD5 hashing on a message.
 */
public class MD5HASH {
    private String message;
    private String digest;

    /**
     * Constructor that sets the message to the value passed in as a parameter.
     *
     * @param message the message to hash
     */
    public MD5HASH(String message) {
        this.message = message;
    }

    /**
     * Performs MD5 hashing on the message stored in the instance variable.
     *
     * @throws NoSuchAlgorithmException if the MD5 algorithm is not available
     */
    public void hash() throws NoSuchAlgorithmException {
        // Get an instance of the MD5 algorithm
        MessageDigest md = MessageDigest.getInstance("MD5");
        
        // Update the message to be hashed
        md.update(message.getBytes());

        // Get the hashed bytes
        byte[] bytes = md.digest();

        // Convert the hashed bytes to a string representation
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        // Set the digest to the hashed string
        digest = sb.toString();
    }

    /**
     * Returns the hashed message.
     *
     * @return the hashed message
     */
    public String getDigest() {
        return digest;
    }
}
