package views;

import character.CharacterEntity;

public class CharacterObserver extends GraphicObserver{

    protected LevelScreen levelScreen;
    protected CharacterEntity observedCharacter;

    public CharacterObserver(LevelScreen levelScreen, CharacterEntity observedCharacter){
        super(observedCharacter);
        this.levelScreen = levelScreen;
        this.observedCharacter = observedCharacter;
        super.update();
    }

    
    public void update() {
        updateSprite();
        updatePositionSize();
        levelScreen.updateScrollRight(observedCharacter);
        updateBoundingBoxCoords();
    }

    private void updateBoundingBoxCoords(){
        int x = GraphicTools.transformX(observedEntity.getX(),this);
        int y = GraphicTools.transformY(observedEntity.getY(),this);
        observedCharacter.getBoundingBox().updateBoundingBoxCoords(x, y);
    }

    public void respawn(){
        levelScreen.resetScrollbar();
        update();
    }
}
