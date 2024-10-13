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
            System.out.println(character.getX());
            if(keyboard.getPlayerDirection() == "right"){
                character.moveRight();
            }
            else if(keyboard.getPlayerDirection() == "left" && character.getX() > 0){
                character.moveLeft();
            }
        }
    }
}


