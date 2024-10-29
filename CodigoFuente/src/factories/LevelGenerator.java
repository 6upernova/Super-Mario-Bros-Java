package factories;
import java.util.LinkedList;
import java.util.List;

import entities.character.Character;
import entities.enemies.Enemy;
import entities.platforms.Platform;
import entities.platforms.Question;
import entities.powerUps.PowerUp;
import entities.projectile.Projectile;
import game.Level;

public class LevelGenerator {
    protected EntityFactory entityFactory;
    protected Parser parser;
    protected int levelNumber;

    public LevelGenerator(String mode) {
        this.entityFactory= new EntityFactory(mode);
        this.levelNumber = 1;
        this.parser= new Parser();
    }

    public Level createLevel(int number){
        this.levelNumber = number;
        parser.setLevel(this.levelNumber);
        int type=0;
        int worldX=0;
        int worldY=0;
        List<Platform> platformList = new LinkedList<Platform>();
        List<PowerUp> powerUpList = new LinkedList<PowerUp>();
        List<Enemy> enemyList = new LinkedList<Enemy>();
        while(parser.hasToRead()) {
            type= parser.getType();
            worldX = parser.getPositionX();
            worldY = parser.getPositionY();
            if( type>1 && type<9 ) {
            	Enemy enemy= entityFactory.newEnemy(type, worldX, worldY);
                enemyList.add(enemy);
            }
            else if( type>9 && type<15) { 
            	        PowerUp powerUp= entityFactory.newPowerUp(type, worldX, worldY);
                        powerUpList.add(powerUp);
                        Question questionBlock = (Question) entityFactory.newPlatform(22, worldX, worldY - 1);
                        questionBlock.setPowerUp(powerUp);
                        platformList.add(questionBlock);
                    }
            else if( type>19 && type<=30) { 
            	Platform platform= entityFactory.newPlatform(type, worldX, worldY);
                platformList.add(platform);
            }            
        }        
        return new Level(platformList, enemyList, powerUpList);
    }

    public Character createCharacter(){
        return entityFactory.createCharacter();
    }

    public Level getNextLevel() {
        this.levelNumber = levelNumber + 1;
        Level level = null;
        if(levelNumber < 4)
            level = createLevel(levelNumber);
        return level;
    }

    public Projectile createFireBall(int x, int y, String direction) {
        return entityFactory.newFireBall(31,x, y, direction);

    }
}