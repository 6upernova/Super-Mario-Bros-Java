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
        //LEE CADA LINEA DEL TXT Y LO PASA A UN A CREATE, DESPUES CON ESO LO AÑADE
        while(parser.hasToRead()) {
            type= parser.getType();
            worldX = parser.getPositionX();
            worldY = parser.getPositionY();
            Entity e= entityFactory.createEntity(type,worldX,worldY);
            
            if( type>1 && type<9 ) //e
                enemyList.add((Enemy) e);
            else    if( type>9 && type<15) //pwp
                        powerUpList.add((PowerUp) e);
                    else    if( type>19 && type<25) //pltfrm
                                platformList.add((Platform) e);
        }
        return new Level(platformList, enemyList, powerUpList);
    }

}