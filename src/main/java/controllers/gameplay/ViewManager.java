package controllers.gameplay;

import components.GameComponent;
import components.fighters.Fighter;
import components.physics.Location;
import controllers.GamePlay;
import controllers.Direction;
import views.View;

import java.util.ArrayList;
import java.util.List;

import java.awt.Image;

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
            List<GameComponent> components = getAllComponents();
            Image nextImage = view.getBufferedImage();
            for(GameComponent component : components){
                nextImage.getGraphics().drawImage(component.getImage(), component.getLocation().getIntX(), component.getLocation().getIntY(), null);
            }
            view.paintImage(nextImage);
            try {
                Thread.sleep(GamePlay.FRAMERATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get all components to paint
     *
     * @return all components that have to be painted
     */
    List<GameComponent> getAllComponents(){
        List<GameComponent> components = new ArrayList<>();
        components.addAll(FighterManager.getInstance().getMonsters());
        components.addAll(BulletManager.getInstance().getBullets());
        components.add(GamePlay.getInstance().getSpacecraft());
        return components;
    }
}
