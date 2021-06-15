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
    private final Collection<Integer> pressedKeys = Collections.synchronizedCollection(new HashSet<>());

    /**
     * Get pressed keys
     *
     * @return set of pressed keys
     */
    public Collection<Integer> getPressedKeys() {
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
