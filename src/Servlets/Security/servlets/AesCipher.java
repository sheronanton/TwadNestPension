package Servlets.Security.servlets;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AesCipher {
    private static final String algorithm = "AES/CBC/NoPadding";

    private static final byte[] keyValue = new byte[] {
        0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
        0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F
    };

    private static final byte[] ivValue = new byte[] {
        0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
        0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F
    };

    private static final IvParameterSpec ivspec = new IvParameterSpec(ivValue);
    private static final SecretKeySpec keyspec = new SecretKeySpec(keyValue, "AES");

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public String encrypt(String data) throws Exception {
        Cipher c = Cipher.getInstance(algorithm);
        c.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
        byte[] encVal = c.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    public String decrypt(String encryptedData) {
        String decryptedValue = "";
        try {
            Cipher c = Cipher.getInstance(algorithm);
            c.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] decodedValue = Base64.getDecoder().decode(encryptedData);
            byte[] decValue = c.doFinal(decodedValue);
            decryptedValue = new String(decValue);
        } catch (Exception e) {
            decryptedValue = "F";
            e.printStackTrace();
        }
        System.out.println("decryptedValue " + decryptedValue);
        return decryptedValue;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static String padString(String source) {
        char paddingChar = ' ';
        int size = 16;
        int x = source.length() % size;
        int padLength = size - x;

        for (int i = 0; i < padLength; i++) {
            source += paddingChar;
        }
        return source;
    }

    public static void main(String[] args) throws Exception {
        String password = "soldier";
        AesCipher aes = new AesCipher();

        String passwordEnc = aes.encrypt(padString(password));
        String passwordDec = aes.decrypt(passwordEnc);

        System.out.println("Plain Text : " + password);
        System.out.println("Encrypted Text : " + passwordEnc);
        System.out.println("Decrypted Text : " + passwordDec);
    }
}