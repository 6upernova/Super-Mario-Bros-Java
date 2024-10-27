package views;
import game.LogicalEntity;
import tools.GraphicTools;

public class EntityObserver extends GraphicObserver{
    public EntityObserver(LogicalEntity observedEntity){
        super(observedEntity);
        update();
    }


    
}