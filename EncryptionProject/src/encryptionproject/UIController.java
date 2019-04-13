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
public class UIController {

    private UIframe mainUI;

    private UIController() {
    }

    public static UIController getInstance() {
        return UIControllerHolder.INSTANCE;
    }

    /**
     * Takes in two AbstractFrames (which are jFrames) and disposes the first
     * one and renders the second one
     *
     * @param previousFrame
     * @param nextFrame
     */
    void displayNextFrame(UIframe previousFrame, UIframe nextFrame) {
        previousFrame.dispose();
        nextFrame.render();
    }

    /**
     * Sets the mainUI attribute of the UIController class
     *
     * @param mainMenuUI
     */
    void setMain(UIframe mainMenuUI) {
        this.mainUI = mainMenuUI;
    }

    /**
     * Starts the UI at the mainUI frame
     */
    void startUI() {
        this.mainUI.render();
    }

    private static class UIControllerHolder {

        private static final UIController INSTANCE = new UIController();
    }
}
