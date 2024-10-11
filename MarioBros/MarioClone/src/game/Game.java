package game;

import character.Player;
import factories.Level;
import factories.LevelGenerator;
import views.ViewController;

public class Game {
	
    protected Player player;
    protected LevelGenerator levelGenerator;
    protected Level currentLevel;
    protected ViewController viewController;
    

    public Game () {
        //String modo = custom;
        //pasarle a entity facotory modo=custom si se quiere modo custom
        //si se quiere crear modo original asignar modo = "original"
        levelGenerator = new LevelGenerator(new EntityFactory(modo);
        player = new Player();//Acá va el nombre que ponga el jugador y el panel donde se sitúa (?).
    }
    
    public void setViewController(ViewController viewController){
        this.viewController = viewController;
    }

    public void setObservers(){
        //To do
    }



    


}
