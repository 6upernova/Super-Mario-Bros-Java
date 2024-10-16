package launcher;

import character.Character;
import character.Keyboard;
import factories.Custom;
import factories.Original;
import factories.SpriteFactory;
import views.ViewConstants;

public class CharacterThread extends Thread {
	
    protected Keyboard keyboard;
    protected Character character;
    protected SpriteFactory spriteFactory;
    private int frameCount=0;
    private int spriteNumber=1;

    public CharacterThread(Keyboard keyboard, Character character, String mode){
        this.keyboard = keyboard;
        this.character = character;
        if( mode == "custom" ) {
 		   spriteFactory= new Custom(mode);
 		}
 		else spriteFactory= new Original(mode);
    }
    
    public void run(){
		float maximumX = character.getX();
    	while(true){
        	frameCount++;
			System.out.println(character.getX());
        	if(keyboard.getPlayerDirection() == "right" || keyboard.getPlayerDirection() == "left") {
        		if(frameCount%3==0) {
        			switch(spriteNumber) {
        			case 1: 
        				spriteNumber=2;
        				if(keyboard.getPlayerDirection()=="right") {
            				character.setSprite(spriteFactory.getCharacterRight2Sprite());
        				}
        				else
        					character.setSprite(spriteFactory.getCharacterLeft2Sprite());
        				break;
        			case 2:
        				spriteNumber=3;
        				if(keyboard.getPlayerDirection()=="right") {
            				character.setSprite(spriteFactory.getCharacterRight3Sprite());
        				}
        				else
        					character.setSprite(spriteFactory.getCharacterLeft3Sprite());
        				break;
        			case 3:
        				spriteNumber=1;
        				if(keyboard.getPlayerDirection()=="right") {
            				character.setSprite(spriteFactory.getCharacterRight1Sprite());
        				}
        				else
        					character.setSprite(spriteFactory.getCharacterLeft1Sprite());
        				break;
        			}
        		}
        	}
        	else if(keyboard.getPlayerDirection()=="none")
        		character.setSprite(spriteFactory.getCharacterStillSprite());
        	
        	if(keyboard.getPlayerDirection() == "right"){
        		character.moveRight();
				maximumX = character.getX() > maximumX ? character.getX() : maximumX;
        	}
        	else if(keyboard.getPlayerDirection() == "left" && character.getX() > maximumX - ViewConstants.LEFT_CHARACTER_SPACE){
        			character.moveLeft();
        	}
            try {
                Thread.sleep(16);
            } 
            catch (InterruptedException e) { 
                e.printStackTrace();
            }

        }
    }
}

