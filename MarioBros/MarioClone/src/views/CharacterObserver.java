package views;

import character.CharacterEntity;

public class CharacterObserver extends GraphicObserver{

    protected LevelScreen levelScreen;
    protected CharacterEntity observedCharacter;

    public CharacterObserver(LevelScreen levelScreen, CharacterEntity observedCharacter){
        super(observedCharacter);
        this.levelScreen = levelScreen;
        this.observedCharacter = observedCharacter;
        update();
    }

    
    public void update() {
        //hacer metodos privados para las comparaciones
        levelScreen.updateScrollRight(observedCharacter);
        super.update();
    }


    

}
