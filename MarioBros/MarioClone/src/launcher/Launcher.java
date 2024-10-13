package launcher;

import character.Character;
import factories.Sprite;
import views.Observer;
import views.ViewController;

public class Launcher {
    public static void main(String arg[]){
        ViewController controlador_vistas = new ViewController();

        //Esto va en clase game
        Sprite spritePrueba1 = new Sprite("assets/Sprites/MarioStanding.png");
        Character prueba1 = new Character(spritePrueba1);
        Observer characterObserver = controlador_vistas.registerEntity(prueba1);
        prueba1.registerObserver(characterObserver);

        CharacterThread thread = new CharacterThread(controlador_vistas.getKeyboard(), prueba1);
        thread.start();
        controlador_vistas.showLevelScreen();
        controlador_vistas.refresh();
    }
}
