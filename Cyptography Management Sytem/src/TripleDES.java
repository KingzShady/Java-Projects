import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/**
 * This class is responsible for encrypting and decrypting a message using the Triple DES algorithm.
 */

public class TripleDES {
    // Created variable that hold message taking in from user, after it has been encrypted and after it has been decrypted
    private String message;
    private byte[] encryptedMessage;
    private byte[] decryptedMessage;

    /**
     * Constructor that sets the message to the value passed in as a parameter.
     *
     * @param message the message to encrypted
     */
    public TripleDES(String message) {
        this.message = message;
    }

    /**
     * Performs TripleDES encryption on the message stored in the instance variable.
     *
     * @throws NoSuchAlgorithmException if the TripleDES algorithm is not available
     */
    public byte[] encrypt(String message) throws NoSuchAlgorithmException, Exception {
        // TODO: Implement encryption using Triple DES algorithm

        // Create a SecretKey object using the Triple DES algorithm
        SecretKey key = KeyGenerator.getInstance("DeSede").generateKey();

        // Initialize a Cipher object with the Triple DES algorithm in ECB mode
        Cipher cipher = Cipher.getInstance("DeSede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Encrypt the message using the initialized Cipher object
        byte[] messageBytes = message.getBytes("UTF-8");
        encryptedMessage = cipher.doFinal(messageBytes);

        return encryptedMessage;
    }

    /**
     * Performs TripleDES decryption on the encrypted message stored in the instance variable.
     */
    public byte[] decrypt() {
        // TODO: Implement decryption using Triple DES algorithm
        return decryptedMessage;
    }

}
