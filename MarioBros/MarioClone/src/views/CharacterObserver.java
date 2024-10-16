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
        if(GraphicTools.getScreenPositionX(observedCharacter.getX()) >= levelScreen.getViewportX())
            super.update();
        if(GraphicTools.getScreenPositionX(observedCharacter.getX())-levelScreen.getViewportX() >= ViewConstants.LEFT_CHARACTER_SPACE){
            levelScreen.updateScrollRight(observedCharacter);
        }
    }


    

}
