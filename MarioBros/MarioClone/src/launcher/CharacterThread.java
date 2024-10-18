package launcher;

import character.Character;
import character.Keyboard;
import views.ViewConstants;

public class CharacterThread extends Thread {
	
    protected Keyboard keyboard;
    protected Character character;
    private int frameCount=0;
    private int spriteNumber=1;

    public CharacterThread(Keyboard keyboard, Character character){
        this.keyboard = keyboard;
        this.character = character;
    }
    
    public void run(){
    	float maximumX = character.getX();
		float characterLeftLimit;
		float maximumXFraction;
    	boolean characterInEnd;
    	
        String direction;
    	while(true){
    		maximumXFraction=maximumX-(int)maximumX;
            direction = keyboard.getPlayerDirection();
            characterInEnd=characterInEnd(character.getX());
            if(!characterInEnd) 
                characterLeftLimit= maximumX - (ViewConstants.LEFT_CHARACTER_SPACE-maximumXFraction);
            else 
                characterLeftLimit=(ViewConstants.BACKGROUND_WIDTH-ViewConstants.WIN_WIDTH)/12;
            frameCount++;
            System.out.println(maximumX+","+ (ViewConstants.BACKGROUND_WIDTH-ViewConstants.WIN_WIDTH)/12);
            if(direction.equals("none"))
                character.stayStill("Still");
            else if(direction.equals( "right")){
                maximumX = character.getX() > maximumX ? character.getX() : maximumX;
                character.moveRight("Right"+spriteNumber);
                if(frameCount%4==0) 
                    spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
            }
            else if(direction.equals("left") && character.getX() > characterLeftLimit ){
                character.moveLeft("Left"+spriteNumber);
                if(frameCount%4==0) 
                    spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;         
            }
            try {
                Thread.sleep(16);
            } 
            catch (InterruptedException e) { 
                e.printStackTrace();
            }
        }
    }
    
    private boolean characterInEnd(float characterXPosition) {
    	if(characterXPosition>(ViewConstants.BACKGROUND_WIDTH-ViewConstants.WIN_WIDTH)/12)
    		return true;
    	return false;
    }
}

