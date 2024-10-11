package factories;
import game.Entity;

public class LevelGenerator {

    protected EntityFactory entityFactory;
    protected Parser parser;
    protected Level level;

    public LevelGenerator(String mode, int levelNumber) {
        entityFactory= new EntityFactory(mode);
        parser= new Parser(levelNumber);
        level= new Level();
        level.setBackGround(levelNumber);
    }

    public void createLevel(int numberLevel){
        int type=0;
        int worldX=0;
        int worldY=0;
        //LEE CADA LINEA DEL TXT Y LO PASA A UN A CREATE, DESPUES CON ESO LO AÑADE
            while(parser.hasToRead()) {
                type= parser.getType();
                worldX = parser.getPositionX();
                worldY = parser.getPositionY();
                Entity e= createEntity(type,worldX,worldY);
                level.addEntity(e,e.getX(),e.getY());
            }
    }
    
    private Entity createEntity(int type,int worldX, int worldY) {
        //SEGUN EL TIPO QUE ES CREA CON LA ENTITY
        Entity e = null;
        switch (type) {
            case 'E': { 
                        e= entityFactory.newEnemy(type,worldX,worldY);
                    }
            case 'P': {
                        e= entityFactory.newPowerUp(type,worldX,worldY);
                    }
            case 'B': {
                e= entityFactory.newPlatform(type,worldX,worldY);
            }        
            }
        return e;
    }

}