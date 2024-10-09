package game;

import factories.LevelGenerator;

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
       player = new Player();
    }
    
    public setViewController(ViewController viewController){
        this.viewController = viewController;
    }

    



    


}
