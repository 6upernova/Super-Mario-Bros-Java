package factories;

import java.util.LinkedList;
import java.util.List;
import game.Entity;
import platforms.Platform;
import powerUps.PowerUp;
import enemies.Enemy;

public class LevelGenerator {

    protected EntityFactory entityFactory;
    protected Parser parser;

    public LevelGenerator(String mode, int levelNumber) {
        entityFactory= new EntityFactory(mode);
        parser= new Parser(levelNumber);
    }

    public Level createLevel(int numberLevel){
        int type=0;
        int worldX=0;
        int worldY=0;
        List<Platform> platformList = new LinkedList<Platform>();
        List<Enemy> enemyList = new LinkedList<Enemy>();
        List<PowerUp> powerUpList = new LinkedList<PowerUp>();
        while(parser.hasToRead()) {
        	getsAtributions(type, worldX, worldY);
            if( type>1 && type<9 ) {
            	Enemy enemy= entityFactory.newEnemy(type, worldX, worldY);
                enemyList.add(enemy);
            }
            else    if( type>9 && type<15) { 
            	        PowerUp powerUp= entityFactory.newPowerUp(type, worldX, worldY);
                        powerUpList.add(powerUp);
                    }
                    else    if( type>19 && type<25) { 
                    	        Platform platform= entityFactory.newPlatform(type, worldX, worldY);
                                platformList.add(platform);
                            }
            
        }
        return new Level(platformList, enemyList, powerUpList);
    }

	private void getsAtributions(int type, int worldX, int worldY) {
        type= parser.getType();
        worldX = parser.getPositionX();
        worldY = parser.getPositionY();
	}
    
}