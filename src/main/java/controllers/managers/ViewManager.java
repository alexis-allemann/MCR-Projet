package controllers.managers;

import controllers.GamePlay;
import model.World;
import model.components.GameComponentWithHitBox;
import views.View;

import java.awt.Image;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Thread that manage the view
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ViewManager implements Runnable {
    private static ViewManager instance;
    private final View view;

    /**
     * Instantiation of the view manager
     *
     * @param view to manage
     */
    private ViewManager(View view) {
        this.view = view;
    }

    /**
     * Get instance of the view manager to implement singleton pattern
     *
     * @param view to manage
     * @return the instance of the view manager
     */
    public static ViewManager getInstance(View view) {
        if (instance == null)
            instance = new ViewManager(view);
        return instance;
    }

    @Override
    public void run() {
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Check if game is still running
                if (!GamePlay.getInstance().isRunning()) {
                    cancel();
                    timer.cancel();
                }

                // Get next image to paint
                Image nextImage = view.getBufferedImage();
                Graphics2D graphics = (Graphics2D) nextImage.getGraphics();

                // Add spacecraft image
                GameComponentWithHitBox spacecraft = World.getInstance().getSpacecraft();
                spacecraft.draw(graphics);

                // Add monsters images
                synchronized (World.getInstance().getMonsters()) {
                    for (GameComponentWithHitBox component : World.getInstance().getMonsters())
                        component.draw(graphics);
                }

                // Add bullets images
                synchronized (World.getInstance().getBullets()) {
                    for (GameComponentWithHitBox component : World.getInstance().getBullets())
                        component.draw(graphics);
                }

                view.paintImage(nextImage);
            }
        };
        timer.scheduleAtFixedRate(task, 0, GamePlay.FRAME_RATE);
    }
}
