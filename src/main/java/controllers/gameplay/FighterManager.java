package controllers.gameplay;

import controllers.GamePlay;
import components.fighters.GameComponent;

/**
 * Thread that manage fighters actions (movement and shouting)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class FighterManager implements Runnable{

    private static FighterManager instance;
    private GamePlay gamePlay;

    private FighterManager(GamePlay gamePlay){
        this.gamePlay = gamePlay;
    }

    public static FighterManager getInstance(GamePlay gamePlay) {
        if(instance == null)
            instance = new FighterManager(gamePlay);
        return instance;
    }

    @Override
    public void run(){
        while(gamePlay.isRunning()){
            for(GameComponent fighter : gamePlay.getFighters()){
                fighter.move();
                fighter.shoot();
            }
            try {
                Thread.sleep(GamePlay.FRAMERATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}