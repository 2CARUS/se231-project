/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionproject.UIpackage;

/**
 *
 * @author ckopp
 */
public abstract class UIFrame extends javax.swing.JFrame {

    /**
     * Calls on JFrame.dispose() to make the frame disappear
     */
    void coneal() {
        this.dispose();
    }

    /**
     * Calls on JFrame.setVisible(true) to make the frame appear
     */
    void render() {
        this.setVisible(true);
    }

}
