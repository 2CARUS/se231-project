/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionproject;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

/**
 *
 * @author ckopp
 */
public class EncryptionProject {

    /**
     * Is run at the beginning of the program. Though it is convention to do
     * application logic in the Main method for small programs, one can run into
     * issues with main being a Static method and attempting to utilize other
     * classes and other helper methods
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            new EncryptionProject().run();
        } catch (Exception ex) {
            Logger.getLogger(EncryptionProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This is the main application logic of the program
     */
    private void run() {

    }

}
