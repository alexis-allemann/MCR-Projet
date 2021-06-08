package views;

import controllers.Controller;
import controllers.MoveDirection;

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
    private Controller controller;

    /**
     * Instantiation of the multi key press listener
     *
     * @param controller to manipulate on keys pressed
     */
    public MultiKeyPressListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        if (!pressedKeys.isEmpty()) {
            for (Iterator<Integer> it = pressedKeys.iterator(); it.hasNext(); ) {
                switch (it.next()) {
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        controller.move(MoveDirection.LEFT);
                        break;

                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        controller.move(MoveDirection.RIGHT);
                        break;

                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_SPACE:
                        controller.shoot();
                        break;

                    case KeyEvent.VK_R:
                    case KeyEvent.VK_N:
                        controller.newGame();
                }
            }
        }
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
