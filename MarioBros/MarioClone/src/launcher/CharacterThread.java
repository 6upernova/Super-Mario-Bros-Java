package launcher;

import java.util.HashMap;
import java.util.List;
import game.Game;
import views.GraphicTools;
import views.ViewConstants;
import platforms.*;
import character.Character;
import character.CharacterCollisionManager;
import character.Keyboard;

public class CharacterThread extends Thread {
    protected Character character;
    protected Keyboard keyboard;
    private CharacterCollisionManager characterCollisionManager;
    private int frameCount;
    private int spriteNumber;
    private float maximumX;
    private HashMap<String,Platform> platformsByCoords;

    public CharacterThread(Keyboard keyboard, Game game){
        this.characterCollisionManager = new CharacterCollisionManager(game);
        this.character = game.getCurrentLevel().getCharacter();
        platformsByCoords = groupPlatformsByCoords(game.getCurrentLevel().getPlatforms());
        this.keyboard = keyboard;
        this.frameCount = 0;
        this.spriteNumber = 1;
        this.maximumX = character.getX();
    }
    
    public void run(){
        String horizontalDirection;
        String verticalDirection;
        int counter = 0;
    	while(true){
            horizontalDirection = keyboard.getPlayerHorizontalDirection();
            verticalDirection = keyboard.getPlayerVerticalDirection();
            frameCount++;
            //System.out.println(maximumX+","+ ","+ (character.getY()-1) );
            if(character.isInEnd()){
                //cambiar de musica a la del final
                // cambiar de nivel
            }
            else{
                moveCharacter(horizontalDirection, verticalDirection);
                characterCollisionManager.platformsCollisions(character);
                characterCollisionManager.enemiesCollisions(character);
                characterCollisionManager.powerUpsCollisions(character);
                
                if(character.isInvincible()){
                    if(counter > 5000){
                        //EL INVENCIBLE DURA 5seg
                        character.endInvencible();
                        counter = 0;
                    }
                    else{
                        counter += 10;
                    }
                }
            }   
            try {
                Thread.sleep(16);
            } 
            catch (InterruptedException e) { 
                e.printStackTrace();
            }
        }
    }

    
    
   
    private void moveCharacter(String horizontalDirection, String verticalDirection) {
        character.applyGravity();
        switch (verticalDirection) {
        case "Up":
            if(!character.isInAir())
                if(horizontalDirection == "None")
                    character.jump("Jumping" + keyboard.getPreviousDirection());
                else
                    character.jump("Jumping" + horizontalDirection);
            break;
    }
    	switch(horizontalDirection) {
    		case "None":
    			character.stayStill("Still" + keyboard.getPreviousDirection());
    			break;
    		case "Right":
    			moveRight();
                break;
    		case "Left":
    			moveLeft();
    			break;
    	}
    }

	private void moveRight() {
		maximumX = character.getX() > maximumX ? character.getX() : maximumX;

        if(!character.isInAir() && !isOnSolid() ){
            character.setIsInAir(true);
        }
        
        character.moveRight("Right"+spriteNumber);
        if(frameCount%4==0) 
            spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
    }
		
	private void moveLeft() {
        float characterLeftLimit=characterInMapEnd(character.getX());
        if(character.getX()>characterLeftLimit) {
            if(!character.isInAir() && !isOnSolid() ){
                character.setIsInAir(true);
            }
            character.moveLeft("Left"+spriteNumber);
            if(frameCount%4==0) 
                spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
        }
    }

    //Metodos Para LogicTools:

    private float characterInMapEnd(float characterXPosition) {
        float characterLeftLimit=0;
        float mapEnd=ViewConstants.MAP_CELLS-ViewConstants.WIN_WIDTH/ViewConstants.CELL_SIZE;
        if(characterXPosition>(mapEnd))
            characterLeftLimit=(mapEnd);
        else
            characterLeftLimit= maximumX - (ViewConstants.LEFT_CHARACTER_SPACE);
        return characterLeftLimit;
    }


    //Metodo provisional hasta tener un level data
    private HashMap<String,Platform> groupPlatformsByCoords(List<Platform> platforms){
        HashMap<String,Platform> toret = new HashMap<String,Platform>();
        for(Platform platform : platforms){
            System.out.println(platform.getX()+","+platform.getY());
            toret.put((platform.getX()+","+platform.getY()), platform);
        
        }
        return toret;
    }

    private String getKey(float x, float y){
        return (GraphicTools.roundInt(x)+","+GraphicTools.roundInt(y));
    }

    private boolean isOnSolid(){
        return platformsByCoords.get(getKey(character.getX() , character.getY()-1)) != null;
    }

}