/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionproject;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/**
 *
 * @author ckopp
 */
public class Facade {

    /**
     * Singleton pattern
     */
    private static Facade facade;

    public static Facade instance() {
        if (facade == null) {
            facade = new Facade();
        }
        return facade;
    }

    /**
     * List of supported encryption standards
     */
    private final LinkedList<EncryptionStandard> standards;

    private EncryptionStandard chosenStandard;

    /**
     * Singleton constructor
     */
    private Facade() {
        this.standards = new LinkedList();
        standards.add(new AES());
//        standards.add(new RSA());
//          add more standards here

    }

    /**
     * Retrieves a list of supported encryption standards by the program
     *
     * @return String of concatenated supported encryption standards
     */
    public String getStandards() {
        Iterator itr = this.standards.iterator();
        String standardsString = "";

        while (itr.hasNext()) {
            standardsString += String.format("%s;", itr.next().toString());
        }

        return standardsString;
    }

    /**
     * Currently, only AES is supported. So this will return true if the
     * inputted string selection.equals("AES"). However, it does do a full
     * linear search for the standard
     *
     * @param selection
     * @return whether a given selection of security standard is valid or not
     */
    public boolean validStandard(String selection) {
        boolean valid = false;
        Iterator itr = standards.iterator();

        while (itr.hasNext()) {
            String curSelection = itr.next().toString();
            if (selection.equals(curSelection)) {
                valid = true;
                break;
            }
        }

        return valid;
    }

    /**
     * Chooses the encryption standard; right now only AES supported
     *
     * @param selection
     */
    public void chooseStandard(String selection) {
        if (validStandard(selection)) {
            this.chosenStandard = new AES();
        }
    }

    /**
     * Takes in the plaintext and the password used to encrypt it. This then
     * calls upon the encryption method of the chosen encryption standard. It
     * takes the appropriate information, places it into a JSON, and returns it
     *
     * @param plaintext
     * @param password
     * @return a JSONObject with keys "success", "filename", and others
     * conditionally
     */
    public JSONObject startEncryption(String plaintext, String password) {
        JSONObject result = new JSONObject();
        String ciphertext = this.chosenStandard.encrypt(plaintext, password);

        // testing ciphertext
//        System.out.println(ciphertext);
        result.put("keyUsed", password);
        result.put("ciphertext", ciphertext);
        result.put("successfulEncryption", true);

        return result;
    }

    /**
     *
     * @param ciphertext
     * @param password
     * @return
     */
    public JSONObject startDecryption(String ciphertext, String password) {
        JSONObject result = new JSONObject();
        String plaintext = this.chosenStandard.decrypt(ciphertext, password);

        // testing ciphertext
//        System.out.println(ciphertext);
        result.put("keyUsed", password);
        result.put("plaintext", plaintext);
        result.put("successfulDecryption", true);

        return result;
    }

}
