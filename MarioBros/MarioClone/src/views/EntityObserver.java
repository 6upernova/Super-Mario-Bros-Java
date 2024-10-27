package views;
import game.BoundingBox;
import game.LogicalEntity;
import tools.GraphicTools;

public class EntityObserver extends GraphicObserver{
    public EntityObserver(LogicalEntity observedEntity){
        super(observedEntity);
        update();
    }

    protected void updatePositionSize(){
        int width = this.getIcon().getIconWidth();
        int height = this.getIcon().getIconHeight();
        int x = GraphicTools.transformX(observedEntity.getX(),this);
        int y = GraphicTools.transformY(observedEntity.getY(),this);        
        this.setBounds(x, y, width, height);
    }

    
}