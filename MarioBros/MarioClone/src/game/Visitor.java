package game;

public class Visitor {

	public void visit(Element e) {
		e.acceptVisit(this);
	}
}
