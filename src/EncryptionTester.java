
public class EncryptionTester {
	
	public static void main(String[] args) throws Exception {

        System.out.println("Working Directory = " + System.getProperty("user.dir")); // Your directory to save you time! :)


        String encryptedFilePath = "C:\\Users\\ianth\\Desktop\\JavaHW\\FA23-CS203-Lab11-main\\FA23-CS203-Lab11-main\\src\\encrypted.txt";
        String decryptedFilePath = "C:\\Users\\ianth\\Desktop\\JavaHW\\FA23-CS203-Lab11-main\\FA23-CS203-Lab11-main\\src\\decrypted.txt";
        String inputFilePath = "C:\\Users\\ianth\\Desktop\\JavaHW\\FA23-CS203-Lab11-main\\FA23-CS203-Lab11-main\\src\\encryptMe.txt";
        String outputFilePath = "C:\\Users\\ianth\\Desktop\\JavaHW\\FA23-CS203-Lab11-main\\FA23-CS203-Lab11-main\\src\\newEncrypted.txt";
		
        int shift = 4; // Says how much you would like to shift

        Encrypter enc = new Encrypter(shift);

		enc.encrypt(inputFilePath, outputFilePath);
		enc.decrypt(encryptedFilePath, decryptedFilePath);

	}


}
