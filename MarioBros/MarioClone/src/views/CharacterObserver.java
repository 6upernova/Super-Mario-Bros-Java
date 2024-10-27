package views;

import character.CharacterEntity;
import tools.GraphicTools;

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
        super.update();
        levelScreen.updateScrollRight(observedCharacter);
        int x = GraphicTools.transformX(observedEntity.getX(),this);
        int y = GraphicTools.transformY(observedEntity.getY(),this);
        observedCharacter.getBoundingBox().updateBoundingBoxCoords(x, y);
    }

}
