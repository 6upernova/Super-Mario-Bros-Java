package views;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import game.BoundingBox;
import game.LogicalEntity;
import tools.GraphicTools;

public abstract class GraphicObserver extends JLabel implements Observer {
   
	protected LogicalEntity observedEntity;

    public GraphicObserver(LogicalEntity observedEntity){
        super();
        this.observedEntity = observedEntity;
    }

	public void update(){
        updateSprite();
        updatePositionSize();
        setEntityBoundingBox(this);
    }

    protected void updateSprite(){
        String path = observedEntity.getSprite().getSkinPath();
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        icon = GraphicTools.scaleEntityImage(icon);
        this.setIcon(icon);
    }

    protected void updatePositionSize(){
        int x = GraphicTools.transformX(observedEntity.getX(),this);
        int y = GraphicTools.transformY(observedEntity.getY(),this);
        int width = this.getIcon().getIconWidth();
        int height = this.getIcon().getIconHeight();
        this.setBounds(x, y, width, height);
    }

    protected void setEntityBoundingBox(GraphicObserver entityObserver){
        int screenX = GraphicTools.transformX(observedEntity.getX(), entityObserver);
        int screenY = GraphicTools.transformY(observedEntity.getY(), entityObserver);
        BoundingBox hitBox = new BoundingBox(screenX, screenY, entityObserver.getWidth(), entityObserver.getHeight());
        hitBox.createExternalBounds();
        observedEntity.setBoundingBox(hitBox);   
    }
}
