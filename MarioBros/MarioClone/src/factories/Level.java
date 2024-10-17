package factories;
import java.util.List;
import platforms.Platform;
import powerUps.PowerUp;
import enemies.*;
import character.Character;

public class Level {
    protected int remainingTime; 
    protected List<Platform> platformList;
    protected List<Enemy> enemyList;
    protected List<PowerUp> powerUpList;
    protected Character character;
    protected boolean running;
    protected boolean paused;

    public Level(List<Platform> platforms, List<Enemy> enemies, List<PowerUp> powerUps, Character character){
        this.remainingTime = 400;
        this.platformList = platforms;
        this.enemyList = enemies;
        this.powerUpList = powerUps;
        this.character = character;
        this.running = false;
        this.paused = true;
    }

    public void start(){
        running = true;
        paused = false;
    }
    public void end(){
        running = false;
    }

    public void pause(){
        paused = true;
    }
    public void resume(){
        paused = false;
    }

    public List<Platform> getPlatforms(){
        return platformList;
    }
    public List<Enemy> getEnemies(){
        return enemyList;
    }
    public List<PowerUp> getPowerUps(){
        return powerUpList;
    }

    public Character getCharacter(){
        return character;
    }
    public int getRemainingTime(){
        return remainingTime;
    }
    public boolean isRunning(){
        return running;
    }
    public boolean isPaused(){
        return paused;
    }
}