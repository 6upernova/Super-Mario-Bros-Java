package game;
import java.awt.Rectangle;

import views.GraphicTools;
public class BoundingBox extends Rectangle {

    public BoundingBox (int x, int y, int width, int height){
        super(x,y,width,height);
    }
    
    public void updateBoundingBoxCoords(int positionInX, int positionInY) {
        this.setLocation(positionInX,positionInY);
    }    

    public void setBoundingBoxX(float newX, float oldY) {
        this.setLocation((int)newX, (int)oldY);
    }

    public void setBoundingBoxY(float oldX, float newY) {
        this.setLocation((int)oldX, (int)newY);
    }

    public boolean collision (BoundingBox entityBox) {
        return this.intersects(entityBox);
    }

    public boolean rightCollision(BoundingBox externalBounding) {
        boolean colision = getBoundsRight().intersects(externalBounding);
        //System.out.println("Colision der: "+colision);
        return colision;
    }
    
    public boolean leftCollision(BoundingBox externalBounding) {
        boolean colision = getBoundsLeft().intersects(externalBounding);  
        return colision;
    }
    
    public boolean downCollision(BoundingBox externalBounding) {
        boolean downCollision = getBoundsBottom().intersects(externalBounding);
        //System.out.println(downCollision);
        return downCollision;
    }    

    public boolean upCollision(BoundingBox externalBounding) {
        boolean upCollision = getBoundsTop().intersects(externalBounding); 
        //System.out.println(upCollision);
        return upCollision;
    }
   
     // Sub-bounding boxes

     protected BoundingBox getBoundsTop() {
        return new BoundingBox(x, y, width, height / 4);
    }

    protected BoundingBox getBoundsBottom() {
        return new BoundingBox(x, y + height * 3 / 4, width, height / 4);
    }

    protected BoundingBox getBoundsLeft() {
        return new BoundingBox(x, y, width / 4, height);
    }

    protected BoundingBox getBoundsRight() {
        return new BoundingBox(x + width * 3 / 4, y, width / 4, height);
    }
    


}