package launcher;

import character.Character;
import character.Keyboard;
import views.ViewConstants;

public class CharacterThread extends Thread {
	
    protected Keyboard keyboard;
    protected Character character;
    private int frameCount;
    private int spriteNumber;
    private float maximumX;

    public CharacterThread(Keyboard keyboard, Character character){
        this.keyboard = keyboard;
        this.character = character;
        this.frameCount = 0;
        this.spriteNumber = 1;
        this.maximumX = character.getX();
    }
    
    public void run(){
        String horizontalDirection;
        String verticalDirection;
    	while(true){
            horizontalDirection = keyboard.getPlayerHorizontalDirection();
            verticalDirection = keyboard.getPlayerVerticalDirection();
            frameCount++;
            System.out.println(maximumX+","+ (ViewConstants.BACKGROUND_WIDTH-ViewConstants.WIN_WIDTH)/12);
            moveCharacter(horizontalDirection, verticalDirection);
            try {
                Thread.sleep(16);
            } 
            catch (InterruptedException e) { 
                e.printStackTrace();
            }
        }
    }
    
    private void moveCharacter(String horizontalDirection, String verticalDirection) {
        if (!keyboard.isCharacterJumping()) {
            character.applyGravity();  // Aplica la gravedad cuando no esté saltando
        }
        switch (verticalDirection) {
            case "Up":
                moveUp(); // Mario sube
                break;
            case "Down":
                character.applyGravity(); // Mario baja cuando no está en el aire
                break;
        }
        // Mantén la lógica para el movimiento horizonta
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
		float maximumXFraction=maximumX-(int)maximumX;
		characterInEnd=characterInEnd(character.getX());
        if(!characterInEnd) 
            characterLeftLimit= maximumX - (ViewConstants.LEFT_CHARACTER_SPACE - maximumXFraction);
        else 
            characterLeftLimit=(ViewConstants.BACKGROUND_WIDTH-ViewConstants.WIN_WIDTH)/12;
        
		if(character.getX()>characterLeftLimit) {
            character.moveLeft("Left"+spriteNumber);
            if(frameCount%4==0) 
            	spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
		}
	}
	
	private void moveUp() {
		character.jump();
	}
	
    private boolean characterInEnd(float characterXPosition) {
    	if(characterXPosition>(ViewConstants.BACKGROUND_WIDTH-ViewConstants.WIN_WIDTH)/12)
    		return true;
    	return false;
    }
}

