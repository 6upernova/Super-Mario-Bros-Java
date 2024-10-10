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
        char type= 'i';
        char subType= 'i';
        int worldX=0;
        int worldY=0;
        //LEE CADA LINEA DEL TXT Y LO PASA A UN A CREATE, DESPUES CON ESO LO AÑADE
            while( (type=parser.getTypeEntity())!='F' ) {
                subType= parser.getSubTypeEntity();
                worldX = parser.getPositionXInWorld();
                worldY = parser.getPositionYInWorld();
                Entity e= createEntity(type,subType,worldX,worldY);
                level.addEntity(e,e.getX(),e.getY());
            }
    }
    
    private Entity createEntity(char type, char subType, int worldX, int worldY) {
        //SEGUN EL TIPO QUE ES CREA CON LA ENTITY
        Entity e = null;
        switch (type) {
            case 'E': { 
                        e= entityFactory.newEnemy(subType,worldX,worldY);
                    }
            case 'P': {
                        e= entityFactory.newPowerUp(subType,worldX,worldY);
                    }
            case 'B': {
                e= entityFactory.newPlatform(subType,worldX,worldY);
            }        
            }
        return e;
    }

}