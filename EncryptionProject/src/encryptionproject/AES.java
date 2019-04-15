/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionproject;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ckopp
 */
public class AES extends EncryptionStandard {

    /**
     * Takes in an inputString to be encoded with AES along with a user defined
     * password. This password is run through SHA-256 hashing to produce the
     * actual key with which the input string is encrypted with
     *
     * @param plainText
     * @param password
     * @return Encrypted plaintext using the given password and AES encryption
     */
    @Override
    public String encrypt(String plainText, String password) {
        String encryptValue = "";
        try {
            SecretKeySpec key = generatekey(password);
            Cipher cipher = Cipher.getInstance(this.asString());
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = cipher.doFinal(plainText.getBytes());

            encryptValue = Base64.getEncoder().encodeToString(encVal);

        } catch (Exception ex) {
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encryptValue;
    }

    /**
     * Takes in a ciphertext and a password. The password is changed into its
     * SHA-256 hashkey equivalent and is used to decode the ciphertext. This
     * string is then returned
     *
     * @param cipherText
     * @param password
     * @return decrypted cipherText into plaintext
     */
    @Override
    public String decrypt(String cipherText, String password) {
        String decryptValue = "";
        try {

            SecretKeySpec key = generatekey(password);
            Cipher cipher = Cipher.getInstance(this.asString());
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodevalue = Base64.getDecoder().decode(cipherText);
            byte[] decVal = cipher.doFinal(decodevalue);
            decryptValue = new String(decVal);

        } catch (Exception ex) {
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decryptValue;
    }

    /**
     * Takes in a string password specified by the user and generates a SHA-256
     * hash that will be then be returned at the AES symmetric key
     *
     * @param password
     * @return SecretKey
     * @throws Exception
     */
    private SecretKeySpec generatekey(String password) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = password.getBytes("UTF-8");
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, this.asString());
        return secretKeySpec;
    }

    /**
     * Returns itself as an all caps string literal representing the standard
     * code to represent this encryption standard
     *
     * @return AES
     */
    @Override
    public String asString() {
        return "AES";
    }
}
