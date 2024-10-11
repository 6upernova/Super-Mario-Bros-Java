package factories;

import game.Entity;

public class Level {
    protected int time; 
    protected Entity map[][]; 
    protected boolean running;
    protected String background;

    public Level(){
        
    }
    public void setMap(){}
    public void start(){}
    public void pause(){}
    public void end(){}
    public void resume(){}
    public void addEntity(Entity entity){
        map[x][y] = entity;
    }
    public void setBackGround(int number){

    }

}
