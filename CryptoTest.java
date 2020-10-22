/* Naeem Dhuka, guh189, cryptoTest
 * 
 * did not use any 
 *URLS = https://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html, https://docs.oracle.com/javase/7/docs/api/javax/crypto/KeyGenerator.html, https://docs.oracle.com/javase/8/docs/api/javax/crypto/SecretKey.html
 */

public class CryptoTest {

    public static void main(String[] args) throws Exception {
        // What's going on in the two lines below?
        // Explain with a comment.
        // I've not handled the error in which the args[] array is null.
        // So, if you don't call the program correctly at the command line, you'll get an error.
        // Try to handle this in some way.

        String inFile = args[0];//String infile is now equal to the first variable in array args the array begin the imputed text file in cmd
        String outFile = args[1];//String outfile is now equal to the second variable in array args the array begin the imputed text file in cmd

        CryptoEngine cryptoEngine = new CryptoEngine(inFile, outFile);//created a object with infile and outfile as its variables this also initiates the constructor in the cryptoEngine class
        cryptoEngine.encrypt();//runs the encrypt method in the cryptoEngine class
        cryptoEngine.decrypt();//runs the decrypt method in the cryptoEngine class
    }
}
