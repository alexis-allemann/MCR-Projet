package controllers.gameplay;

import model.World;
import model.components.GameComponent;
import controllers.GamePlay;
import model.components.GameComponentWithHitbox;
import model.components.fighters.Fighter;
import views.View;

import java.awt.*;
import java.util.List;

/**
 * Thread that manage the view
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ViewManager implements Runnable {
    private static ViewManager instance;
    private View view;

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

    /**
     * Get instance of the view manager to implement singleton pattern
     *
     * @return the instance of the view manager
     */
    public static ViewManager getInstance() {
        return instance;
    }

    @Override
    public void run() {
        while (GamePlay.getInstance().isRunning()) {
            Image nextImage = view.getBufferedImage();
            nextImage.getGraphics().setColor(Color.RED);
            Rectangle rec;

            GameComponentWithHitbox spacecraft = World.getInstance().getSpacecraft();
            rec = spacecraft.getHitBoxLocation();
            nextImage.getGraphics().fillRect(rec.x, rec.y, rec.width, rec.height);
            nextImage.getGraphics().drawImage(spacecraft.getImage(), spacecraft.getLocation().getIntX(), spacecraft.getLocation().getIntY(), null);

            for (GameComponentWithHitbox component : World.getInstance().getMonsters()) {
                nextImage.getGraphics().drawImage(component.getImage(), component.getLocation().getIntX(), component.getLocation().getIntY(), null);
                rec = component.getHitBoxLocation();
                nextImage.getGraphics().fillRect(rec.x, rec.y, rec.width, rec.height);
            }


            for (GameComponentWithHitbox component : World.getInstance().getBullets()) {
                nextImage.getGraphics().drawImage(component.getImage(), component.getLocation().getIntX(), component.getLocation().getIntY(), null);
                rec = component.getHitBoxLocation();

                nextImage.getGraphics().fillRect(rec.x, rec.y, rec.width, rec.height);
            }
            view.paintImage(nextImage);
            try {
                Thread.sleep(GamePlay.FRAMERATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
