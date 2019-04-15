/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionproject;

/**
 *
 * @author ckopp
 */
public abstract class EncryptionStandard {

    /**
     *
     * @param plaintext
     * @param key
     * @return encrypted Ciphertext
     */
    public abstract String encrypt(String plaintext, String key);

    /**
     *
     * @param ciphertext
     * @param key
     * @return decrypted Plaintext
     */
    public abstract String decrypt(String ciphertext, String key);

    /**
     *
     * @return the Encryption standard as an uppercase string literal
     */
    public abstract String asString();

    @Override
    public String toString() {
        return asString();
    }

}
