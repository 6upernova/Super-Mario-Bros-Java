package character;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Player implements KeyListener{

	protected String namePlayer;
	protected int score;
	protected JPanel game;
	private Character character;
	
	public Player(String name, JPanel panel ) {
		namePlayer= name;
		score= 0;
		game= panel;
		conectsPanelWithKeyListener();
	}
	
	public void conectsPanelWithKeyListener() {
		game.addKeyListener(this);
		game.setFocusable(true);
	}
	
	public int getScore() {
		return character.getScore();
	}
	
	public String getNamePlayer() {
		return namePlayer;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//No hay necesidad de implementar
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'a') {
			character.moveLeft();
		}
		if(e.getKeyChar() == 'd') {
			character.moveRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'w') {
				character.jump();
		}
		if(e.getKeyChar() == 'a') {
			character.moveLeft();
		}
		if(e.getKeyChar() == 'd') {
			character.moveRight();
		}
	}
}
