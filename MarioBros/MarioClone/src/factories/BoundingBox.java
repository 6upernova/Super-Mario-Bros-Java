package factories;
import java.awt.Rectangle;
public class BoundingBox extends Rectangle {

    public BoundingBox (int x, int y, int width, int height){
        super(x,y,width,height);
    }

    public void updateBoundingBoxCoords(int positionInX, int positionInY) {
        this.setLocation(positionInX,positionInY);
    }
    public boolean collision (BoundingBox entityBox) {
        return this.intersects(entityBox);
    }

    public void setBoundingBoxX(float newX, float oldY) {
        this.setLocation((int)newX, (int)oldY);
    }

    public void setBoundingBoxY(float oldX, float newY) {
        this.setLocation((int)oldX, (int)newY);
    }
    

    public boolean rightCollision(BoundingBox externalBounding) {
        /*
        double rightDistance = externalBounding.getX() - (getX() + getWidth());
        double downDistance = externalBounding.getY() - (getY() + getHeight());
        double upDistance = (externalBounding.getY() + externalBounding.getHeight()) - getY();
    
        // Si la distancia derecha es la menor y la intersección ocurre en el rango vertical
        return Math.abs(rightDistance) < Math.abs(downDistance) 
        && Math.abs(rightDistance) < Math.abs(upDistance); */
        boolean rightCollision = !getBoundsRight().intersection(externalBounding).isEmpty();
        //System.out.println(rightCollision);
        return rightCollision;
    }
    
    public boolean leftCollision(BoundingBox externalBounding) {
        /*
        double leftDistance = (externalBounding.getX() + externalBounding.getWidth()) - getX();
        double downDistance = externalBounding.getY() - (getY() + getHeight());
        double upDistance = (externalBounding.getY() + externalBounding.getHeight()) - getY();
    
        // Si la distancia izquierda es la menor y la intersección ocurre en el rango vertical
        return Math.abs(leftDistance) < Math.abs(downDistance) 
               && Math.abs(leftDistance) < Math.abs(upDistance);
         */
        boolean leftCollision = !getBoundsLeft().intersection(externalBounding).isEmpty();
        //System.out.println(leftCollision);
        return leftCollision;
    }
    
    public boolean downCollision(BoundingBox externalBounding) {
        boolean downCollision = !getBoundsRight().intersection(externalBounding).isEmpty();
        //System.out.println(downCollision);
        return downCollision;
    }    

    public boolean upCollision(BoundingBox externalBounding) {
        /*        
        //chequeo si esta estidad colisiona por encima de otraç
        boolean colision = false;
        double y = getY();
        double externalY = externalBounding.getHeight();
        if(y<externalY){
            colision = false;
        }
        else{
            colision = getX() >= externalBounding.getX() && getX()+getWidth() <= externalBounding.getX()+externalBounding.getWidth();
            System.out.println("cheke");
        }        
        
        */
        boolean upCollision = !getBoundsTop().intersection(externalBounding).isEmpty(); 
        //System.out.println(upCollision);
        return upCollision;
    }
   
    protected BoundingBox getBoundsTop(){
        return new BoundingBox(x, height, width, height);
    }
    protected BoundingBox getBoundsBottom(){
        return new BoundingBox(x, y, width, y);
    }
    protected BoundingBox getBoundsLeft(){
        return new BoundingBox(x, y, x, height);
    }
    protected BoundingBox getBoundsRight(){
        return new BoundingBox(width, y, width, height);
    } 
    


}