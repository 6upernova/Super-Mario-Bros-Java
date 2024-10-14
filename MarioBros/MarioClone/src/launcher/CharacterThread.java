package launcher;

import character.Character;
import character.Keyboard;

public class CharacterThread extends Thread {
	
    protected Keyboard keyboard;
    protected Character character;
    protected long frequency;
    protected long last;

    public CharacterThread(Keyboard keyboard, Character character){
        this.keyboard = keyboard;
        this.character = character;
        last=0;
        frequency=50;
    }
    
    public void run(){
        while(true){
            if(java.lang.System.currentTimeMillis() - last > frequency){
                if(keyboard.getPlayerDirection() == "right"){
                    character.moveRight();
                }
                else if(keyboard.getPlayerDirection() == "left" && character.getX()>0){
                    character.moveLeft();
                }
            }
            last = java.lang.System.currentTimeMillis();
        }
    }
}


