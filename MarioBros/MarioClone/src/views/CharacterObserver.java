package views;

<<<<<<< HEAD
import character.CharacterEntity;

public class CharacterObserver extends GraphicObserver{

    LevelScreen levelScreen;
    CharacterEntity character;

    public CharacterObserver(LevelScreen levelScreen, CharacterEntity character){
        super(character);
        update();
    }

    
    public void update() {
        super.update();
        this.setFocusable(true);
    }
    


}
=======
public class CharacterObserver {

}
>>>>>>> 0b5b8f05ac19619f42eb6c918dcbd8cb5b3d8629
