package platforms;
import factories.Sprite;
import game.Visitor;
import views.GraphicObserver;

public class MastEnd extends Platform{
    static final private boolean isBreakeable = false;

    public MastEnd(Sprite sprite, int positionInX, int positionInY) {
        super(sprite, positionInX, positionInY, isBreakeable);
    }
    public void acceptVisit(Visitor visitor) {
        visitor.visit(this);
    }
    public void setObserver(GraphicObserver observer) {
        this.observer = observer;
    }
}

