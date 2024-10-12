package views;
import game.LogicalEntity;

public class EntityObserver extends GraphicObserver{

    public EntityObserver(LogicalEntity observedEntity ){
        super(observedEntity);
        update();
    }
}