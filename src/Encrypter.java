import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Encrypter {
    private int shift;
    private String encrypted;
    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }
    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }
    /**
     * Encrypts the content of a file and writes the result to another file.
     *
     * @param inputFilePath      the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
        String content = readFile(inputFilePath);
        encrypted = "";
        for (char ch : content.toCharArray()){
            encrypted += encryptCharacter(ch, shift);
        }
        writeFile(encrypted, encryptedFilePath);
        //Call the read method, encrypt the file contents, and then write to new file
    }
    /**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param messageFilePath    the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
        String encryptedContent = readFile(messageFilePath);
        String decrypted = "";
        for (char ch : encryptedContent.toCharArray()){
            decrypted += encryptCharacter(ch, -shift);
        }
        writeFile(decrypted, decryptedFilePath);
        //Call the read method, decrypt the file contents, and then write to new file
    }
    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
        StringBuilder message = new StringBuilder();
        File file  = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            message.append(scanner.nextLine());
            if (scanner.hasNextLine()){
                message.append("\n");
            }
        }
        scanner.close();
        return message.toString();
    }
    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     */
    private static void writeFile(String data, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(data);
        writer.close();
    }
    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    private char encryptCharacter(char character, int shift){
        if (Character.isLetter(character)){
            char base = Character.isLowerCase(character) ? 'a' : 'A';
            int offset = Character.toLowerCase(character) - base + shift;
            int modOffset = Math.floorMod(offset, 26); // returns a not negative//the lowest modulus of the offset and alphabet
            return (char) (base + modOffset);
        }
        else {
            return character;
        }
    }
    public String toString() {
        return encrypted;
    }
}
