package views;

import controllers.Controller;
import controllers.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Multi key press listener
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
class MultiKeyPressListener implements KeyListener {
    private final Set<Integer> pressedKeys = new HashSet<>();

    /**
     * Get pressed keys
     *
     * @return set of pressed keys
     */
    public Set<Integer> getPressedKeys() {
        return pressedKeys;
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }
}
