package views;

import javax.swing.JLabel;

import game.LogicalEntity;

public abstract class GraphicObserver extends JLabel implements Observer {
    
    private LogicalEntity observedEntity;

    GraphicObserver( LogicalEntity obserEntity){
        super();
        this.observedEntity = obserEntity;

    }

    public void update(){
        

    }

    public void updateSprite(){
        String path = observedEntity.getSprite().getImagePath()
    }


}
