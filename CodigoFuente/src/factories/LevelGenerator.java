package factories;
import java.util.LinkedList;
import java.util.List;

import entities.character.Character;
import entities.enemies.Enemy;
import entities.enemies.Lakitu;
import entities.platforms.Platform;
import entities.platforms.Question;
import entities.powerUps.PowerUp;
import entities.projectile.Projectile;
import game.Level;
import views.ViewConstants;

public class LevelGenerator {
    protected EntityFactory entityFactory;
    protected Parser parser;
    protected int levelNumber;

    public LevelGenerator(String mode) {
        this.entityFactory= new EntityFactory(mode);
        this.parser= new Parser();
    }

    public Level createLevel(int number){
        this.levelNumber = number;
        parser.setLevel(levelNumber);
        int type=0;
        int worldX=0;
        int worldY=0;
        Character character = entityFactory.createCharacter();
        List<Platform> platformList = new LinkedList<Platform>();
        List<PowerUp> powerUpList = new LinkedList<PowerUp>();
        List<Enemy> enemyList = new LinkedList<Enemy>();
        while(parser.hasToRead()) {
            type= parser.getType();
            worldX = parser.getPositionX();
            worldY = parser.getPositionY();
            if( type>1 && type<9 ) {
            	Enemy enemy= entityFactory.newEnemy(type, worldX, worldY);
                if(type == 5){
                    Lakitu lakitu = (Lakitu) enemy;
                    lakitu.setCharacterReference(character);
                }

                enemyList.add(enemy);
            }
            if( type>9 && type<15) { 
                Question questionBlock = entityFactory.newPowerUpWithQuestionBlock(type, worldX, worldY);
                powerUpList.add(questionBlock.getPowerUp());
                platformList.add(questionBlock);
            }
            if(type == 15) {
            	PowerUp powerUp= entityFactory.newOnlyCoin(worldX, worldY);
            	powerUpList.add(powerUp);
            } 
            if( type>19 && type<=30) { 
               Platform platform= entityFactory.newPlatform(type, worldX, worldY);
               platformList.add(platform);
            }            
        } 
        Level levelGenerated = new Level(platformList, enemyList, powerUpList);
        levelGenerated.setCharacter(character);
        return levelGenerated;
    }

    public Character createCharacter(){
        return entityFactory.createCharacter();
    }

    public Level getNextLevel() {
        this.levelNumber = levelNumber + 1;
        Level level = null;
        if(levelNumber <= ViewConstants.MAX_LEVELS)
            level = createLevel(levelNumber);
        return level;
    }

    public Projectile createFireBall(int x, int y, String direction) {
        return entityFactory.newFireBall(31,x, y, direction);

    }

    public boolean haveNextLevel(){
        return levelNumber+1 <= ViewConstants.MAX_LEVELS;
    }
}