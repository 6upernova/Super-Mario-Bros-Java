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
        levelScreen.updateScrollRight(observedCharacter);
        super.update();
        int x = GraphicTools.transformX(observedEntity.getX(),this);
        int y = GraphicTools.transformY(observedEntity.getY(),this);
        observedCharacter.getBoundingBox().updateBoundingBoxCoords(x, y);
    }


    

}
