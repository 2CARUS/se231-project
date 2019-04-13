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
public class UIController {

    private UIFrame mainUI;

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
    public void displayNextFrame(UIFrame previousFrame, UIFrame nextFrame) {
        previousFrame.dispose();
        nextFrame.render();
    }

    /**
     * Sets the mainUI attribute of the UIController class
     *
     * @param mainMenuUI
     */
    public void setMain(UIFrame mainMenuUI) {
        this.mainUI = mainMenuUI;
    }

    /**
     * Starts the UI at the mainUI frame
     */
    public void startUI() {
        this.mainUI.render();
    }

    private static class UIControllerHolder {

        private static final UIController INSTANCE = new UIController();
    }
}
