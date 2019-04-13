package encryptionproject;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ckopp
 */
public class Popup {

    /**
     * Takes in a Message as a String and displays it to the user as a
     * JOptionPane which also contains an empty textbox. Whatever the user
     * inputs into the pane is returned as a String to the caller
     *
     * @param message
     * @return Response from user interaction with dialogue box
     */
    public static String promptMessage(String message) {
        return JOptionPane.showInputDialog(message);
    }

    /**
     * Takes in a Message as a string and displays it to the user with an
     * initial value in the textbox of Initial. Whatever is in the textbox at
     * the time of user confirmation is returned as String to the caller,
     * whether it be the initial value or a user defined value
     *
     * @param message
     * @param initial
     * @return Response from user interaction with dialogue box
     */
    public static String promptMessageInitial(String message, String initial) {
        return JOptionPane.showInputDialog(message, initial);
    }

    /**
     * Takes in a Message as a string and displays it to the user with no
     * textbox.
     *
     * @param message
     */
    public static void popupMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
