package managers;

import controllers.GameController;
import model.World;
import model.components.GameComponentWithHitBox;
import model.components.IGameComponentWithHitBox;
import views.IView;

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
    private final IView view;

    /**
     * Instantiation of the view manager
     *
     * @param view to manage
     */
    private ViewManager(IView view) {
        this.view = view;
    }

    /**
     * Get instance of the view manager to implement singleton pattern
     *
     * @param IView to manage
     * @return the instance of the view manager
     */
    public static ViewManager getInstance(IView IView) {
        if (instance == null)
            instance = new ViewManager(IView);
        return instance;
    }

    @Override
    public void run() {
        final World world = World.getInstance();
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Check if game is still running
                if (world.isRunning()) {

                    // Get next image to paint
                    Image nextImage = view.getBufferedImage();
                    Graphics2D graphics = (Graphics2D) nextImage.getGraphics();

                    // Add spacecraft image
                    IGameComponentWithHitBox spacecraft = World.getInstance().getSpacecraft();
                    spacecraft.draw(graphics);

                    // Add monsters images
                    synchronized (World.getInstance().getMonsters()) {
                        for (IGameComponentWithHitBox component : World.getInstance().getMonsters())
                            component.draw(graphics);
                    }

                    // Add bullets images
                    synchronized (World.getInstance().getBullets()) {
                        for (GameComponentWithHitBox component : World.getInstance().getBullets())
                            component.draw(graphics);
                    }

                    view.paintImage(nextImage);
                }
                else{
                    view.displayGameOverMessage();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, GameController.FRAME_RATE);
    }
}
