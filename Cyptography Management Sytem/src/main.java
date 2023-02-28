import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * This is the main class that gets user input, performs MD5 hashing on the input,
 * and prints the hashed message to the console.
 */
public class main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a message to hash
        System.out.print("Enter a message to hash: ");

        // Get the user's input
        String message = scanner.nextLine();

        // Create a UserInput object with the user's message
        UserInput userInput = new UserInput(message);

        // Create an MD5Hash object and hash the user's message
        MD5HASH md5Hash = new MD5HASH(userInput.getMessage());
        md5Hash.hash();

        // Print the hashed message to the console
        System.out.println("The hashed message is: " + md5Hash.getDigest());

        // Create a TripleDES object and encrypt the user's message
        TripleDES tripleDES = new TripleDES(userInput.getMessage());
        byte[] encryptedMessage = tripleDES.encrypt(message);

        // Print the encrypted message to the console
        System.out.println("The encrypted message is: " + new String(encryptedMessage));

        // Decrypt the encrypted message
        byte[] decryptedMessage = tripleDES.decrypt();

        // Print the decrypted message to the console
        System.out.println("The decrypted message is: " + new String(decryptedMessage));
    }
}
