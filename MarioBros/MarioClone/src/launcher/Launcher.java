package launcher;

import character.Character;	
import factories.Sprite;
import game.Game;
import views.Observer;
import views.ViewController;
import java.io.File;

public class Launcher {
    public static void main(String arg[]){
        Game game = new Game(1);
        ViewController viewController = new ViewController(game);
        game.setViewController(viewController);


        //Esto va en clase game
        game.start();
        
    }
}
