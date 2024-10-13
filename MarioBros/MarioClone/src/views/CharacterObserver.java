package views;

import character.CharacterEntity;

public class CharacterObserver extends GraphicObserver{

    LevelScreen levelScreen;
    CharacterEntity character;

    public CharacterObserver(LevelScreen levelScreen, CharacterEntity character){
        super(character);
        this.levelScreen = levelScreen;
        update();
    }

    
    public void update() {
        super.update();
        levelScreen.updateScrollRight(character);
    }
    


}
