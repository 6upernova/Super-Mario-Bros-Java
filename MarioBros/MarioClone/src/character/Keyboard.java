package character;

import java.awt.event.KeyEvent;

public class Keyboard extends java.awt.event.KeyAdapter {

    private String playerDirection;
    private String previousDirection;
    private boolean jumping;
    
    public Keyboard(){
        playerDirection="None";
        previousDirection="Right";
        jumping = false;
    }
    
    public void keyTyped(KeyEvent typedKey) {
    	if (typedKey.getKeyCode()==KeyEvent.VK_W) {
    		jumping=true;
    	}
    }
    
    
    public void keyPressed(KeyEvent pressedKey) {
            switch(pressedKey.getKeyCode()) {
                case KeyEvent.VK_D:
                    playerDirection="Right";
                    break;
                case KeyEvent.VK_A:
                    playerDirection="Left";
                    break;
            }
    }

    public void keyReleased(KeyEvent releasedKey) {
        switch(releasedKey.getKeyCode()) {
            case KeyEvent.VK_D:
                previousDirection = playerDirection;
                playerDirection = "None";
                break;
            case KeyEvent.VK_A:
                previousDirection = playerDirection;
                playerDirection = "None";
                break;
        }
    }
    
    public String getPlayerDirection() {
        return playerDirection;
    }

    public String getPreviousDirection() {
        return previousDirection;
    }
    
    public boolean isJumping() {
    	return jumping;
    }
}
