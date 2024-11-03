package entities.state.buzzyBeetle;

public class BuzzyBeetleShellState implements BuzzyBeetleState {
    protected BuzzyBeetle buzzyBeetle;

    public BuzzyBeetleShellState(BuzzyBeetle buzzyBeetle){
        this.buzzyBeetle = buzzyBeetle;
    }

    public void moveLeft(int frame) {

    }

    public void moveRight(int frame) {

    }
    
    public void hit() {
        buzzyBeetle.dead();
    }
    
}
