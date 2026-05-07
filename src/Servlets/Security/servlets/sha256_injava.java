package Servlets.Security.servlets;

import java.security.MessageDigest;

import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

 

/**

 * Demonstrates how to generate SHA256 hash in Java

 * @author JJ

 */

public class sha256_injava {

 

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        System.out.print("Please enter data for which SHA256 is required:");

        String data = sn.nextLine();

         

        sha256_injava sj = new sha256_injava();

        String hash = sj.getSHA256Hash(data);

        System.out.println("The SHA256 (hexadecimal encoded) hash is:"+hash);

    }

 

    /**

     * Returns a hexadecimal encoded SHA-256 hash for the input String.

     * @param data

     * @return

     */

    public String getSHA256Hash(String data) {

        String result = null;

        try {
             System.out.println("inside");
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            System.out.println(bytesToHex(hash));
            return bytesToHex(hash); // make it printable

        }catch(Exception ex) {

            ex.printStackTrace();
        }

        return result;

    }

     

    /**

     * Use javax.xml.bind.DatatypeConverter class in JDK to convert byte array

     * to a hexadecimal string. Note that this generates hexadecimal in upper case.

     * @param hash

     * @return

     */

    private String  bytesToHex(byte[] hash) {

        return DatatypeConverter.printHexBinary(hash);

    }

}