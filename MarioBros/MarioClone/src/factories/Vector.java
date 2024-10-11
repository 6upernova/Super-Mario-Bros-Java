package factories;
public class Vector<E> {
    protected E positionX;
    protected E positionY;
    protected E representacion;

    public Vector(){
        this.positionX = null;
        this.positionY = null;
        this.representacion = null;
    }
    public boolean isEmpty(){
        return positionX == null && positionY == null && representacion == null;
    }
    public void setX(E position){
        this.positionX = position;
    }
    public void setY(E position){
    this.positionY = position;
    }
    public void setRepresentation(E representationn){
        this.representacion = representationn;
    }
    public E getPositionX(){
        E posX = positionX;
        positionX = null;
        return posX;
    }
    public E getPositionY(){
        E posY = positionY;
        positionY = null;
        return posY;
    }
    public E getRepresentacion(){
        E representation = representacion;
        representacion = null;
        return representation;
    }
    public void printVector() {
        System.out.println(representacion+","+positionX+","+positionY);
    }




}