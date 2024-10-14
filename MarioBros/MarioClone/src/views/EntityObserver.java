package views;
import game.LogicalEntity;

@SuppressWarnings("serial")
public class EntityObserver extends GraphicObserver{

    public EntityObserver(LogicalEntity observedEntity ){
        super(observedEntity);
        update();
    }



    protected void updatePositionSize(){
        int width = this.getIcon().getIconWidth();
        int height = this.getIcon().getIconHeight();
        int x = GraphicTools.transformX(observedEntity.getX()*width,this);
        int y = GraphicTools.transformY(observedEntity.getY()*height,this);
        
        this.setBounds(x, y, width, height);
    }
}