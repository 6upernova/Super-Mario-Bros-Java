package launcher;

import character.Character;
import character.Keyboard;

public class CharacterThread extends Thread {
	
    protected Keyboard keyboard;
    protected Character character;
    protected long frequency = 50;

    public CharacterThread(Keyboard keyboard, Character character){
        this.keyboard = keyboard;
        this.character = character;
    }
    
    public void run(){
        while(true){
            if(java.lang.System.currentTimeMillis() - last) > frequency){
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
            last = java.lang.System.currentTimeMillis();
        }
    }
}


