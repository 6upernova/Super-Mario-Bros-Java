package launcher;

import game.Game;
import views.ViewController;

public class Launcher {
    public static void main(String arg[]){
        Game game = new Game(3);
        ViewController viewController = new ViewController(game);
        game.setViewController(viewController);
        //Esto va en clase game
        game.start();
        
    }
}
