package factories;

import java.util.List;

import platforms.Platform;

public class Level {
    //To do: Add power-up and enemies list
    protected int remainingTime; 
    protected List<Platform> platformList; 
    protected boolean running;
    protected boolean paused;

    public Level(List<Platform> platforms){
        remainingTime = 400;
        platformList = platforms;
        running = false;
        paused = true;
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
