package game;
import enemies.*;
import powerUps.*;
import platforms.*;

public interface Visitor{
	public void visit(SuperMushroom mushroom);
	public void visit(GreenMushroom greenMushroom) ;
	public void visit(FireFlower flower);
	public void visit(Star star);
    public void visit(Coin coin) ;
	//platforms
	public void visit(Block block); 
	public void visit(Pipe pipe) ;
	public void visit(Flag flag);
	public void visit(VoidBlock voidBlock);
	public void visit(Brick brickBlock);
	public void visit(Question questionBlock);
	public void visit(Mast mast);
	public void visit(MastEnd mast);
	//en
	public void visit(Goomba goomba);
    public void visit(KoopaTroopa koopaTroopa) ;
    public void visit(PiranhaPlant piranhaPlant);
    public void visit(Lakitu lakitu);
    public void visit(BuzzyBeetle buzzyBeetle) ;
	public void visit(Spiny spiny);

}
