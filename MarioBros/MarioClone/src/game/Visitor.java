package game;

import enemies.BuzzyBeetle;
import enemies.Goomba;
import enemies.KoopaTroopa;
import enemies.Lakitu;
import enemies.PiranhaPlant;
import enemies.Spiny;
import platforms.Block;
import platforms.Brick;
import platforms.Flag;
import platforms.Pipe;
import platforms.Question;
import platforms.VoidBlock;
import powerUps.Coin;
import powerUps.FireFlower;
import powerUps.GreenMushroom;
import powerUps.Star;
import powerUps.SuperMushroom;

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
	public void visit(Brick voidBlock);
	public void visit(Question voidBlock);
	//en
	public void visit(Goomba goomba);
    public void visit(KoopaTroopa koopaTroopa) ;
    public void visit(PiranhaPlant piranhaPlant);
    public void visit(Lakitu lakitu);
    public void visit(BuzzyBeetle buzzyBeetle) ;
	public void visit(Spiny spiny);

}
