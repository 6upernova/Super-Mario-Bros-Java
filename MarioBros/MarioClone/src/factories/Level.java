package factories;
import java.util.List;
import platforms.Platform;
import powerUps.PowerUp;
import projectile.Projectile;
import character.Character;
import enemies.Enemy;
import java.util.LinkedList;

public class Level {
    protected int remainingTime; 
    protected List<Platform> platforms;
    protected List<Enemy> enemies;
    protected List<PowerUp> powerUps;
    protected List<Projectile> projectiles;
    protected Character character;
    protected boolean running;
    protected boolean paused;

    public Level(List<Platform> platforms, List<Enemy> enemies, List<PowerUp> powerUps){
        this.remainingTime = 400;
        this.platforms = platforms;
        this.enemies = enemies;
        this.powerUps = powerUps;
        this.running = false;
        this.paused = true;
        this.projectiles = new LinkedList<>() ;
    }

    public void setCharacter(Character character){
        this.character = character;
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
        return platforms;
    }
    public List<Enemy> getEnemies(){
        return enemies;
    }
    public List<PowerUp> getPowerUps(){
        return powerUps;
    }
    public List<Projectile> getProjectiles(){
        return projectiles;
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

    public void delete() {
        platforms.removeAll(platforms);
        enemies.removeAll(enemies);
        powerUps.removeAll(powerUps);
        projectiles.removeAll(projectiles);
    }

    public void addFireBall(Projectile projectile) {
        projectiles.add(projectile);        
    }
}