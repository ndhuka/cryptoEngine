//this import brings everything in form the util library
import java.util.*;
//this import allows me to access files no the computer
import java.nio.file.Files;
//this import allows me to navigate and find the paths on the computer
import java.nio.file.Paths;
//allows me to use cryptographic operations
import javax.crypto.*;
//allows for us to throw file not found exceptions
import java.io.FileNotFoundException;
//allows for us to throw io exceptions
import java.io.IOException;
//allows for us to throw invalid key exceptions
import java.security.InvalidKeyException;
//allows for us to throw no such algorithm exception
import java.security.NoSuchAlgorithmException;

class CryptoEngine {
    // What is the function of these four variables?
    // Comment above each one with your answer.
    //creates object keygen this can be later initiated to create a key for the encryption
    KeyGenerator keyGen;
    //create String encfile and defile which will be used to hold the value of the string in file and out files form the main
    String encFile, decFile;
    //creates a object secretkey
    SecretKey secKey;
    //this is an object that will hold the cipher that will be used to create the encryption.
    Cipher aesCipher;

    CryptoEngine(String inFile, String outFile) throws NoSuchAlgorithmException, NoSuchPaddingException {
        encFile = inFile;
        decFile = outFile;

        keyGen = KeyGenerator.getInstance("AES");// this indicates that we will be using 128 bits and returns a new object
        keyGen.init(128);//utilizing the init method in the keygenerator class to set a size of 128 bits
        secKey = keyGen.generateKey();//returns a new key
        aesCipher = Cipher.getInstance("AES");
    }

    public void encrypt() throws InvalidKeyException, IOException {
        byte[] byteText = "This Message will now be Encrypted".getBytes();

        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);

        byte[] byteCipherText = null;

        try {
            byteCipherText = aesCipher.doFinal(byteText);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        Files.write(Paths.get(encFile), byteCipherText);
    }

    // You will decrypt the encrypted file using the same general principles
    // For each line that you supply, leave a detailed comment of what that line is doing, including the functionality of the methods and variables
    public void decrypt() throws IOException, InvalidKeyException {
        // assign "Files.readAllBytes(Paths.get(encFile))" to the cipherText array (fill in the blank)

        byte[] cipherText = Files.readAllBytes(Paths.get(encFile));

        // call aesCipher.init as in the encrypt method, but this time, you will use DECRYPT_MODE!
        aesCipher.init(Cipher.DECRYPT_MODE, secKey);

        // declare and initialize a byte array just like in the encrypt method, but this time, call it bytePlainText
        byte[] bytePlainText = null;

        // I have commented out this try-catch block to make your code compilable, but you'll need to decomment it after filling in the code
        try {
        // Decrypt the cipherText byte array with the same aesCipher.doFinal method as in encrypt method
        // But this time, the byte arrays will be reversed!
            bytePlainText = aesCipher.doFinal(cipherText);
        }
        catch (IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

        // Write your output to a file, similar to the Files.write method in the encrypt method (but be careful to use the correct byteArray and file)
        Files.write(Paths.get(decFile), bytePlainText);
    }

}