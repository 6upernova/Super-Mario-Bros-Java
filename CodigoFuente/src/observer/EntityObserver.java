package observer;
import entities.LogicalEntity;

public class EntityObserver extends GraphicObserver{
    private boolean isActive;

    public EntityObserver(LogicalEntity observedEntity, boolean isActive){
        super(observedEntity);
        this.isActive = isActive;
        update();
    }

    public void update(){
        if(isActive){
            super.update();
        }
    }   

    public void activateObserver(){
        isActive = true;
        update();
    }
    
    
}