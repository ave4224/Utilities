/*
 * Copyright 2016 Avery Cowan.
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
