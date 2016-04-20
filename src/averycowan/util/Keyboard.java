package averycowan.util;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * The class does two things. First, it dispatches events to KeyListeners from
 * any focus. Second, it maintains an array of currently held keys. It is
 * recommended that init() is called as soon at the frame exists.
 *
 * @author avecowa
 */
public class Keyboard implements KeyEventDispatcher {
    private final Keyboard instance = new Keyboard();
    private static boolean[] down = new boolean[26];
    /**
     * Call this as soon as the Frame is initializes.
     */
    public static void init() {//causeClassLoading();
    }
    private Keyboard() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
    }
    private static ArrayList<KeyListener> listeners = new ArrayList<KeyListener>();
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        switch (e.getID()) {
            case KeyEvent.KEY_PRESSED:
                char c = e.getKeyChar();
                if (c >= 'a' && c <= 'z') {
                    Keyboard.down[c - 'a'] = true;
                }
                for (KeyListener k : listeners) {
                    k.keyPressed(e);
                }
                break;
            case KeyEvent.KEY_RELEASED:
                c = e.getKeyChar();
                if (c >= 'a' && c <= 'z') {
                    Keyboard.down[c - 'a'] = false;
                }
                for (KeyListener k : listeners) {
                    k.keyReleased(e);
                }
                break;
            case KeyEvent.KEY_TYPED:
                for (KeyListener k : listeners) {
                    k.keyTyped(e);
                }
                break;
        }
        return false;
    }
    /**
     * Adds a Custom KeyListener to dispatch events to.
     *
     * @see getListeners()
     */
    public void addListener(KeyListener k) {
        listeners.add(k);
    }
    /**
     * Retrieve the list of KeyListeners events are dispatched to.
     *
     * @return this is not a clone. Be careful.
     */
    public ArrayList<KeyListener> getListeners() {
        return listeners;
    }
    /**
     * Checks if a key is being held down.
     *
     * @throws IllegalArgumentException if key is not between 'a' and 'z'.
     */
    public static boolean isDown(char key) {
        if (key < 'a' || key > 'z') {
            throw new IllegalArgumentException("'" + key + "' must be between 'a' and 'z'.");
        }
        return down[key - 'a'];
    }
}
