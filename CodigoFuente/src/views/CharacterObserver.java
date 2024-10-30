package views;

import entities.character.CharacterEntity;
import tools.GraphicTools;

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
        updateBoundingBoxCoords();
        levelScreen.updateScrollRight(observedCharacter);
        
    }

    private void updateBoundingBoxCoords(){
        int x = GraphicTools.transformX(observedCharacter.getX(),this);
        int y = GraphicTools.transformY(observedCharacter.getY(),this);
        observedCharacter.getBoundingBox().updateBoundingBoxCoords(x, y);
    }


    public void respawn(){
        update();
        levelScreen.resetScrollbar();
        
    }

    
}
