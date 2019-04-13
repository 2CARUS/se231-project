/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionproject;

import javax.swing.JOptionPane;

/**
 *
 * @author ckopp
 */
public class EncryptionProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new EncryptionProject().run();
    }

    private void run() {

    }

    String input(String message) {
        return JOptionPane.showInputDialog(message);
    }

    String inputDefault(String message, String initial) {
        return JOptionPane.showInputDialog(message, initial);
    }

    void popup(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}
