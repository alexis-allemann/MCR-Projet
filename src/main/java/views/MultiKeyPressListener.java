package views;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.Collection;
import java.util.HashSet;

/**
 * Multi key press listener
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
class MultiKeyPressListener implements KeyListener {
    private final Collection<Integer> PRESSED_KEYS = Collections.synchronizedCollection(new HashSet<Integer>());

    /**
     * Get pressed keys
     *
     * @return set of pressed keys
     */
    public Collection<Integer> getPressedKeys() {
        return PRESSED_KEYS;
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        PRESSED_KEYS.add(e.getKeyCode());
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        PRESSED_KEYS.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
