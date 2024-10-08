package game;

public abstract class Entity {

    protected int x;
    protected int y;
    protected Sprite sprite;
    protected Observer observer;

    protected Entity(Sprite sprite, int x, int y){
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }

    public Sprite getSprite(){
        return sprite;
    }

    public Sprite setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    public registerObserver(Observer observer){
        this.observer = observer;
    }

    public setX(int x){
        this.x = x;
    }

    public setY(int y){
        this.y = y;
    }

    public getX(){
        return x;
    }

    public getY(){
        return y;
    }

}
