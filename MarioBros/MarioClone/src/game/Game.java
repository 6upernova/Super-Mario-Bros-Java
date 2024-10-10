package game;

import factories.LevelGenerator;
import views.ViewController;

public class Game {
    protected Player player;
    protected LevelGenerator levelGenerator;
    protected Level currentLevel;
    protected ViewController viewController;
    

    public Game () {
       levelGenerator = new LevelGenerator(new EntityFactory(new OriginalSpriteFactory()));
       player = new Player();
    }
    
    public setViewController(ViewController viewController){
        this.viewController = viewController;
    }

    public void setObservers(){
        //To do
    }



    


}
