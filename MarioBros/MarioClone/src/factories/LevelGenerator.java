package factories;

import java.util.LinkedList;
import java.util.List;
import platforms.Platform;
import powerUps.PowerUp;
import enemies.Enemy;
import character.Character;

public class LevelGenerator {

    protected EntityFactory entityFactory;
    protected Parser parser;

    public LevelGenerator(String mode, int levelNumber) {
        entityFactory= new EntityFactory(mode);
        parser= new Parser(levelNumber);
    }

    public Level createLevel(){
        int type=0;
        int worldX=0;
        int worldY=0;
        List<Platform> platformList = new LinkedList<Platform>();
        List<Enemy> enemyList = new LinkedList<Enemy>();
        List<PowerUp> powerUpList = new LinkedList<PowerUp>();
        Character character = entityFactory.createCharacter();
        //LEE CADA LINEA DEL TXT Y LO PASA A UN A CREATE, DESPUES CON ESO LO AÑADE
        while(parser.hasToRead()) {
            type= parser.getType();
            worldX = parser.getPositionX();
            worldY = parser.getPositionY();
            if( type>1 && type<9 ) {
            	Enemy enemy= entityFactory.newEnemy(type, worldX, worldY);
                enemyList.add(enemy);
            }
            else    if( type>9 && type<15) { 
            	        PowerUp powerUp= entityFactory.newPowerUp(type, worldX, worldY);
                        powerUpList.add(powerUp);
                    }
                    else    if( type>19 && type<=25) { 
                    	        Platform platform= entityFactory.newPlatform(type, worldX, worldY);
                                platformList.add(platform);
                            }
            
        }
        
        return new Level(platformList, enemyList, powerUpList, character);
    }

    /*
     * public static void main(String[] args) {
        LevelGenerator l = new LevelGenerator("original", 1);
        Level level1 = l.createLevel();
    }
     * 
     */
    
}