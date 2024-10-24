package launcher;
import game.Game;
import game.SoundReproducer;
import views.ViewConstants;
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
    public CharacterThread(Keyboard keyboard, Game game){
        this.characterCollisionManager = new CharacterCollisionManager(game);
        this.character = game.getCurrentLevel().getCharacter();
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
            //System.out.println(maximumX+","+ ","+ character.getY() );

            if(character.isInEnd()){
                
            }
            else{
                moveCharacter(horizontalDirection, verticalDirection);
                characterCollisionManager.platformsCollisions(character);
                if(characterCollisionManager.enemiesCollisions(character)){
                    
                }
                if(characterCollisionManager.powerUpsCollisions(character))
                    System.out.println("colision con power");
                
                if(character.isInvincible()){
                    if(counter > 5000){
                        //EL INVENCIBLE DURA 5seg
                        character.endInvencible();
                        counter = 0;
                    }
                    if(characterCollisionManager.powerUpsCollisions(character))
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
        character.moveRight("Right"+spriteNumber);
        if(frameCount%4==0) 
            spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
    }
		
	private void moveLeft() {
        float characterLeftLimit=characterInMapEnd(character.getX());
        if(character.getX()>characterLeftLimit) {
            character.moveLeft("Left"+spriteNumber);
            if(frameCount%4==0) 
                spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
        }
    }

    private float characterInMapEnd(float characterXPosition) {
        float characterLeftLimit=0;
        float mapEnd=ViewConstants.MAP_CELLS-ViewConstants.WIN_WIDTH/ViewConstants.CELL_SIZE;
        if(characterXPosition>(mapEnd))
            characterLeftLimit=(mapEnd);
        else
            characterLeftLimit= maximumX - (ViewConstants.LEFT_CHARACTER_SPACE);
        return characterLeftLimit;
    }
}