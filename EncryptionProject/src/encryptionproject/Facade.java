/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionproject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ckopp
 */
class Facade {

    private static Facade encryptions;

    public static Facade instance() {
        if (encryptions == null) {
            encryptions = new Facade();
        }
        return encryptions;
    }

    private final List standards;

    private Facade() {
        this.standards = new LinkedList();
        standards.add("AES");
//        standards.add("RSA");
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
     * inputted string selection.equals("AES")
     *
     * @param selection
     * @return whether a given selection of security standard is valid or not
     */
    boolean validSelection(String selection) {
        return "AES".equals(selection);
    }

}
