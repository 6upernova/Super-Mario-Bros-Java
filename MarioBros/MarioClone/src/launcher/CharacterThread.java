package launcher;

import character.Character;
import character.Keyboard;

public class CharacterThread extends Thread {
	
    protected Keyboard keyboard;
    protected Character character;

    public CharacterThread(Keyboard keyboard, Character character){
        this.keyboard = keyboard;
        this.character = character;
    }
    
    public void run(){
        while(true){
            
            if(keyboard.getPlayerDirection() == "right"){
                character.moveRight();
            }
            else if(keyboard.getPlayerDirection() == "left" && character.getX()>0){
                character.moveLeft();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}


