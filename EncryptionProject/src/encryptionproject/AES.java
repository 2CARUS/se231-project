/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionproject;

import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ckopp
 */
public class AES {

    private final static String AES_STRING = "AES";

    /**
     * Takes in an inputString to be encoded with AES along with a user defined
     * password. This password is run through SHA-256 hashing to produce the
     * actual key with which the input string is encrypted with
     *
     * @param plainText
     * @param password
     * @return Encrypted inputString using the given password and AES encryption
     * @throws Exception
     */
    private String encrypt(String plainText, String password) throws Exception {
        SecretKeySpec key = generatekey(password);
        Cipher cipher = Cipher.getInstance(AES.AES_STRING);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = cipher.doFinal(plainText.getBytes());
        String encryptValue;
        encryptValue = Base64.getEncoder().encodeToString(encVal);
        return encryptValue;

    }

    /**
     * Takes in a ciphertext and a password. The password is changed into its
     * SHA-256 hashkey equivalent and is used to decode the ciphertext. This
     * string is then returned
     *
     * @param cipherText
     * @param password
     * @return
     * @throws Exception
     */
    private String decrypt(String cipherText, String password) throws Exception {
        SecretKeySpec key = generatekey(password);
        Cipher cipher = Cipher.getInstance(AES.AES_STRING);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodevalue = Base64.getDecoder().decode(cipherText);
        byte[] decVal = cipher.doFinal(decodevalue);
        String decryptValue = new String(decVal);
        return decryptValue;
    }

    /**
     * Takes in a string password specified by the user and generates a SHA-256
     * hash that will be then be returned at the AES symmetric key
     *
     * @param password
     * @return
     * @throws Exception
     */
    private SecretKeySpec generatekey(String password) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = password.getBytes("UTF-8");
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, AES.AES_STRING);
        return secretKeySpec;
    }
}
