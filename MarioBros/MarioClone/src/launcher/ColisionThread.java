package launcher;
import java.util.Iterator;
import java.util.List;

import factories.BoundingBox;
import factories.Level;
import game.Game;
import enemies.Enemy;
import powerUps.*;
import views.ViewConstants;
import platforms.*;
import character.Character;
import character.Keyboard;

public class ColisionThread extends Thread {
    protected Level level;
    protected List<Enemy> enemies;
    protected List<Platform> platforms;
    protected List<PowerUp> powerUps;
    protected Character character;
    protected Keyboard keyboard;
    private int frameCount;
    private int spriteNumber;
    private float maximumX;
    private Game game;

    public ColisionThread(Keyboard keyboard, Game game){
        this.game = game;
        this.level = game.getCurrentLevel();
        this.enemies = level.getEnemies();
        this.platforms = level.getPlatforms();
        this.powerUps = level.getPowerUps();
        this.character = level.getCharacter();
        System.out.println(enemies.size()+", "+platforms.size()+", "+powerUps.size()); 
        this.keyboard = keyboard;
        this.frameCount = 0;
        this.spriteNumber = 1;
        this.maximumX = character.getX();
        this.game = game;
    }
    public void run(){
        String horizontalDirection;
        String verticalDirection;
        int counter = 0;
    	while(true){
            horizontalDirection = keyboard.getPlayerHorizontalDirection();
            verticalDirection = keyboard.getPlayerVerticalDirection();
            frameCount++;
            //System.out.println(maximumX+","+ ","+ character.getY() );
            moveCharacter(horizontalDirection, verticalDirection);
            if(platformsColitions())
            
            if(enemiesColitions()){
                System.out.println("colision con enemigo");
            }
            if(powerUpsColitions())
                System.out.println("colision con power");
            
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
            
            try {
                Thread.sleep(10);
            } 
            catch (InterruptedException e) { 
                e.printStackTrace();
            }
        }
    }

    public boolean enemiesColitions(){
        boolean colition = false;
        Iterator<Enemy> enemiesIt = enemies.iterator();
        Enemy e;
        boolean endIteration = false;
        while(enemiesIt.hasNext() && !endIteration){
            e = enemiesIt.next();
            colition = character.colision(e);
            if (colition) {
                /*
                if(character.leftCollision(e) || character.rightCollision(e) && !character.isInvincible()){
                    character.dead();
                    game.resetLevel();
                    endIteration = true;
                }
                 */
                //if(character.downCollision(e)){
                    //e.acceptVisit(character);
                game.removeLogicalEntity(e);
                enemies.remove(e);                    
                endIteration = true;
            }
        }
        return colition;
    }
    public boolean powerUpsColitions(){
        boolean colition = false;
        Iterator<PowerUp> it = powerUps.iterator();
        PowerUp e;
        boolean endIteration = false;
        while (it.hasNext() && !endIteration) {
            e = it.next();
            colition = character.colision(e);
            //System.out.println(colition);
            if (colition) {
                e.acceptVisit(character);   
                game.removeLogicalEntity(e);  
                powerUps.remove(e);   
                endIteration = true;
            }
        }
        return colition;
    }
   
    public boolean platformsColitions(){
        boolean colition = false;
        boolean endIteration = false;
        Iterator<Platform> it = platforms.iterator();

        BoundingBox characterBox = character.getBoundingBox();
        Platform p;
        while (it.hasNext() && !endIteration){  
            p = it.next();
            colition = characterBox.collision(p.getBoundingBox());
            if(colition){
                if(p.isBreakeable()){
                    //System.out.println("es rompible");
                    if(characterBox.upCollision(p.getBoundingBox())) {
                        p.acceptVisit(character);
                        //System.out.println("colisiona la cabeza"); 
                    }
                    else if(characterBox.downCollision(p.getBoundingBox())){
                            p.acceptVisit(character);
                            //System.out.println("deberia estar arriba");                        
                            }
                    else if(characterBox.leftCollision(p.getBoundingBox())){
                            p.acceptVisit(character);
                            }
                    else if(characterBox.rightCollision(p.getBoundingBox())){
                            p.acceptVisit(character);                    
                            }      
                    endIteration = true;          
                }
            }
        }
        return colition;
    }
    //////////////////////////////////////////////////////////////////////////////////////////
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
        character.moveRight("Right"+spriteNumber);
        if(frameCount%4==0) 
            spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
    }
		
	private void moveLeft() {
		float characterLeftLimit;
    	boolean characterInEnd;
		//float maximumXFraction=maximumX-(int)maximumX;
		characterInEnd=characterInEnd(character.getX());
        if(!characterInEnd) 
            characterLeftLimit= maximumX - (ViewConstants.LEFT_CHARACTER_SPACE);
        else 
            characterLeftLimit=(ViewConstants.MAP_CELLS-ViewConstants.WIN_WIDTH)/12;
        
		if(character.getX()>characterLeftLimit) {
            character.moveLeft("Left"+spriteNumber);
            if(frameCount%4==0) 
            	spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
		}
	}
	
    private boolean characterInEnd(float characterXPosition) {
        boolean inEnd = false;
    	if(characterXPosition>(ViewConstants.MAP_CELLS-ViewConstants.WIN_WIDTH)/12)
    		inEnd = true;
    	return inEnd;
    }
}