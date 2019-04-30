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
     * Takes in an plaintext to be encoded with AES along with a user defined
     * password. This password is run through SHA-256 hashing to produce the
     * actual key with which the plaintext is encrypted with
     *
     * @param plainText
     * @param password
     * @return Encrypted plaintext using the given password and AES encryption
     */
    @Override
    public String encrypt(String plainText, String password) {
        String ciphertext = "";
        try {
            /**
             * this generates a SecretKeySpec from the given password
             */
            SecretKeySpec keyCreator = this.generatekey(password);
            /**
             * Gets instance of the Cipher class with in AES mode, where AES
             * comes from this.asString()
             */
            Cipher cipher = Cipher.getInstance(this.asString());
            /**
             * Initializes the cipher in ENCRYPT_MODE, with the keyCreator
             * passed to make keys
             */
            cipher.init(Cipher.ENCRYPT_MODE, keyCreator);
            /**
             * doFinal takes the bytes of the plaintext and finishes the
             * encryption and returns a byte array, which is the encrypted text
             */
            byte[] encVal = cipher.doFinal(plainText.getBytes());
            /**
             * Initializes the ciphertext to be the byte encoded to string
             * through the Base64 encoder
             */
            ciphertext = Base64.getEncoder().encodeToString(encVal);

        } catch (Exception ex) {
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * returns the ciphertext
         */
        return ciphertext;
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
        String plaintext = "";
        try {

            /**
             * Generates a SecretKeySpec, which is a key creator, through the
             * given password
             */
            SecretKeySpec keyCreator = this.generatekey(password);
            /**
             * Gets instance of cipher of "AES" from this.asString()
             */
            Cipher cipher = Cipher.getInstance(this.asString());
            /**
             * Initializes the cipher in DECRYPT_MODE passing the keyCreator to
             * create a key
             */
            cipher.init(Cipher.DECRYPT_MODE, keyCreator);
            /**
             * Decodes the ciphertext into a byte array
             */
            byte[] decodevalue = Base64.getDecoder().decode(cipherText);
            /**
             * Takes this byte array and decodes the ciphertext into a byte
             * array
             */
            byte[] decVal = cipher.doFinal(decodevalue);
            /**
             * turns the byte array into a string, which is the plaintext
             */
            plaintext = new String(decVal);

        } catch (Exception ex) {
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * returns the plaintext
         */
        return plaintext;
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
        /**
         * Gets an instance of MessageDigest with SHA-256 standard
         */
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        /**
         * creates a byte array of the given password in UTF-8 standard
         */
        byte[] passwordBytes = password.getBytes("UTF-8");
        /**
         * Digests password as bytes starting at index 0 going to
         * passwordBytes.length
         */
        digest.update(passwordBytes, 0, passwordBytes.length);
        /**
         * Executes the digest() method to return a byte array which is the key
         * to be used for encryption/decryption
         */
        byte[] key = digest.digest();
        /**
         * SecretKeySpec is something that can create a secret key safely. It is
         * passed this.asString() as well, which returns "AES" and is used in
         * the SecretKeySpec constructor
         */
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, this.asString());
        /**
         * This is then returned
         */
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
